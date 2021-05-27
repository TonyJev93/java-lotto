package runner;

import domain.LottoNumber;
import domain.Person;
import domain.PurchaseInfo;
import domain.WinningLotto;
import ui.Client;

import java.util.List;

public class Runner {
    public static void run() {
        Person person = purchaseLotto();
        WinningLotto winningLotto = inputWinningLotto();
        getResult(person, winningLotto);
    }

    private static void getResult(Person person, WinningLotto winningLotto) {
        person.staticsWinningResults(winningLotto);
        Client.printString(person.winningResultStatics().toString());
    }

    private static WinningLotto inputWinningLotto() {
        List<LottoNumber> inputWinningLottoNumbers = Client.inputWinningLottoNumbers();
        WinningLotto winningLotto = new WinningLotto(inputWinningLottoNumbers);
        return winningLotto;
    }

    private static Person purchaseLotto() {
        PurchaseInfo purchaseInfo = inputPurchaseInfo();
        Person person = Person.purchaseLotto(purchaseInfo);
        Client.printString(person.lottoListToString());
        return person;
    }

    private static PurchaseInfo inputPurchaseInfo() {
        Integer purchaseAmount = Client.inputPurchaseAmount();
        PurchaseInfo purchaseInfo = new PurchaseInfo(purchaseAmount);
        Client.printPurchaseLottoCount(purchaseInfo.countLotto());
        return purchaseInfo;
    }
}
