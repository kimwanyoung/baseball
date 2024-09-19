package domain.game;

import java.util.List;

public class Level {

    private static final List<Integer> VALID_LEVELS = List.of(3, 4, 5);
    private final int level;

    public Level(int level) {
        validateRange(level);
        this.level = level;
    }

    public int getValue() {
        return this.level;
    }

    private void validateRange(int level) {
        if (!VALID_LEVELS.contains(level)) throw new IllegalArgumentException("난이도는 3, 4, 5만 입력가능합니다.");
    }

    @Override
    public String toString() {
        return String.valueOf(this.level);
    }
}
