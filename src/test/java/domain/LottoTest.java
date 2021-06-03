package domain;

import domain.lotto.Lotto;
import domain.lotto.LottoNumber;
import domain.winningresult.WinningInfo;
import domain.lotto.WinningLotto;
import domain.winningresult.WinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static domain.lotto.Lotto.LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트 : 유효성 검증 > 로또번호 6개 여부")
    public void generate_lotto_validation_check_6_size() {
        // when
        Lotto lotto = Lotto.getRandomInstance();

        // then
        assertThat(lotto.getLottoNumberListSize()).isEqualTo(LOTTO_SIZE);
    }

    @Test
    @DisplayName("로또 생성 테스트 : 유효성 검증 > 로또번호 중복 존재여부 확인")
    public void generate_lotto_validation_check_duplicate_number() {
        // when
        Lotto lotto = Lotto.getRandomInstance();

        // then
        assertFalse(lotto.haveDuplicatedLottoNumber());
    }

    @ParameterizedTest
    @CsvSource({"1,7,NOTHING", "1,6,ONE", "1,5,TWO", "1,4,THREE", "1,3,FOUR", "1,2,FIVE", "1,1,SIX"})
    @DisplayName("당첨 결과 테스트")
    public void get_winning_result(int winningLottoStartNumber, int myLottoStartNumber, WinningInfo expectedWinningInfo) {
        // given
        List<LottoNumber> myLottoNumberList = Arrays.asList(
                new LottoNumber(myLottoStartNumber),
                new LottoNumber(myLottoStartNumber + 1),
                new LottoNumber(myLottoStartNumber + 2),
                new LottoNumber(myLottoStartNumber + 3),
                new LottoNumber(myLottoStartNumber + 4),
                new LottoNumber(myLottoStartNumber + 5)
        );
        Lotto lotto = Lotto.getCustomInstance(myLottoNumberList);

        List<LottoNumber> winningLottoNumberList = Arrays.asList(
                new LottoNumber(winningLottoStartNumber),
                new LottoNumber(winningLottoStartNumber + 1),
                new LottoNumber(winningLottoStartNumber + 2),
                new LottoNumber(winningLottoStartNumber + 3),
                new LottoNumber(winningLottoStartNumber + 4),
                new LottoNumber(winningLottoStartNumber + 5)
        );
        WinningLotto winningLotto = new WinningLotto(winningLottoNumberList);

        // expected
        int matchingCount = expectedWinningInfo.matchingCount();
        int winningAmount = expectedWinningInfo.winningAmount();

        // when
        lotto.calculateWinningResult(winningLotto);
        WinningResult winningResult = lotto.winningResult();

        // then
        assertThat(winningResult.matchingCount()).isEqualTo(matchingCount);
        assertThat(winningResult.winningAmount()).isEqualTo(winningAmount);
    }
}
