package domain.lotto.exception;

public class LottoNeedAtLeastOneMoreException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "최소 생성 가능한 로또 개수는 1개 이상입니다.";

    public LottoNeedAtLeastOneMoreException(){
        super(ERROR_MESSAGE);
    }
}
