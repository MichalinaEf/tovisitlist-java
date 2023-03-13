package exception;

public class PlaceAlreadyExistsException extends RuntimeException {
    public PlaceAlreadyExistsException(String message) {
        super(message);
    }
}
