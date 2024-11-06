package model;

/**
 * Represents a cash register,
 * that tracks total cash received in the sale.
 */
public class CashRegister {
    private AmountOfMoney balance = new AmountOfMoney(0.0);

    /**
     * Get the value of total cash received.
     *
     * @return The value of total cash received.
     */
    public void addPayment(CashPayment payment) 
    {
        balance.add(payment.getAmountReceived());
    }
}
