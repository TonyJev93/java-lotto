package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LottoNumberPoolTest {

    @Test
    @DisplayName("로또 번호 Pool 사이즈가 45인지 확인")
    public void pool_size_45_check() {
        LottoNumberPool lottoNumberPool = LottoNumberPool.getInstance();
        int expectedSize = LottoNumber.MAX_NUMBER - LottoNumber.MIN_NUMBER + 1;

        assertThat(lottoNumberPool.size()).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("중복된 로또 번호가 없는지 확인")
    public void duplicate_number_check() {
        LottoNumberPool lottoNumberPool = LottoNumberPool.getInstance();
        assertFalse(lottoNumberPool.hasDuplicatedNumber());
    }


}