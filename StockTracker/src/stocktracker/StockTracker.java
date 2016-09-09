/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocktracker;

import stocktracker.stockdatamodel.*;

/**
 *
 * @author Mellor
 */
public class StockTracker 
{

    
    public static void main(String[] args) 
    {
        testStockItemType();
    }
    
    public static void testStockItemType()
    {
        StockItem objTestItem1 = new ServiceStockItem("Starcraft Manual");
        StockItem objTestItem2 = new PhysicalStockItem("Halo 3", 100);
        StockItem objTestItem3 = new ServiceStockItem("Starcraft Manual");
                
        StockItem[] objects = {objTestItem1, objTestItem2, objTestItem3};
        
        for(StockItem obj : objects)
        {
            if(obj.getItemType() == StockType.PHYSICALITEM)
            {
                System.out.println("StockItem is Physical");
            }
            else
            {
                System.out.println("StockItem is **NOT** Physical");
            }
        }
    }
    
}
