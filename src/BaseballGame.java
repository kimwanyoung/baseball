public class BaseballGame {

    private final Display display;
    private boolean flag = true;

    public BaseballGame(Display display) {
        this.display = display;
    }

    public void run() {
        do {
            Menu menu = display.printMenuAndGetInput();

            switch (menu) {
                case START -> startGame();
                // TODO: 기록 조회 위한 기능 추가 구현 필요
                case QUERY -> System.out.println("조회");
                case EXIT -> exitGame();
            }
        } while(flag);
    }

    private void startGame() {
        BaseballNumbers randomNumbers = RandomNumbersGenerator.generate();
        display.printGameStartMessage();

        while (true) {
            BaseballNumbers userBaseballNumbers = display.readBaseballNumber();
            BaseballScore baseballScore = randomNumbers.calculateScore(userBaseballNumbers);
            display.printBaseballScore(baseballScore);

            if (baseballScore.isThreeStrike()) {
                display.printFinishMessage();
                break;
            }
        }
    }

    private void exitGame() {
        display.printExitMessage();
        this.flag = false;
    }
}
