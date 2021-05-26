package domain;

import domain.PurchaseInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.PurchaseInfo.PURCHASE_AMOUNT_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseInfoTest {

    @Test
    @DisplayName("입력한 구매 금액이 음수일 경우 예외처리 하는지 확인")
    public void input_check_is_positive_purchase_amount() {
        int minusPurchaseAmount = -1000;

        assertThatThrownBy(() -> {
            PurchaseInfo purchaseInfo = new PurchaseInfo(minusPurchaseAmount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수 값을 입력해주세요.");
    }

    @Test
    @DisplayName("입력 구매 금액이 올바른(1000원) 단위가 아닐 경우 예외처리 하는지 확인")
    public void input_check_is_correct_unit_purchase_amount() {
        int notCorrectUnitPurchaseAmount = PURCHASE_AMOUNT_UNIT + 1;

        assertThatThrownBy(() -> {
            new PurchaseInfo(notCorrectUnitPurchaseAmount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매 금액은 %s원 단위로 입력 가능합니다.", PURCHASE_AMOUNT_UNIT);
    }

    @Test
    @DisplayName("금액에 맞는 로또 개수 출력 테스트")
    public void count_lotto_test() {
        // given
        int purchaseLottoCount = 14;
        int purchaseAmount = PURCHASE_AMOUNT_UNIT * purchaseLottoCount;

        // when
        PurchaseInfo purchaseInfo = new PurchaseInfo(purchaseAmount);

        // than
        assertThat(purchaseInfo.countLotto()).isEqualTo(purchaseLottoCount);
    }

}
