package exception;

public class NotAllConnectionException extends GrafException{
    public NotAllConnectionException() {
    }

    public NotAllConnectionException(String message) {
        super(message);
    }
}
