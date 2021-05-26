package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.Lotto.LOTTO_NUMBER_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트 : 유효성 검증 > 로또번호 6개 여부")
    public void generate_lotto_validation_check_6_size() {
        // when
        Lotto lotto = new Lotto();

        // then
        assertThat(lotto.getLottoNumberListSize()).isEqualTo(LOTTO_NUMBER_SIZE);
    }

    @Test
    @DisplayName("로또 생성 테스트 : 유효성 검증 > 로또번호 중복 존재여부 확인")
    public void generate_lotto_validation_check_duplicate_number() {
        // when
        Lotto lotto = new Lotto();

        // then
        assertFalse(lotto.hasDuplicatedLottoNumber());
    }
}
