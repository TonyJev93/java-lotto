package domain;

public class PurchaseInfo {
    public static final int PURCHASE_AMOUNT_UNIT = 1000;

    private int purchaseAmount;

    public PurchaseInfo(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        if (!isPositivePurchaseAmount()) {
            throw new IllegalArgumentException("양수 값을 입력해주세요.");
        }
        if (!isCorrectUnitPurchaseAmount()) {
            throw new IllegalArgumentException("구매 금액은 " + PURCHASE_AMOUNT_UNIT + "원 단위로 입력 가능합니다.");
        }
    }

    private boolean isCorrectUnitPurchaseAmount() {
        return purchaseAmount % PURCHASE_AMOUNT_UNIT == 0;
    }

    private boolean isPositivePurchaseAmount() {
        return this.purchaseAmount > 0;
    }

    public int countLotto() {
        return purchaseAmount / PURCHASE_AMOUNT_UNIT;
    }
}
