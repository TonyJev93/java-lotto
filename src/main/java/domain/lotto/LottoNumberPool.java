package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberPool {
    private static final LottoNumberPool INSTANCE = new LottoNumberPool();
    private final List<LottoNumber> lottoNumberList;

    private LottoNumberPool() {
        this.lottoNumberList = generateLottoNumberPool();
    }

    // Singleton
    public static LottoNumberPool getInstance() {
        return INSTANCE;
    }

    private List<LottoNumber> generateLottoNumberPool() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();

        for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
            lottoNumberList.add(new LottoNumber(i));
        }

        return lottoNumberList;
    }

    public int size() {
        return lottoNumberList.size();
    }

    public boolean hasDuplicatedNumber() {
        return lottoNumberList.size() > lottoNumberList.stream().distinct().count();
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumberList;
    }
}
