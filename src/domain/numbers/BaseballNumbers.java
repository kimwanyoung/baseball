package domain.numbers;

import domain.level.Level;
import domain.score.BaseballScore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {
    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers, Level level) {
        validateDuplicateNumber(baseballNumbers);
        validateBaseballNumbersLength(baseballNumbers, level);
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballNumbers generateRandomNumbers(Level level) {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();

        while (baseballNumbers.size() < level.getValue()) {
            addUniqueNumber(baseballNumbers);
        }

        return new BaseballNumbers(baseballNumbers, level);
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
    private static void addUniqueNumber(List<BaseballNumber> baseballNumbers) {
        int randomNumber = (int) ((Math.random() * 9) + 1);
        BaseballNumber baseballNumber = new BaseballNumber(randomNumber);
        if (!baseballNumbers.contains(baseballNumber)) {
            baseballNumbers.add(baseballNumber);
        }
    }

    private void validateBaseballNumbersLength(List<BaseballNumber> baseballNumbers, Level level) {
        if (baseballNumbers.size() != level.getValue()) {
            throw new IllegalArgumentException(level.getValue() + "자리의 숫자만 입력 가능합니다.");
        }
    }

    private void validateDuplicateNumber(List<BaseballNumber> baseballNumbers) {
        Set<BaseballNumber> baseballNumberSet = new HashSet<>(baseballNumbers);
        if (baseballNumbers.size() != baseballNumberSet.size()) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }
}
