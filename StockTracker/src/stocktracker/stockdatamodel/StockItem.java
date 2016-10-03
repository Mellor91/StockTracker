/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocktracker.stockdatamodel;

import java.util.ArrayList;
import utilities.IObserver;
import utilities.ISubject;
/**
 *
 * @author Mellor
 */
public abstract class StockItem implements ISubject
{
    protected String name = "UNKNOWN";
    protected Integer quantityInStock = 0;
    protected Double sellingPrice = 1000000.00;
    protected Double costPrice = 1000000.00;
    private ArrayList<IObserver> observers = null;
    
    public StockItem()
    {
       
    }
    
    public StockItem(String name)
    {
        this.name = name;
    }
    
    public StockItem(String name, Integer qty)
    {
        this.name = name;
        this.quantityInStock = qty;
    }

    public abstract StockType getItemType();
    
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        if(name != null && !name.isEmpty())
        {
            this.name = name;
            notifyObservers();
        }
    }

    public Integer getQuantityInStock()
    {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quanbtityInStock)
    {
        if(quantityInStock != null && quantityInStock >= 0)
        {
            this.quantityInStock = quanbtityInStock;
            notifyObservers();
        }
    }

    public Double getSellingPrice()
    {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice)
    {
        if(sellingPrice >= 0 && sellingPrice != null && sellingPrice > this.sellingPrice)
        {
            this.sellingPrice = sellingPrice;
            notifyObservers();
        }
    }

    public Double getCostPrice()
    {
        return costPrice;
    }

    public void setCostPrice(Double costPrice)
    {
        if(costPrice >= 0 && costPrice != null)
        {
            this.costPrice = costPrice;        
            notifyObservers();
        }
    }
        
    public Boolean isInStock()
    {
        Boolean result = false;
        
        if(this.quantityInStock > 0)
        {
            result = true;
        }
        return result;
    }

    @Override
    public Boolean registerObserver(IObserver o)
    {
        Boolean blnAdded = false;
        
        if(o != null)
        {
            if(this.observers == null)this.observers = new ArrayList<>();
        }
        blnAdded = this.observers.add(o);
        System.out.println("this obbserrvers added = " + this.observers.add(o));
        return blnAdded;
    }

    @Override
    public Boolean removeObserver(IObserver o)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObservers()
    {
        if(this.observers != null && this.observers.size() > 0)
        {
            for (IObserver currentObserver : this.observers)
            {
                currentObserver.update();
            }
        }
    }
}
