package domain;

import domain.lotto.LottoNumber;
import domain.lotto.WinningLotto;
import domain.lotto.exception.LottoHaveDuplicatedNumberException;
import domain.lotto.exception.LottoNotValidSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinningLottoTest {

    @Test
    @DisplayName("유효성 검증 > 입력값 6자리 미만 등록")
    public void validation_check_lower_input_size() {
        // given
        List<LottoNumber> winningLottoNumberList = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        );

        assertThatThrownBy(() -> {
            new WinningLotto(winningLottoNumberList);
        }).isExactlyInstanceOf(LottoNotValidSizeException.class)
                .hasMessage(LottoNotValidSizeException.ERROR_MESSAGE);
    }

    @Test
    @DisplayName("유효성 검증 > 입력값 6자리 초과 등록")
    public void validation_check_more_input_size() {
        // given
        List<LottoNumber> winningLottoNumberList = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7)
        );

        assertThatThrownBy(() -> {
            new WinningLotto(winningLottoNumberList);
        }).isExactlyInstanceOf(LottoNotValidSizeException.class)
                .hasMessage(LottoNotValidSizeException.ERROR_MESSAGE);
    }

    @Test
    @DisplayName("유효성 검증 > 입력값 6자리 정상 등록")
    public void validation_check_correct_input_size() {
        // given
        List<LottoNumber> winningLottoNumberList = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );

        WinningLotto winningLotto = new WinningLotto(winningLottoNumberList);
        assertTrue(winningLotto.isCorrectLottoSize());
    }

    @Test
    @DisplayName("유효성 검증 > 중복 입력값 존재여부 확인")
    public void validation_check_duplicated_number_exist() {
        // given
        List<LottoNumber> winningLottoNumberList = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        );

        assertThatThrownBy(() -> {
            new WinningLotto(winningLottoNumberList);
        }).isExactlyInstanceOf(LottoHaveDuplicatedNumberException.class)
                .hasMessage(LottoHaveDuplicatedNumberException.ERROR_MESSAGE);
    }
}
