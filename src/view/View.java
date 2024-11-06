package view;

import java.util.List;

import controller.Controller;
import model.*;
import integration.*;

/**
 * This program has no view, instead
 * this class is a placeholder for the entire view.
 */
public class View {
    private Controller contr;
    private Printer printer;

    /**
     * Creates a new instance. 
     *
     * @param contr The controller that is used for all operations.
     * @param printer The printer prints out a receipt.
     */
    public View(Controller contr, Printer printer)
    {
        this.contr = contr;
        this.printer = printer;
    }

    /**
     * Simulates user interactions that trigger all
     * system operations.
     */
    public void runSale(){
    	System.out.println("Sale have now started:");
        System.out.println("");
        contr.startingSale();

        int itemID = 345031;
        ItemDTO item1 = new ItemDTO(itemID, "TOMATO", "Fresh organic tomatoes", 1, new AmountOfMoney(15.00), 5.0);
        ItemDTO scannedItem = contr.scanItem(item1);
        System.out.println("Scanning item:\n" + formattingItems(scannedItem));
        ItemPriceWithVatDTO detailsOfVat = contr.showVatForEveryItem();
    System.out.println("Price (including VAT): " + String.format("%.2f", detailsOfVat.getPriceIncludingVat())
     + ", VAT Amount: " + String.format("%.2f", detailsOfVat.getVatAmount()) + " SEK" );

    System.out.println("");

        System.out.println("Increasing quantity on the same item just scanned:");
        contr.increaseAmountSoldItem(new ItemDTO(345031, "TOMATO", "Fresh organic tomatoes", 1, new AmountOfMoney(15.00), 5.0));
        
        System.out.println(formattingItems(scannedItem));
        ItemPriceWithVatDTO detailsOfVat2 = contr.showVatForEveryItem();
    System.out.println("Price (including VAT): " + String.format("%.2f", detailsOfVat2.getPriceIncludingVat()) + 
      ", VAT Amount: " + String.format("%.2f", detailsOfVat2.getVatAmount()) + " SEK" );

    System.out.println("");

        ItemDTO item2 = new ItemDTO(345032, "WATERMELON", "Juicy summer watermelon", 1, new AmountOfMoney(29.90), 6.0);
        ItemDTO scannedAnotherItem = contr.scanItem(item2);
        System.out.println("Scanning item:\n" + formattingItems(scannedAnotherItem));
        ItemPriceWithVatDTO detailsOfVat3 = contr.showVatForEveryItem();
    System.out.println( "Price (including VAT): " + String.format("%.2f", detailsOfVat3.getPriceIncludingVat()) + 
    ", VAT Amount: " + String.format("%.2f", detailsOfVat3.getVatAmount()) + " SEK" );
        
    System.out.println("");
        
        ChangeDTO changeDetails = contr.initiatePayment(new AmountOfMoney(100));
        System.out.println("Payment of " + changeDetails.getAmountReceived() + " received. Change: " + changeDetails.getChange() + " SEK");

        Receipt receipt = contr.completeSale();
        printer.printReceipt(receipt);
        

        System.out.println("Transaction recorded for sale of total price: " + contr.recordTransaction().getTotalPrice() + " SEK");
        System.out.println("");
        System.out.println(contr.notifyAccounting().getNotification());
        showInventoryChange(contr.notifyInventoryRegistry());
        System.out.println("");
        System.out.println("Sale completed and processed.");

    }

    /**
     * Formats a string desrcibing details of
     * each item.
     *
     * @param item the item to format to a string 
     * @return the string of the item with its attributes.
     */
    private String formattingItems(ItemDTO item) {
    return String.format("Item: ID = %d, name = '%s', description = '%s', quantity = %d, price = %s, VAT rate = %.2f%%",
     item.getId(), item.getName(), item.getDescription(),item.getQuantity(), item.getPrice() , item.getVatRate());
    }   

    /**
     * Formats a string desrcibing details of the changed inventory.
     * This is displaying a simulation of updating an inventory. 
     * 
     * @param inventoryChanges list of the changes in the inventory.
     */
    private void showInventoryChange (List<NotifyInventoryRegistryDTO> inventoryChanges){
        for (NotifyInventoryRegistryDTO change : inventoryChanges) {
            System.out.println("Decreased inventory for item " + change.getItemID() + " by " + change.getQuantityInfo() + " units.");
            }
        }
}
