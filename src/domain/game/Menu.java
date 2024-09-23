package domain.game;

import java.util.Arrays;

public enum Menu {
    SET_LEVEL("0"),
    START("1"),
    QUERY("2"),
    EXIT("3");

    private final String menuCommand;

    Menu(String menuCommand) {
        this.menuCommand = menuCommand;
    }

    public static Menu getMenuFromString(String input) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.menuCommand.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 숫자를 입력해주세요!"));
    }
}
