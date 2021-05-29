package domain;

import domain.lotto.LottoNumber;
import domain.lotto.exception.LottoNumberNotCorrectRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("1~45 사이 숫자 여부 확인 : 최소값 보다 작은 입력값")
    public void lotto_number_is_between_1_45_lower() {
        int lowerLottoNumber = LottoNumber.MIN_NUMBER - 1;

        assertThatThrownBy(() -> {
            new LottoNumber(lowerLottoNumber);
        }).isExactlyInstanceOf(LottoNumberNotCorrectRangeException.class)
                .hasMessage(LottoNumberNotCorrectRangeException.ERROR_MESSAGE);

    }

    @Test
    @DisplayName("1~45 사이 숫자 여부 확인 : 최대값 보다 큰 입력값")
    public void lotto_number_is_between_1_45_more() {
        int moreLottoNumber = LottoNumber.MAX_NUMBER + 1;

        assertThatThrownBy(() -> {
            new LottoNumber(moreLottoNumber);
        }).isExactlyInstanceOf(LottoNumberNotCorrectRangeException.class)
                .hasMessage(LottoNumberNotCorrectRangeException.ERROR_MESSAGE);

    }


}