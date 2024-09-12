public class BaseballScore {

    private int strike;
    private int ball;

    public BaseballScore(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isThreeStrike() {
        return this.strike == 3;
    }

    @Override
    public String toString() {
        if(this.strike == 0 && this.ball == 0) return "아웃!";
        return this.strike + "스트라이크 " + this.ball + "볼";
    }
}
