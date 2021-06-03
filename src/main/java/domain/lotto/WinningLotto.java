package domain.lotto;

import domain.lotto.Lotto;
import domain.lotto.LottoNumber;

import java.util.List;

public class WinningLotto extends Lotto {
    public WinningLotto(List<LottoNumber> lottoNumberList) {
        super(lottoNumberList);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers().contains(lottoNumber);
    }

    @Override
    public String toString() {
        return "지난 주 당첨 번호\n" + String.join(",", getLottoNumberStringList());
    }
}