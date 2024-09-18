public enum Level {
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int level;

    Level(int level) {
        this.level = level;
    }

    public static Level getLevelFromStringInput(String input) {
        validateNumericInput(input);
        int parseInput = Integer.parseInt(input);
        for(Level level: Level.values()) {
            if(level.level == parseInput) return level;
        }

        throw new IllegalArgumentException("3, 4, 5단계만 입력 가능합니다.");
    }

    public int getValue() {
        return this.level;
    }

    private static void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.level);
    }
}
