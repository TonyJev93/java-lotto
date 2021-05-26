package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    List<Lotto> lottoList = new ArrayList<>();

    public void add(Lotto lotto) {
        lottoList.add(lotto);
    }

    public int size() {
        return lottoList.size();
    }
}
