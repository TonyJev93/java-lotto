package domain;

import domain.winningresult.WinningInfo;
import domain.winningresult.exception.WinningInfoNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningInfoTest {

    @Test
    @DisplayName("당첨정보 조회 테스트 : 실패")
    public void find_fail() {
        int matchingCount = -1;

        assertThatThrownBy(() -> {
            WinningInfo.find(matchingCount);
        }).isExactlyInstanceOf(WinningInfoNotFoundException.class)
                .hasMessage(WinningInfoNotFoundException.ERROR_MESSAGE);
    }

    @ParameterizedTest
    @CsvSource({"0,NOTHING", "1,ONE", "2,TWO", "3,THREE", "4,FOUR", "5,FIVE", "6,SIX"})
    @DisplayName("당첨정보 조회 테스트 : 성공")
    public void find_success(int matchingCount, WinningInfo expected) {
        WinningInfo find = WinningInfo.find(matchingCount);
        assertThat(find).isEqualTo(expected);
    }
}