package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public static List<LottoNumber> extractRandomLottoNumbers(int size) {
        List<LottoNumber> lottoNumberPool = new ArrayList<>();
        lottoNumberPool.addAll(LottoNumberPool.getInstance().lottoNumbers());

        // shuffle
        shuffleLottoNumber(lottoNumberPool);

        // extract numbers by size
        lottoNumberPool = lottoNumberPool.subList(0, size);

        // sort
        sort(lottoNumberPool);
        return lottoNumberPool;
    }

    private static void sort(List<LottoNumber> lottoNumberList) {
        Collections.sort(lottoNumberList);
    }

    private static void shuffleLottoNumber(List<LottoNumber> lottoNumberPool) {
        Collections.shuffle(lottoNumberPool);
    }

    public LottoList generateLottoList(int purchaseLottoCount) {
        if (!isPositiveInput(purchaseLottoCount)) {
            throw new IllegalArgumentException("최소 생성 가능한 로또 개수는 1개 이상입니다.");
        }

        LottoList lottoList = new LottoList();

        for (int i = 0; i < purchaseLottoCount; i++) {
            lottoList.add(new Lotto());
        }

        return lottoList;

    }

    private boolean isPositiveInput(int purchaseLottoCount) {
        return purchaseLottoCount > 0;
    }

}
