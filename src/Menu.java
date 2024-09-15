public enum Menu {
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

        throw new IllegalArgumentException("1, 2, 3만 입력 가능합니다.");
    }
}
