package domain.lotto.exception;

import domain.lotto.LottoNumber;

public class LottoNumberNotCorrectRangeException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "로또 번호는 " + LottoNumber.MIN_NUMBER + "~" + LottoNumber.MAX_NUMBER + " 사이 숫자만 가질 수 있습니다.";

    public LottoNumberNotCorrectRangeException() {
        super(ERROR_MESSAGE);
    }
}
