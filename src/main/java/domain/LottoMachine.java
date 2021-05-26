package domain;

public class LottoMachine {

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
