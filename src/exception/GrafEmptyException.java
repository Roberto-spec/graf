package exception;

public class GrafEmptyException extends GrafException{
    public GrafEmptyException() {
    }

    public GrafEmptyException(String message) {
        super(message);
    }
}
