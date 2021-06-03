package domain.lotto;

import domain.lotto.exception.LottoNumberNotCorrectRangeException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        if (!isCorrectNumberRange(number)) {
            throw new LottoNumberNotCorrectRangeException();
        }

        this.number = number;
    }

    private boolean isCorrectNumberRange(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        if (this.number > lottoNumber.number) {
            return 1;
        } else if (this.number < lottoNumber.number) {
            return -1;
        } else {
            return 0;
        }
    }

    public int number() {
        return this.number;
    }
}
