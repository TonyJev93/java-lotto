package domain;

import java.util.List;

public class Lotto {

    public static final int LOTTO_NUMBER_SIZE = 6;
    private List<LottoNumber> lottoNumberList;

    public Lotto() {
        this.lottoNumberList = LottoMachine.extractRandomLottoNumbers(LOTTO_NUMBER_SIZE);
    }

    public int getLottoNumberListSize() {
        return this.lottoNumberList.size();
    }

    public boolean hasDuplicatedLottoNumber() {
        return this.lottoNumberList.size() > this.lottoNumberList.stream().distinct().count();
    }
}
