package ui.exception;

public class InputNotValidException extends IllegalArgumentException {
    public InputNotValidException(String msg) {
        super(msg);
        System.out.println(msg);
    }
}
