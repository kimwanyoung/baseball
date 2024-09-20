package domain.display;

import domain.game.Level;
import domain.game.Menu;
import domain.log.Log;
import domain.log.Logs;
import domain.numbers.BaseballNumber;
import domain.numbers.BaseballNumbers;
import domain.score.BaseballScore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.Parser.parseCharArrToIntArr;
import static utils.Parser.parseCharToInt;

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
        System.out.println("< 게임을 시작합니다. >");
    }

    public void printBaseballScore(BaseballScore baseballScore) {
        System.out.println(baseballScore);
    }

    public void printFinishMessage() {
        System.out.println("축하합니다 정답입니다.!\n");
    }

    public BaseballNumbers readBaseballNumber(int size) {
        char[] inputCharNumbers = scanner.next().toCharArray();
        List<Integer> parseInputValues = parseCharArrToIntArr(inputCharNumbers);
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        for (int inputNumber : parseInputValues) {
            baseballNumbers.add(new BaseballNumber(inputNumber));
        }
        return new BaseballNumbers(baseballNumbers, size);
    }

    public Level readGameLevel() {
        System.out.println("설정하고자 하는 자리수를 입력하세요.");
        int parseLevel = parseCharToInt(scanner.next().charAt(0));
        Level level = new Level(parseLevel);
        System.out.println(level + "자리수 난이도로 설정되었습니다.\n");
        return level;
    }

    public void printAllGameLogs(Logs logs) {
        System.out.println("< 게임 기록 보기 >");
        for (String logStringFormat : logs.getLogsPrintFormat()) System.out.println(logStringFormat);
    }

    public void printExitMessage() {
        System.out.println("< 숫자 야구 게임을 종료합니다 >\n");
    }
}
