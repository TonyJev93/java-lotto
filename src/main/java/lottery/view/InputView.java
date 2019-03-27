package lottery.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("얼마나 사실거에요?");
        return scanner.nextInt();
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨번호를 입력해주세요");
        if(scanner.nextLine().isEmpty()) {
        }
        return convertInts(scanner.nextLine().split(","));
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요~");
        return scanner.nextInt();
    }

    private static List<Integer> convertInts(String[] values) {
        List<Integer> numbers = new ArrayList<>();
        for (int index = 0; index < values.length ; index++) {
            numbers.add(Integer.parseInt(values[index]));
        }
        return numbers;
    }
}