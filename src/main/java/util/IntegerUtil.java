package util;

import util.exception.InputNotIntegerException;

public class IntegerUtil {

    private IntegerUtil(){
        throw new AssertionError();
    }

    public static Integer valueOfString(String input) {
        checkValidationIsDigitInput(input);
        return Integer.valueOf(input);
    }


    public static void checkValidationIsDigitInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!isNumber(input.charAt(i))) {
                throw new InputNotIntegerException();
            }
        }
    }

    private static boolean isNumber(char inputChar) {
        if ('0' <= inputChar && inputChar <= '9') {
            return true;
        }
        return false;
    }
}
