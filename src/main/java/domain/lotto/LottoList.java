package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private List<Lotto> lottoList = new ArrayList<>();

    public void add(Lotto lotto) {
        lottoList.add(lotto);
    }

    public int size() {
        return lottoList.size();
    }

    public List<WinningResult> getResults(WinningLotto winningLotto) {
        List<WinningResult> winningResult = new ArrayList<>();

        for (Lotto lotto
                : this.lottoList
        ) {
            winningResult.add(lotto.calculateWinningResult(winningLotto));
        }

        return winningResult;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lottoList.size(); i++) {
            sb.append(lottoList.get(i).toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}
