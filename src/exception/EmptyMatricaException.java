package exception;

public class EmptyMatricaException extends GrafException{
    public EmptyMatricaException() {
    }

    public EmptyMatricaException(String message) {
        super(message);
    }
}
