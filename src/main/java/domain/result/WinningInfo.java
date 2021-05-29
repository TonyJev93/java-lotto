package domain;

public enum WinningInfo {

    NOTHING(0, 0, false),
    ONE(1, 0, false),
    TWO(2, 0, false),
    THREE(3, 5000, true),
    FOUR(4, 50000, true),
    FIVE(5, 1500000, true),
    SIX(6, 2000000000, true);

    private int matchingCount;
    private int winningAmount;
    private boolean printYn;

    WinningInfo(int matchingCount, int winningAmount, boolean printYn) {
        this.matchingCount = matchingCount;
        this.winningAmount = winningAmount;
        this.printYn = printYn;
    }

    public static WinningInfo find(int matchingCount) {
        for (int i = 0; i < WinningInfo.values().length; i++) {
            if (matchingCount == WinningInfo.values()[i].matchingCount) {
                return WinningInfo.values()[i];
            }
        }
        throw new IllegalArgumentException("존재하지 않는 당첨 정보입니다.");
    }

    public boolean isPrint() {
        return printYn;
    }

    public int matchingCount() {
        return matchingCount;
    }

    public int winningAmount() {
        return winningAmount;
    }
}
