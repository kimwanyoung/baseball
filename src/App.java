import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Display display = new Display(scanner);

        BaseballGame baseballGame = new BaseballGame(display);
        baseballGame.start();
    }
}
