package domain.game;

import domain.display.Display;
import domain.log.Log;
import domain.log.Logs;
import domain.numbers.BaseballNumbers;
import domain.score.BaseballScore;

import static constants.BaseballConstants.MINIMUM_ATTEMPT_COUNT;

public class BaseballGame {
    private final Display display;
    private final Logs logs;
    private Level level = new Level(3);
    private boolean flag = true;

    public BaseballGame(Display display, Logs logs) {
        this.display = display;
        this.logs = logs;
    }

    public void run() {
        do {
            Menu menu = display.printMenuAndGetInput();

            switch (menu) {
                case SET_LEVEL -> {
                    setGameLevel();
                    startGame();
                }
                case START -> startGame();
                case QUERY -> queryLogs();
                case EXIT -> exitGame();
            }
        } while (flag);
    }

    private void startGame() {
        int numberLength = this.level.getValue();
        BaseballNumbers randomNumbers = BaseballNumbers.generateRandomNumbers(numberLength);
        Log log = new Log(MINIMUM_ATTEMPT_COUNT);
        display.printGameStartMessage();

        while (true) {
            BaseballNumbers userBaseballNumbers = display.readBaseballNumber(numberLength);
            BaseballScore baseballScore = randomNumbers.calculateScore(userBaseballNumbers);
            display.printBaseballScore(baseballScore);
            log.increaseAttemptCount();

            if (baseballScore.isGameOver(numberLength)) {
                clearCurrentGameAndSave(log);
                break;
            }
        }
    }

    private void setGameLevel() {
        this.level = display.readGameLevel();
    }

    private void clearCurrentGameAndSave(Log log) {
        display.printFinishMessage();
        logs.save(log);
    }

    private void queryLogs() {
        display.printAllGameLogs(logs);
    }

    private void exitGame() {
        display.printExitMessage();
        this.flag = false;
    }
}
