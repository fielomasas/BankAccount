package CustomExceptions;

/**
 * Thrown when operations are performed on a frozen account.
 */
public class AccountFrozenException extends Exception {
    private String message;

    public AccountFrozenException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
