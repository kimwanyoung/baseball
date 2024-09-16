import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Display {

    private final Scanner scanner;

    public Display(Scanner scanner) {
        this.scanner = scanner;
    }

    public Menu printMenuAndGetInput() {
        System.out.println("환영합니다! 원하시는 번호를 입력해주세요.");
        System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");

        return Menu.getMenuFromString(scanner.next());
    }

    public void printGameStartMessage() {
        System.out.println("< 게임을 시작합니다. >");
    }

    public void printBaseballScore(BaseballScore baseballScore) {
        System.out.println(baseballScore);
    }

    public void printFinishMessage() {
        System.out.println("축하합니다 정답입니다.!");
    }

    public BaseballNumbers readBaseballNumber() {
        char[] inputNumbers = scanner.next().toCharArray();
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        for (char inputNumber : inputNumbers) {
            baseballNumbers.add(new BaseballNumber(inputNumber));
        }
        return new BaseballNumbers(baseballNumbers);
    }

    public void printAllGameLogs(Logs logs) {
        for(Log log : logs.getAllLogs()) System.out.println(log);
    }

    public void printExitMessage() {
        System.out.println("게임을 종료합니다.");
    }
}
