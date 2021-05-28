package ui;

import domain.LottoNumber;
import ui.exception.InputNotValidException;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static final String INPUT_SPLITTER_OF_WINNING_LOTTO_NUMBER = ",";

    private Client() {
        throw new AssertionError();
    }

    public static List<LottoNumber> inputWinningLottoNumbers() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();

        printInputMessageForWinningLottoNumbers();

        String inputString = InputUtil.input();
        String[] inputArray = inputString.split(INPUT_SPLITTER_OF_WINNING_LOTTO_NUMBER);

        for (int i = 0; i < inputArray.length; i++) {
            String input = inputArray[i].trim();
            checkValidationIsDigitInput(input);
            lottoNumberList.add(new LottoNumber(Integer.valueOf(input)));
        }

        return lottoNumberList;
    }

    private static void printInputMessageForWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static Integer inputPurchaseAmount() {
        printInputMessageForPurchaseAmount();
        String input = InputUtil.input();

        checkValidationIsDigitInput(input);

        return Integer.valueOf(input);
    }

    public static void printInputMessageForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchaseLottoCount(int input) {
        System.out.println(input + "개를 구매했습니다.");
    }

    private static void checkValidationIsDigitInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!isNumber(input.charAt(i))) {
                throw new InputNotValidException("숫자를 입력해 주세요.");
            }
        }
    }

    private static boolean isNumber(char inputChar) {
        if ('0' <= inputChar && inputChar <= '9') {
            return true;
        }
        return false;
    }

    public static void printString(String s) {
        System.out.println(s);
    }
}
