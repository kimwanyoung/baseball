package domain.numbers;

import domain.score.BaseballScore;

import java.util.*;

public class BaseballNumbers {
    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers, int size) {
        validateDuplicateNumber(baseballNumbers);
        validateBaseballNumbersLength(baseballNumbers, size);
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballNumbers generateRandomNumbers(int size) {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();

        while (baseballNumbers.size() < size) {
            addUniqueNumber(baseballNumbers);
        }

        return new BaseballNumbers(baseballNumbers, size);
    }

    private static void addUniqueNumber(List<BaseballNumber> baseballNumbers) {
        Random random = new Random();
        int randomNumber = random.nextInt(9) + 1;
        BaseballNumber baseballNumber = new BaseballNumber(randomNumber);
        if (!baseballNumbers.contains(baseballNumber)) {
            baseballNumbers.add(baseballNumber);
        }
    }

    public BaseballScore calculateScore(BaseballNumbers otherNumbers) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < this.baseballNumbers.size(); i++) {
            if (this.baseballNumbers.get(i).equals(otherNumbers.baseballNumbers.get(i))) {
                strike++;
                continue;
            }
            if (this.baseballNumbers.contains(otherNumbers.baseballNumbers.get(i))) {
                ball++;
            }
        }
        return new BaseballScore(strike, ball);
    }

    private void validateBaseballNumbersLength(List<BaseballNumber> baseballNumbers, int size) {
        if (baseballNumbers.size() != size) {
            throw new IllegalArgumentException(size + "자리의 숫자만 입력 가능합니다.");
        }
    }

    private void validateDuplicateNumber(List<BaseballNumber> baseballNumbers) {
        Set<BaseballNumber> baseballNumberSet = new HashSet<>(baseballNumbers);
        if (baseballNumbers.size() != baseballNumberSet.size()) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }
}
