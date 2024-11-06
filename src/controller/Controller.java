package controller;

import java.util.List;

import integration.*;
import model.*;

/**
 * This is the application’s only controller class. All calls to the model pass through here.
 */
public class Controller {
    private Sale sale;
    private InventoryRegistry inventoryRegistry;
    private Accounting accounting;
    private SaleLog saleLog;
    private CashRegister cashRegister;
    
    /**
     * Creates a new instance.
     *
     * @param printer Interface to printer.
     */
    public Controller(Printer printer) {
        this.inventoryRegistry = new InventoryRegistry();
        this.accounting = new Accounting();
        this.saleLog = new SaleLog(accounting);
        this.cashRegister = new CashRegister();
    }

    /**
     * Initiates the process of a new sale.
     */
    public void startingSale() {
        this.sale = new Sale();
    }

    /**
     * Scans an item, retrieves information of items from the inventory and records it in the sale.
     *
     * @param item The item being purchased by the customer.
     * @return The scanned items information from the inventory or null if the item is not found.
     */
    public ItemDTO scanItem(ItemDTO item) {
        ItemDTO scannedItem = inventoryRegistry.getItemInfo(item.getName(), item.getQuantity());
        return sale.addItem(scannedItem);
    }
    
    /**
     * Controller tells the Sale class to Calculate and return the total price and total VAT of all scanned items.
     *
     * @return A SaleDTO object showing the total price including total VAT, 
     * and also total VAT amount alone.
     */
    public SaleDTO allItemsAreScanned() {
        return sale.generateSaleDTO();
    } 

    /**
     * Displays current VAT information for every item in the sale.
     * 
     * @return object of data with info about item prices.
     */
    public ItemPriceWithVatDTO showVatForEveryItem(){
        return sale.displayItemPricesWithVat(); 
    }

    /**
     * Controller tells Sale class to increase the quantity of a sold item if it already exists in the sale.
     *
     * @param item The item to increase the quantity of.
     */
    public void increaseAmountSoldItem(ItemDTO item) {
        sale.increaseItemQuantity(item);
    }

    /**
     * Initiates the payment process, calculating change and recording the transaction.
     *
     * @param amount The amount of money received from the customer.
     * 
     * @return a ChangeDTO object containing details about the payment.
     */
    public ChangeDTO initiatePayment(AmountOfMoney amount) {
        return sale.processPayment(amount, cashRegister);
    }


    /**
     * Completes the sale, processes the transaction, generates the receipt.
     */
    public Receipt completeSale() {
        
        return new Receipt(sale.generateSaleDTO());
    }

    /**
     * Records a transaction.
     * 
     * @return object with data confirming that the transaction has been recorded.
     */
    public RecordTransactionDTO recordTransaction() {
        return saleLog.recordTransaction(sale);
    }

     /**
     * Notifies accounting about current sale.
     * 
     * @return object with data confirming that accounting has been notified.
     */
    public NotifyAccountingDTO notifyAccounting() {
        return saleLog.notifyAccounting(sale);
    }

     /**
     * Notifies the inventory about current sale.
     * 
     * @return object as a list with data confirming that inventory has been notified.
     */
    public List<NotifyInventoryRegistryDTO> notifyInventoryRegistry() {
        return saleLog.notifyInventoryRegistry(sale);
    }
}

