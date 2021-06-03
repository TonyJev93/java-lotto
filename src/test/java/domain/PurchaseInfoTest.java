package domain;

import domain.lottoclient.PurchaseInfo;
import domain.lottoclient.exception.PurchaseAmountNotValidUnitException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.lottoclient.PurchaseInfo.PURCHASE_AMOUNT_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseInfoTest {

    @Test
    @DisplayName("입력 구매 금액이 올바른(1000원) 단위가 아닐 경우 예외처리 하는지 확인")
    public void input_check_is_correct_unit_purchase_amount() {
        int notCorrectUnitPurchaseAmount = PURCHASE_AMOUNT_UNIT + 1;

        assertThatThrownBy(() -> {
            new PurchaseInfo(Money.valueOf(notCorrectUnitPurchaseAmount));
        }).isExactlyInstanceOf(PurchaseAmountNotValidUnitException.class)
                .hasMessage(PurchaseAmountNotValidUnitException.ERROR_MESSAGE);
    }

    @Test
    @DisplayName("금액에 맞는 로또 개수 출력 테스트")
    public void count_lotto_test() {
        // given
        int purchaseLottoCount = 14;
        int purchaseAmount = PURCHASE_AMOUNT_UNIT * purchaseLottoCount;

        // when
        PurchaseInfo purchaseInfo = new PurchaseInfo(Money.valueOf(purchaseAmount));

        // than
        assertThat(purchaseInfo.countLotto()).isEqualTo(purchaseLottoCount);
    }

}
