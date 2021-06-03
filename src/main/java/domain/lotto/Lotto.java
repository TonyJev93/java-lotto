package domain.lotto;

import domain.lotto.exception.LottoHaveDuplicatedNumberException;
import domain.lotto.exception.LottoNotValidSizeException;
import domain.winningresult.WinningResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    private List<LottoNumber> lottoNumberList;
    private WinningResult winningResult;

    protected Lotto(List<LottoNumber> lottoNumberList) {
        // sort
        Collections.sort(lottoNumberList);

        this.lottoNumberList = lottoNumberList;
        this.winningResult = new WinningResult();

        validate();
    }

    public static Lotto getRandomInstance() {
        return new Lotto(LottoMachine.extractRandomLottoNumbers(LOTTO_SIZE));
    }

    public static Lotto getCustomInstance(List<LottoNumber> lottoNumberList) {
        return new Lotto(lottoNumberList);
    }

    private void validate() {
        if (!isCorrectLottoSize()) {
            throw new LottoNotValidSizeException();
        }
        if (haveDuplicatedLottoNumber()) {
            throw new LottoHaveDuplicatedNumberException();
        }
    }

    public int getLottoNumberListSize() {
        assert this.lottoNumberList != null;
        return this.lottoNumberList.size();
    }

    public boolean haveDuplicatedLottoNumber() {
        assert this.lottoNumberList != null;
        return this.lottoNumberList.size() > this.lottoNumberList.stream().distinct().count();
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumberList;
    }

    public boolean isCorrectLottoSize() {
        return lottoNumberList.size() == Lotto.LOTTO_SIZE;
    }

    public WinningResult calculateWinningResult(WinningLotto winningLotto) {
        for (LottoNumber lottoNumber : this.lottoNumberList) {
            matchingWithWinningLotto(lottoNumber, winningLotto);
        }

        return winningResult;
    }

    private void matchingWithWinningLotto(LottoNumber lottoNumber, WinningLotto winningLotto) {
        if (winningLotto.contains(lottoNumber)) {
            winningResult.increaseWinningResult();
        }
    }

    public WinningResult winningResult() {
        return winningResult;
    }

    @Override
    public String toString() {
        return "[" + String.join(",", getLottoNumberStringList()) + "]";
    }

    protected List<String> getLottoNumberStringList() {
        List<String> lottoNumberStringList = new ArrayList<>();

        for (int i = 0; i < lottoNumberList.size(); i++) {
            lottoNumberStringList.add(String.valueOf(lottoNumberList.get(i).number()));
        }
        return lottoNumberStringList;
    }
}