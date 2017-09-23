/**
 * @author Ahmed Gedi
 * @version 1.0
 */
public class InsufficientFundsException extends Exception {

    /**
     * Removes all instance of the passed in element from the
     * array list then returns the element that was removed
     */
    public InsufficientFundsException() {
        super("Balance on a credit card is too low.");
    }

    /**
     * @param msg the message for the exception
     */
    public InsufficientFundsException(String  msg) {
        super(msg);

    }

}
