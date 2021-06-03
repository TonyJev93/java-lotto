package util;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    private InputUtil() {
        throw new AssertionError();
    }

    public static String input() {
        return scanner.next();
    }
}
