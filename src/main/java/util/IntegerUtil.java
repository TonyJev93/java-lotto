package util;

import ui.exception.InputNotValidException;

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
                throw new InputNotValidException("숫자를 입력해 주세요.");
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
