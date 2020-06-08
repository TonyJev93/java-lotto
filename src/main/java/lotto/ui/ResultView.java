package lotto.ui;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.prize.Prize;
import lotto.domain.prize.WinningResult;

import java.util.stream.IntStream;

public class ResultView {
    private ResultView() {
    }

    public static void printLottoTicket(int quantity, LottoTicket lottoTicket) {
        System.out.println(quantity + "개를 구매했습니다.");
        IntStream.range(0, quantity).forEach(i -> System.out.println(lottoTicket.tellLottoNumbers(i)));
        System.out.println();
    }

    public static void printWinningRate(double winningRate) {
        System.out.println("총 수익률은 " + winningRate + "입니다.");
        if (winningRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해의 의미임)");
        }
    }

    public static void printWinningResult(WinningResult winningResult) {
        System.out.println("\n당첨 통계\n————");
        for(Prize prize : Prize.values()){
            int winningCount = winningResult.tellWinningCount(prize.getMatch());
            System.out.println(prize.getMatch()+ "개 일치(" + prize.getPrice() + "원) - " + winningCount + "개");
        }
    }
}