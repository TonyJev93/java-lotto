package domain.winningresult.exception;

public class WinningInfoNotFoundException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "존재하지 않는 당첨 정보입니다.";

    public WinningInfoNotFoundException() {
        super(ERROR_MESSAGE);
    }
}
