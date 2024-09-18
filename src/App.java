import domain.game.BaseballGame;
import domain.display.Display;
import domain.log.Logs;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Display display = new Display(scanner);

        Logs logs = new Logs(new ArrayList<>());

        BaseballGame baseballGame = new BaseballGame(display, logs);
        baseballGame.run();
    }
}
