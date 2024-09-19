package domain.numbers;

import static constants.BaseballConstants.MAX_NUMBER;
import static constants.BaseballConstants.MIN_NUMBER;

public class BaseballNumber {
    private final int baseballNumber;

    public BaseballNumber(int baseballNumber) {
        validateRange(baseballNumber);
        this.baseballNumber = baseballNumber;
    }

    private void validateRange(int baseballNumber) {
        if (baseballNumber < MIN_NUMBER || baseballNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("숫자는 " + MIN_NUMBER + " 이상 " + MAX_NUMBER + " 이하여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseballNumber that = (BaseballNumber) o;

        return baseballNumber == that.baseballNumber;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(baseballNumber);
    }
}
