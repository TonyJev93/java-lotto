package domain.lottoclient.exception;

import domain.lottoclient.PurchaseInfo;

public class PurchaseAmountNotValidUnitException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "구매 금액은 " + PurchaseInfo.PURCHASE_AMOUNT_UNIT + "원 단위로 입력 가능합니다.";

    public PurchaseAmountNotValidUnitException() {
        super(ERROR_MESSAGE);
    }
}
