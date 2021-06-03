package domain.lotto.exception;

public class LottoHaveDuplicatedNumberException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "중복된 로또 번호가 존재합니다.";

    public LottoHaveDuplicatedNumberException() {
        super(ERROR_MESSAGE);
    }
}
