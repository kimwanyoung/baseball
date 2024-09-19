package utils;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static int parseCharToInt(char inputValue) {
        validateIsNumeric(inputValue);
        return Character.getNumericValue(inputValue);
    }

    public static List<Integer> parseCharArrToIntArr(char[] inputValues) {
        List<Integer> numberValues = new ArrayList<>();
        for (char inputValue : inputValues) {
            numberValues.add(parseCharToInt(inputValue));
        }
        return numberValues;
    }

    private static void validateIsNumeric(char inputValue) {
        if (!Character.isDigit(inputValue)) throw new IllegalArgumentException("숫자만 입력가능합니다.");
    }
}
