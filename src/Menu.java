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
        for(Menu menu : Menu.values()) {
            if(menu.menuCommand.equals(input)) return menu;
        }

        throw new IllegalArgumentException("올바른 숫자를 입력해주세요!");
    }
}
