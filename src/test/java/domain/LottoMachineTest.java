package domain;

import domain.lotto.LottoList;
import domain.lotto.LottoMachine;
import domain.lotto.exception.LottoNeedAtLeastOneMoreException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {
    @Test
    @DisplayName("로또 구매 개수 양수 예외처리 확인")
    public void minus_input_check() {
        // given
        int purchaseLottoCount = 0;
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> {
            // when
            lottoMachine.generateLottoList(purchaseLottoCount);
        }).isExactlyInstanceOf(LottoNeedAtLeastOneMoreException.class)
                .hasMessage(LottoNeedAtLeastOneMoreException.ERROR_MESSAGE);
    }

    @Test
    @DisplayName("구매한 개수만큼 로또가 생성되었는지 확인")
    public void generate_lotto_list_by_purchase_count() {
        // given
        int purchaseLottoCount = 14;
        LottoMachine lottoMachine = new LottoMachine();

        // when
        LottoList lottoList = lottoMachine.generateLottoList(purchaseLottoCount);

        // then
        assertThat(lottoList.size()).isEqualTo(purchaseLottoCount);
    }
}
