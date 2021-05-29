package domain.lottoclient;

import domain.lotto.LottoList;
import domain.lotto.LottoMachine;
import domain.lotto.WinningLotto;
import domain.winningresult.WinningResultStatistics;

public class Client {
    private PurchaseInfo purchaseInfo;
    private LottoList lottoList;
    private WinningResultStatistics winningResultStatistics;

    public Client() {
        this.purchaseInfo = new PurchaseInfo();
        this.lottoList = new LottoList();
        this.winningResultStatistics = new WinningResultStatistics();
    }

    public void purchaseLotto(PurchaseInfo purchaseInfo) {
        this.purchaseInfo = purchaseInfo;
        this.lottoList = LottoMachine.generateLottoList(purchaseInfo.countLotto());
    }

    public WinningResultStatistics winningResultStatistics() {
        return winningResultStatistics;
    }

    public void statisticsWinningResults(WinningLotto winningLotto) {
        this.winningResultStatistics = WinningResultStatistics.of(purchaseInfo.purchaseAmount(), lottoList.getResults(winningLotto));
    }

    public String lottoListToString() {
        return lottoList.toString();
    }
}
