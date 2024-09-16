public class BaseballGame {

    private static final int MINIMUM_ATTEMPT_COUNT = 0;
    private final Display display;
    private final Logs logs;
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
                case START -> startGame();
                case QUERY -> queryLogs();
                case EXIT -> exitGame();
            }
        } while(flag);
    }

    private void startGame() {
        BaseballNumbers randomNumbers = RandomNumbersGenerator.generate();
        Log log = new Log(currentStep, MINIMUM_ATTEMPT_COUNT);
        display.printGameStartMessage();

        while (true) {
            BaseballNumbers userBaseballNumbers = display.readBaseballNumber();
            BaseballScore baseballScore = randomNumbers.calculateScore(userBaseballNumbers);
            display.printBaseballScore(baseballScore);
            log.increaseAttemptCount();

            if (baseballScore.isThreeStrike()) {
                clearCurrentGameAndSave(log);
                break;
            }
        }
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
