package ui;

import domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private Client() {
        throw new AssertionError();
    }

    public static List<LottoNumber> inputWinningLottoNumbers() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();

        printInputMessageForWinningLottoNumbers();

        String inputString = InputUtil.input();
        String[] inputArray = inputString.split(",");
        for (int i = 0; i < inputArray.length; i++) {
            String input = inputArray[i].trim();
            isDigitInput(input);
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

        if (!isDigitInput(input)) {
            throw new IllegalArgumentException("숫자 외의 문자는 입력할 수 없습니다.");
        }

        return Integer.valueOf(input);
    }

    public static void printInputMessageForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchaseLottoCount(int input) {
        System.out.println(input + "개를 구매했습니다.");
    }

    private static boolean isDigitInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!isNumber(input.charAt(i))) {
                System.out.println("[입력오류] 1~9 사이의 숫자를 입력해 주세요.");
                return false;
            }
        }
        return true;
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
