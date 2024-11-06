package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The receipt of a sale
 */
public class Receipt
{
    private SaleDTO sale;
    
    /**
     * Creates a new instance.
     *
     * @param sale The sale proved by this receipt.
     */
    public Receipt(SaleDTO sale)
    {
        this.sale = sale;
    }

    /**
     * Creates a formated string with the entire content of the receipt.
     *
     * @return The formatted receipt with details of sale.
     */
    public String generateReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("-".repeat(60) + "\n");
        receipt.append("-".repeat(60) + "\n");
        receipt.append("Beginning of receipt\n");
        receipt.append("-".repeat(60) + "\n");

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime timeOfSale = LocalDateTime.now();
        receipt.append("Time of Sale: ").append(timeOfSale.format(timeFormatter)).append("\n\n");

        receipt.append("Sale Details:\n");
        receipt.append("Items:\n");
        for (ItemDTO item : sale.getItems()) {
            receipt.append(formatItem(item)).append("\n");
        }
        receipt.append(String.format("Total Price (including VAT): %.2f SEK\n", sale.getTotalPrice()));
        receipt.append(String.format("Total VAT: %.2f SEK\n", sale.getTotalVAT()));
        receipt.append("-".repeat(60)).append("\n");
        receipt.append("-".repeat(60)).append("\n");
        return receipt.toString();
    }

    private String formatItem(ItemDTO item) {
        return String.format("Item: ID = %d, name = '%s', description = '%s', quantity = %d, price = %s, VAT rate = %.2f%%",
                             item.getId(), item.getName(), item.getDescription(),
                             item.getQuantity(), item.getPrice(), item.getVatRate());
    }
}
