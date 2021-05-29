package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResultStatistics {
    private static final int DEFAULT_COUNT = 0;

    private int totalPurchaseAmount;
    private int totalWinningAmount;
    private Map<WinningInfo, Integer> winningInfoStatistics;

    public WinningResultStatistics() {
        this.totalPurchaseAmount = 0;
        this.totalWinningAmount = 0;
        this.winningInfoStatistics = new HashMap<>();
    }

    private WinningResultStatistics(int totalPurchaseAmount, List<WinningResult> winningResults) {
        this.winningInfoStatistics = statisticsWinningInfo(winningResults);
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.totalWinningAmount = calculateTotalWinningAmount(winningResults);
    }

    public static WinningResultStatistics of(int totalPurchaseAmount, List<WinningResult> winningResultList) {
        return new WinningResultStatistics(totalPurchaseAmount, winningResultList);
    }

    private Map<WinningInfo, Integer> statisticsWinningInfo(List<WinningResult> winningResults) {
        Map<WinningInfo, Integer> winningInfoStatics = new HashMap<>();
        int increaseUnit = 1;

        for (WinningResult winningResult : winningResults) {
            Integer count = winningInfoStatics.getOrDefault(winningResult.winningInfo(), DEFAULT_COUNT);
            winningInfoStatics.put(winningResult.winningInfo(), count + increaseUnit);
        }

        return winningInfoStatics;
    }

    private int calculateTotalWinningAmount(List<WinningResult> winningResults) {
        int totalWinningAmount = 0;

        for (WinningResult winningResult : winningResults) {
            totalWinningAmount += winningResult.winningAmount();
        }
        return totalWinningAmount;
    }

    private String earningRate() {
        return String.format("%.2f", (double) totalWinningAmount / totalPurchaseAmount);
    }

    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder printMessageSb = new StringBuilder();
        printMessageSb.append("당첨 통계")
                .append("\n--------\n");

        for (int i = 0; i < WinningInfo.values().length; i++) {
            printMessageSb.append(winningInfoMapToString(WinningInfo.values()[i]));
        }

        printMessageSb.append("총 수익률은 " + this.earningRate() + "입니다");

        return printMessageSb.toString();
    }

    private String winningInfoMapToString(WinningInfo winningInfo) {
        StringBuilder sb = new StringBuilder();
        if (winningInfo.isPrint()) {
            sb.append(winningInfo.matchingCount() + "개 일치 ");
            sb.append("(" + winningInfo.winningAmount() + "원)- ");
            sb.append(winningInfoStatistics.getOrDefault(winningInfo, DEFAULT_COUNT) + "개");
            sb.append("\n");
        }
        return sb.toString();
    }
}
