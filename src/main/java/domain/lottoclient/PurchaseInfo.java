package domain.lottoclient;

import domain.Money;
import domain.lottoclient.exception.PurchaseAmountNotValidUnitException;

public class PurchaseInfo {
    public static final int PURCHASE_AMOUNT_UNIT = 1000;

    private int purchaseAmount;

    public PurchaseInfo(Money money) {
        if (!isCorrectUnitPurchaseAmount(money)) {
            throw new PurchaseAmountNotValidUnitException();
        }

        this.purchaseAmount = money.amount();
    }

    public PurchaseInfo() {
        this.purchaseAmount = 0;
    }

    public int purchaseAmount() {
        return this.purchaseAmount;
    }

    private boolean isCorrectUnitPurchaseAmount(Money money) {
        return money.amount() % PURCHASE_AMOUNT_UNIT == 0;
    }

    public int countLotto() {
        return purchaseAmount / PURCHASE_AMOUNT_UNIT;
    }
}
