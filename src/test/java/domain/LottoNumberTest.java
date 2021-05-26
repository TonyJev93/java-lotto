package domain;

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
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 " + LottoNumber.MIN_NUMBER + "~" + LottoNumber.MAX_NUMBER + " 사이 숫자만 가질 수 있습니다.");

    }

    @Test
    @DisplayName("1~45 사이 숫자 여부 확인 : 최대값 보다 큰 입력값")
    public void lotto_number_is_between_1_45_more() {
        int moreLottoNumber = LottoNumber.MAX_NUMBER + 1;

        assertThatThrownBy(() -> {
            new LottoNumber(moreLottoNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 " + LottoNumber.MIN_NUMBER + "~" + LottoNumber.MAX_NUMBER + " 사이 숫자만 가질 수 있습니다.");

    }


}