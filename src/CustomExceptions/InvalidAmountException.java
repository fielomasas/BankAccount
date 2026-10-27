package CustomExceptions;

/**
 * Thrown when an invalid amount (negative or zero) is deposited or withdrawn.
 */
public class InvalidAmountException extends Exception {
    private String message;

    public InvalidAmountException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
