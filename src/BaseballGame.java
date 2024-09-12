public class BaseballGame {

    private final Display display;

    public BaseballGame(Display display) {
        this.display = display;
    }

    public void start() {
        BaseballNumbers randomNumbers = RandomNumbersGenerator.generate();
        int menu = display.printMenuAndGetInput();
        display.printGameStartMessage();

        while(true) {
            BaseballNumbers userBaseballNumbers = display.readBaseballNumber();
            BaseballScore baseballScore = randomNumbers.calculateScore(userBaseballNumbers);
            display.printBaseballScore(baseballScore);

            if(baseballScore.isThreeStrike()) {
                display.printFinishMessage();
                break;
            }
        }
    }
}
