package domain;

public class MoneyNotPositiveException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "양수의 금액을 입력해 주세요.";

    public MoneyNotPositiveException() {
        super(ERROR_MESSAGE);
    }
}
