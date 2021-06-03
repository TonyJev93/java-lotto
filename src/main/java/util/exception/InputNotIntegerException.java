package util.exception;

public class InputNotIntegerException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "숫자를 입력해 주세요.";

    public InputNotIntegerException() {
        super(ERROR_MESSAGE);
    }
}
