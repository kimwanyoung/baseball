package domain.log;

public class Log {
    private final int step;
    private int attemptCount;

    public Log(int step, int attemptCount) {
        this.step = step;
        this.attemptCount = attemptCount;
    }

    public void increaseAttemptCount() {
        this.attemptCount += 1;
    }

    @Override
    public String toString() {
        return step + "번째 게임 : 시도 횟수 - " + attemptCount;
    }
}
