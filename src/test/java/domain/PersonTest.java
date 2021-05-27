package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PersonTest {
    @Test
    @DisplayName("로또번호 당첨 금액 조회")
    // TODO : 당첨금액 확인 Random 어떻게 테스트 하는지 알려주셈요~
    public void get_winning_lotto_amount() {
        List<LottoNumber> winningLottoNumberList = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );

        WinningLotto winningLotto = new WinningLotto(winningLottoNumberList);

        int purchaseAmount = 14000;
        PurchaseInfo purchaseInfo = new PurchaseInfo(purchaseAmount);

        Person person = Person.purchaseLotto(purchaseInfo);

        System.out.println(person.toString());
        System.out.println(winningLotto.toString());
        System.out.println(person.lottoListToString());
        person.staticsWinningResults(winningLotto);

        WinningResultStatics winningResultStatics = person.winningResultStatics();
        winningResultStatics.print();
    }


}