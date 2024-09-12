public class BaseballGame {

    private final Display display;

    public BaseballGame(Display display) {
        this.display = display;
    }

    public void start() {
        BaseballNumbers randomNumbers = RandomNumbersGenerator.generate();

        int menu = display.printMenuAndGetInput();
        display.printGameStartMessage();
        BaseballNumbers baseballNumbers = display.readBaseballNumber();
    }
}
