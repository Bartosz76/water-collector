package bm.app.watercollector.exception;

public class ArrayTooSmallException extends Throwable{

    private String message;

    public ArrayTooSmallException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
