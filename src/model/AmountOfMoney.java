package model;

/**
 * Represents an amount of money.
 */
public class AmountOfMoney {

    private double amount;
    
    /**
     * Creates an instance, representing the specified amount.
     *
     * @param amount The amount represented by the newly created instance.
     */
    public AmountOfMoney(double amount)
    {
        this.amount = amount;
    }

    /**
     * Adds the other amount to this amount.
     * (Is only used for CashRegister class.)
     *
     * @param other The amount to be added.
     */
    public void add(AmountOfMoney other) {
        amount += other.amount;
    }

    /**
     * Subtracts the specified <code>AmountOfMoney</code> from this object and returns
     * an <code>AmountOfMoney</code> instance with the result.
     *
     * @param other The <code>AmountOfMoney</code> to subtract.
     * @return The result of the subtraction.
     */
    public AmountOfMoney subtract(AmountOfMoney other) {
        return new AmountOfMoney(amount - other.amount);
    }

    /**
     * Gets the value of amount.
     *
     * @return The value of amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns a string of the amount.
     *
     * @return The string of the amount.
     */
    @Override
    public String toString() {
        return String.format("%.2f SEK", amount);  
    }
}
