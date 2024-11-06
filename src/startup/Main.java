package startup;

import controller.Controller;
import view.View;
import integration.Printer;

    /**
     * This is the main method that initates the entire application.
     */
public class Main {

    /**
     * Starts the application.
     *
     * @param args The application does not take any command line parameters.
     */
        public static void main(String[] args)
        {
            Printer printer = new Printer();
            Controller contr = new Controller(printer); 
            View view = new View(contr, printer);
            view.runSale();
        }
    
    
}
