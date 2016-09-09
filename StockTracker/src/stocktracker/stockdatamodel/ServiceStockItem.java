/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocktracker.stockdatamodel;

/**
 *
 * @author Mellor
 */
public class ServiceStockItem extends StockItem
{
    public ServiceStockItem(String name)
    {
        super(name);
    }
    public ServiceStockItem(String name, Integer qty)
    {
        super(name, 0);
    }
    
    public StockType getItemType()
    {
        return StockType.SERVICEITEM;
    }

    @Override
    public Boolean isInStock()
    {
        return true;
    }

    //ATTEMPTED ADDITIONAL
    @Override
    public void setCostPrice(Double costPrice)
    {
        super.setCostPrice(0.00); //To change body of generated methods, choose Tools | Templates.
    }
    
 
    
    
}
