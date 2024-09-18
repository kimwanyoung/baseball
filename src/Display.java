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
        System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");

        return Menu.getMenuFromString(scanner.next());
    }

    public void printGameStartMessage() {
        System.out.println();
        System.out.println("< 게임을 시작합니다. >");
    }

    public void printBaseballScore(BaseballScore baseballScore) {
        System.out.println(baseballScore);
    }

    public void printFinishMessage() {
        System.out.println("축하합니다 정답입니다.!");
        System.out.println();
    }

    public BaseballNumbers readBaseballNumber(Level level) {
        char[] inputNumbers = scanner.next().toCharArray();
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        for (char inputNumber : inputNumbers) {
            baseballNumbers.add(new BaseballNumber(inputNumber));
        }
        return new BaseballNumbers(baseballNumbers, level);
    }

    public Level readGameLevel() {
        System.out.println();
        System.out.println("설정하고자 하는 자리수를 입력하세요.");
        Level level = Level.getLevelFromStringInput(scanner.next());
        System.out.println(level + "자리수 난이도로 설정되었습니다.");
        System.out.println();
        return level;
    }

    public void printAllGameLogs(Logs logs) {
        System.out.println();
        System.out.println("< 게임 기록 보기 >");
        for(Log log : logs.getAllLogs()) System.out.println(log);
        System.out.println();
    }

    public void printExitMessage() {
        System.out.println();
        System.out.println("< 숫자 야구 게임을 종료합니다 >");
    }
}
