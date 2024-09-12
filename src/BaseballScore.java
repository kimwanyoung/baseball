public record BaseballScore(int strike, int ball) {

    @Override
    public String toString() {
        if(this.strike == 0 && this.ball == 0) return "아웃!";
        return this.strike + "스트라이크 " + this.ball + "볼";
    }
}
