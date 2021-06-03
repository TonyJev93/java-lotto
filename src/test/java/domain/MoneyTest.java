package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @Test
    @DisplayName("입력한 구매 금액이 음수일 경우 예외처리 하는지 확인")
    public void input_check_is_positive_money() {
        int minusPurchaseAmount = -1000;
        assertThatThrownBy(() -> {
            Money money = Money.valueOf(minusPurchaseAmount);
        }).isExactlyInstanceOf(MoneyNotPositiveException.class)
                .hasMessage(MoneyNotPositiveException.ERROR_MESSAGE);
    }
}