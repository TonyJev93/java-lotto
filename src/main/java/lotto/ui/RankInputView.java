package lotto.ui;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;

import java.util.Scanner;

public class RankInputView {
    private String winTicketValue;
    private int winBonusNumber;

    public RankInputView(String inputValue, int winBonusNumber) {
        validation(inputValue);
        this.winTicketValue = inputValue;
        this.winBonusNumber = winBonusNumber;
    }

    public LottoNumber getWinBonusNumber() {
        return LottoNumber.create(this.winBonusNumber);
    }

    public static RankInputView getThisWeekWinningInfo(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winTicketValue = scanner.nextLine();
        System.out.println("보너스 볼을 입력해주세요.");
        int winBonusNumber = scanner.nextInt();
        return new RankInputView(winTicketValue, winBonusNumber);
    }

    public LottoTicket convertToWinTicket() {
        return LottoGenerator.createByManual(this.winTicketValue);
    }

    private void validation(String inputValue) {
        if (inputValue == null) {
            throw new IllegalArgumentException("Input value must not null");
        }

        if (inputValue.trim().isEmpty()) {
            throw new IllegalArgumentException("Input value must not empty");
        }
    }
}