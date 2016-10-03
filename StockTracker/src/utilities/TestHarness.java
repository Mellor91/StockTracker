/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import stocktracker.stockdatamodel.PhysicalStockItem;
import stocktracker.stockdatamodel.ServiceStockItem;
import stocktracker.stockdatamodel.StockItem;

/**
 *
 * @author rtucker
 */
public class TestHarness {
    
    public void executeTests()
    {
        //Create a Physical and Service Stock Item
        System.out.println("Creating Stock Items!");
        StockItem objPhysical = new PhysicalStockItem("Halo 3", 100);
        StockItem objService = new ServiceStockItem("Delivery");
        System.out.println("Stock Items created!");
        System.out.println("Creating an observer and registering with stock items.");
        IObserver observer = new AnObserver();
        objPhysical.registerObserver(observer);
        objService.registerObserver(observer);
        System.out.println("Observer created and registered with stock items.");
        System.out.println("Changing physical stock items quantity in stock...");
        objPhysical.setQuantityInStock(99);
        System.out.println("Setting delivery service stock items selling price...");
        objService.setSellingPrice(5.00);
    }
    
    private class AnObserver implements IObserver
    {

        @Override
        public void update() {
            System.out.println("State Change was detected!!!");
        }
    }
}
