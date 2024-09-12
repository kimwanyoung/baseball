public class BaseballNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int baseballNumber;

    public BaseballNumber(char baseballNumber) {
        validateIsNumeric(baseballNumber);
        int numericValue = Character.getNumericValue(baseballNumber);
        validateRange(numericValue);
        this.baseballNumber = numericValue;
    }

    public BaseballNumber(int baseballNumber) {
        validateRange(baseballNumber);
        this.baseballNumber = baseballNumber;
    }

    private void validateIsNumeric(char baseballNumber) {
        if(!Character.isDigit(baseballNumber)) throw new IllegalArgumentException("정수만 입력가능합니다.");
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
