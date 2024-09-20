package domain.log;

public class Log {
    private int attemptCount;

    public Log(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public void increaseAttemptCount() {
        this.attemptCount += 1;
    }

    @Override
    public String toString() {
        return "시도 횟수 - " + attemptCount;
    }
}
