package domain.lotto.exception;

import domain.lotto.Lotto;

public class LottoNotValidSizeException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "로또 번호는 " + Lotto.LOTTO_SIZE + "개여야 합니다.";

    public LottoNotValidSizeException() {
        super(ERROR_MESSAGE);
    }
}
