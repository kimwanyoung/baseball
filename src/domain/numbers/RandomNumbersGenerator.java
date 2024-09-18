package domain.numbers;

import domain.level.Level;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbersGenerator {

    public static BaseballNumbers generate(Level level) {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();

        while (baseballNumbers.size() < level.getValue()) {
            addUniqueNumber(baseballNumbers);
        }

        return new BaseballNumbers(baseballNumbers, level);
    }

    private static void addUniqueNumber(List<BaseballNumber> baseballNumbers) {
        int randomNumber = (int) ((Math.random() * 9) + 1);
        BaseballNumber baseballNumber = new BaseballNumber(randomNumber);
        if (!baseballNumbers.contains(baseballNumber)) {
            baseballNumbers.add(baseballNumber);
        }
    }
}
