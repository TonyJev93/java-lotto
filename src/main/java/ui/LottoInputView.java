package ui;

import domain.Money;
import domain.lotto.LottoNumber;
import domain.lottoclient.PurchaseInfo;
import util.InputUtil;
import util.IntegerUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoInputView {

    public static final String INPUT_SPLITTER_OF_WINNING_LOTTO_NUMBER = ",";

    private LottoInputView() {
        throw new AssertionError();
    }

    public static List<LottoNumber> inputWinningLottoNumbers() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();

        printInputMessageForWinningLottoNumbers();

        String inputString = InputUtil.input();
        String[] inputArray = inputString.split(INPUT_SPLITTER_OF_WINNING_LOTTO_NUMBER);

        for (int i = 0; i < inputArray.length; i++) {
            String input = inputArray[i].trim();
            IntegerUtil.checkValidationIsDigitInput(input);
            lottoNumberList.add(new LottoNumber(Integer.valueOf(input)));
        }

        return lottoNumberList;
    }

    private static void printInputMessageForWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static PurchaseInfo inputPurchaseAmount() {
        printInputMessageForPurchaseAmount();

        Integer purchaseAmount = IntegerUtil.valueOfString(InputUtil.input());

        PurchaseInfo purchaseInfo = new PurchaseInfo(Money.valueOf(purchaseAmount));

        LottoInputView.printPurchaseLottoCount(purchaseInfo.countLotto());

        return purchaseInfo;
    }

    public static void printInputMessageForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchaseLottoCount(int input) {
        System.out.println(input + "개를 구매했습니다.");
    }


}
