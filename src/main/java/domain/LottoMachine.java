package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public static List<LottoNumber> extractRandomLottoNumbers(int size) {
        List<LottoNumber> randomlottoNumbers = new ArrayList<>();
        randomlottoNumbers.addAll(LottoNumberPool.getInstance().lottoNumbers());

        // shuffle
        shuffleLottoNumber(randomlottoNumbers);

        // extract numbers by size
        randomlottoNumbers = randomlottoNumbers.subList(0, size);

        return randomlottoNumbers;
    }

    private static void shuffleLottoNumber(List<LottoNumber> lottoNumberPool) {
        Collections.shuffle(lottoNumberPool);
    }

    public static LottoList generateLottoList(int purchaseLottoCount) {
        if (!isPositiveInput(purchaseLottoCount)) {
            throw new IllegalArgumentException("최소 생성 가능한 로또 개수는 1개 이상입니다.");
        }

        LottoList lottoList = new LottoList();

        for (int i = 0; i < purchaseLottoCount; i++) {
            lottoList.add(Lotto.getRandomInstance());
        }

        return lottoList;
    }

    private static boolean isPositiveInput(int purchaseLottoCount) {
        return purchaseLottoCount > 0;
    }

}
