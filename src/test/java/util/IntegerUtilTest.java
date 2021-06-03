package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.exception.InputNotIntegerException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IntegerUtilTest {

    @Test
    @DisplayName("문자열 -> Integer 변환 테스트")
    void valueOfString() {
        // given
        String input = "123";
        Integer expected = 123;

        // when
        Integer output = IntegerUtil.valueOfString(input);

        // then
        assertThat(output).isEqualTo(Integer.valueOf(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "12a", "ABC", "12A", "-123"})
    @DisplayName("입력된 값이 숫자인지 확인")
    void checkValidationIsDigitInput(String input) {
        assertThatThrownBy(() -> {
                    IntegerUtil.checkValidationIsDigitInput(input);
                }
        ).isExactlyInstanceOf(InputNotIntegerException.class)
                .hasMessage(InputNotIntegerException.ERROR_MESSAGE);
    }
}