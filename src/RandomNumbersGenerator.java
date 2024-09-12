import java.util.ArrayList;
import java.util.List;

public class RandomNumbersGenerator {
    private static final int MAX_LENGTH = 3;

    public static BaseballNumbers generate() {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();

        while (baseballNumbers.size() < MAX_LENGTH) {
            addUniqueNumber(baseballNumbers);
        }

        return new BaseballNumbers(baseballNumbers);
    }

    private static void addUniqueNumber(List<BaseballNumber> baseballNumbers) {
        int randomNumber = (int) ((Math.random() * 9) + 1);;
        BaseballNumber baseballNumber = new BaseballNumber(randomNumber);
        if (!baseballNumbers.contains(baseballNumber)) {
            baseballNumbers.add(baseballNumber);
        }
    }
}
