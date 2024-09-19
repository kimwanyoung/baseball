package domain.score;

import domain.game.Level;

public class BaseballScore {

    private final int strike;
    private final int ball;

    public BaseballScore(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isGameOver(Level level) {
        return this.strike == level.getValue();
    }

    @Override
    public String toString() {
        if (this.strike == 0 && this.ball == 0) return "아웃!";
        return this.strike + "스트라이크 " + this.ball + "볼";
    }
}
