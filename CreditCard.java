/**
 * @author Ahmed Gedi
 * @version 1.0
 */
public class CreditCard {

    private double balance;

    /**
     * @param newBalance the new balance on the credit card
     */
    public CreditCard(double newBalance) {
        balance = newBalance;
    }

    /**
     * @throws InsufficientFundsException if not enough money
     * @param amount the amount to pay
     */
    public void pay(double amount) throws InsufficientFundsException {
        if (amount <= balance) {
            balance -= amount;
        } else {
            throw new InsufficientFundsException("Balance is negative!");
        }
    }

}
