package runner;

import domain.lottoclient.Client;
import domain.lotto.LottoNumber;
import domain.lottoclient.PurchaseInfo;
import domain.lotto.WinningLotto;
import ui.LottoInputView;
import util.OutputUtil;

import java.util.List;

public class LottoStore {
    public static void run() {
        Client client = new Client(); // 손님 생성

        PurchaseInfo purchaseInfo = LottoInputView.inputPurchaseAmount(); // 구매 정보 입력

        client.purchaseLotto(purchaseInfo); // 로또 구매

        printPurchasedLottoList(client); // 구매한 로또 출력

        WinningLotto winningLotto = inputWinningLotto(); // 지난 주 당첨 로또 입력

        client.statisticsWinningResults(winningLotto); // 당첨 결과 통계

        printWinningLottoResults(client); // 당첨 결과 출력
    }

    private static void printWinningLottoResults(Client client) {
        OutputUtil.printString(client.winningResultStatistics().toString());
    }

    private static void printPurchasedLottoList(Client client) {
        OutputUtil.printString(client.lottoListToString());
    }

    private static WinningLotto inputWinningLotto() {
        List<LottoNumber> inputWinningLottoNumbers = LottoInputView.inputWinningLottoNumbers();
        WinningLotto winningLotto = new WinningLotto(inputWinningLottoNumbers);
        return winningLotto;
    }
}
