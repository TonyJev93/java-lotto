package domain;

public class PurchaseInfo {
    public static final int PURCHASE_AMOUNT_UNIT = 1000;

    private int purchaseAmount;

    public PurchaseInfo(int purchaseAmount) {
        if (!isPositivePurchaseAmount(purchaseAmount)) {
            throw new IllegalArgumentException("양수 값을 입력해주세요.");
        }

        if (!isCorrectUnitPurchaseAmount(purchaseAmount)) {
            throw new IllegalArgumentException("구매 금액은 " + PURCHASE_AMOUNT_UNIT + "원 단위로 입력 가능합니다.");
        }

        this.purchaseAmount = purchaseAmount;
    }

    public PurchaseInfo() {
        this.purchaseAmount = 0;
    }

    public int purchaseAmount() {
        return this.purchaseAmount;
    }

    private boolean isCorrectUnitPurchaseAmount(int purchaseAmount) {
        return purchaseAmount % PURCHASE_AMOUNT_UNIT == 0;
    }

    private boolean isPositivePurchaseAmount(int purchaseAmount) {
        return purchaseAmount > 0;
    }

    public int countLotto() {
        return purchaseAmount / PURCHASE_AMOUNT_UNIT;
    }
}
