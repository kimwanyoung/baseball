import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {
    private static final int MAX_LENGTH = 3;
    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validateDuplicateNumber(baseballNumbers);
        validateBaseballNumbersLength(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    public void validateBaseballNumbersLength(List<BaseballNumber> baseballNumbers) {
        if(baseballNumbers.size() != MAX_LENGTH) {
            throw new IllegalArgumentException(MAX_LENGTH + "자리의 숫자만 입력 가능합니다.");
        }
    }

    private void validateDuplicateNumber(List<BaseballNumber> baseballNumbers) {
        Set<BaseballNumber> baseballNumberSet = new HashSet<>(baseballNumbers);
        if(baseballNumbers.size() != baseballNumberSet.size()) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public BaseballScore calculateScore(BaseballNumbers otherNumbers) {
        int strike = 0;
        int ball = 0;
        for(int i = 0; i < this.baseballNumbers.size(); i++) {
            if(this.baseballNumbers.get(i).equals(otherNumbers.baseballNumbers.get(i))) {
                strike++;
                continue;
            }
            if(this.baseballNumbers.contains(otherNumbers.baseballNumbers.get(i))){
                ball++;
            }
        }
        return new BaseballScore(strike, ball);
    }
}
