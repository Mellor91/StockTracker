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
        PhysicalStockItem objPhysicalStockItem = new PhysicalStockItem("physical Stock", 100);
        ServiceStockItem objServiceStockItem = new ServiceStockItem("Winter");
        
        String strMessage = objPhysicalStockItem.getName() + " is in stock = " + objPhysicalStockItem.isInStock() + " quantity in stock = " + objPhysicalStockItem.getQuantityInStock();
        System.out.println(strMessage);
        
        strMessage = objServiceStockItem.getName() + " is in stock = " + objServiceStockItem.isInStock() + " quantity in stock = " + objServiceStockItem.getQuantityInStock();
        System.out.println(strMessage);
    }
    
}
