package model;

/**
 * Represents one specific payment for one specific item. The item
 * is payed with cash. 
 */
public class CashPayment {
    private AmountOfMoney amountReceived;
    

    /**
     * Creates a new instance. The customer handed over the specified amount.
     *
     * @param amount The amount of cash received by the customer.
     */
    public CashPayment(double amount) 
    {
        this.amountReceived = new AmountOfMoney(amount);
    }

    /**
     *
     * @return The amount of money received.
     */
    public AmountOfMoney getAmountReceived() 
    {
        return this.amountReceived;
    }
    
}
