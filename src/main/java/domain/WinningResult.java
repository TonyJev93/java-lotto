package domain;

public class WinningResult {
    private WinningInfo winningInfo;

    public WinningResult() {
        this.winningInfo = WinningInfo.NOTHING;
    }

    public void increaseWinningResult() {
        this.winningInfo = WinningInfo.find(winningInfo.matchingCount() + 1);
    }

    public int matchingCount() {
        return winningInfo.matchingCount();
    }

    public int winningAmount() {
        return winningInfo.winningAmount();
    }

    public WinningInfo winningInfo() {
        return this.winningInfo;
    }
}
