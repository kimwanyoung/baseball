package domain.game;

import java.util.List;

public class Level {

    private static final List<Integer> LEVEL_RANGE = List.of(3, 4, 5);
    private final int level;

    public Level(String level) {
        validateNumericInput(level);
        int parseLevel = Integer.parseInt(level);
        validateRange(parseLevel);
        this.level = parseLevel;
    }

    public Level(int level) {
        validateRange(level);
        this.level = level;
    }

    public int getValue() {
        return this.level;
    }

    private void validateRange(int level) {
        if (!LEVEL_RANGE.contains(level)) {
            throw new IllegalArgumentException("난이도는 3, 4, 5만 입력가능합니다.");
        }
    }

    private void validateNumericInput(String input) {
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
