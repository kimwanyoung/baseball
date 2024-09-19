package domain.game;

import domain.display.Display;
import domain.level.Level;
import domain.log.Log;
import domain.log.Logs;
import domain.numbers.BaseballNumbers;
import domain.score.BaseballScore;

import static constants.BaseballConstants.MINIMUM_ATTEMPT_COUNT;

public class BaseballGame {
    private final Display display;
    private final Logs logs;
    private Level level = Level.THREE;
    private int currentStep = 1;
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
        BaseballNumbers randomNumbers = BaseballNumbers.generateRandomNumbers(level);
        Log log = new Log(currentStep, MINIMUM_ATTEMPT_COUNT);
        display.printGameStartMessage();

        while (true) {
            BaseballNumbers userBaseballNumbers = display.readBaseballNumber(level);
            BaseballScore baseballScore = randomNumbers.calculateScore(userBaseballNumbers);
            display.printBaseballScore(baseballScore);
            log.increaseAttemptCount();

            if (baseballScore.isGameOver(level)) {
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
        this.currentStep++;
    }

    private void queryLogs() {
        display.printAllGameLogs(logs);
    }

    private void exitGame() {
        display.printExitMessage();
        this.flag = false;
    }
}
