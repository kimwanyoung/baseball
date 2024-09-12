public class BaseballScore {

    private int strike = 0;
    private int ball = 0;

    public BaseballScore(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public String toString() {
        return this.strike + "스트라이크 " + this.ball + "볼";
    }
}
