/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.ArrayList;
import stocktracker.stockdatamodel.PhysicalStockItem;
import stocktracker.stockdatamodel.ServiceStockItem;
import stocktracker.stockdatamodel.StockItem;
import stocktracker.stockdatamodel.Warehouse;

/**
 *
 * @author rtucker
 */
public class TestHarness {
    
    public void executeChangeStockAttributesTests()
    {
        //Create a Physical and Service Stock Item
        System.out.println("Creating Stock Items and changing the price and quantity!");
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
        System.out.println();
    }
    
    public void executeAddRemoveWearhouseItemTest()
    {
        System.out.println("Adding and removing stock items to the warehouse!");
        StockItem objTestItem1 = new PhysicalStockItem("Starcraft Manual");
        StockItem objTestItem2 = new ServiceStockItem("Delivery");
        
        Warehouse wh = new Warehouse();
        AnObserver ob = new AnObserver();
        wh.registerObserver(ob);
        
        wh.AddNewStockItem(objTestItem1);
        wh.AddNewStockItem(objTestItem2);
        
        objTestItem1.setCostPrice(2.00);
        
        wh.removeItemAt(0);
        
        wh.deleteStockItem(objTestItem2);
        
        System.out.println("Should see five (5) state changes");
        
        ArrayList<StockItem> stockList = wh.getStockList();
        System.out.println("Stocklist size is: " + stockList.size() + ". (this should be zero (0))");
    }
    
    private class AnObserver implements IObserver
    {

        @Override
        public void update() {
            System.out.println("State Change was detected!!!");
        }
    }
}
