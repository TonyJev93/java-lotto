package domain;

public class Person {
    private PurchaseInfo purchaseInfo;
    private LottoList lottoList;
    private WinningResultStatics winningResultStatics;

    private Person(PurchaseInfo purchaseInfo) {
        this.purchaseInfo = purchaseInfo;
        this.lottoList = LottoMachine.generateLottoList(purchaseInfo.countLotto());
        this.winningResultStatics = new WinningResultStatics();
    }

    public static Person purchaseLotto(PurchaseInfo purchaseInfo) {
        return new Person(purchaseInfo);
    }

    public WinningResultStatics winningResultStatics() {
        return winningResultStatics;
    }

    public void staticsWinningResults(WinningLotto winningLotto) {
        this.winningResultStatics = new WinningResultStatics(purchaseInfo, lottoList.getResults(winningLotto));
    }


    public String lottoListToString() {
        return lottoList.toString();
    }
}
