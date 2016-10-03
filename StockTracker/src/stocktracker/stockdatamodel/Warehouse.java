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
public class Warehouse implements ISubject, IObserver
{
    private ArrayList<StockItem> arlStockItems = new ArrayList<>();
    private ArrayList<IObserver> observers = null;
    
    public Boolean AddNewStockItem(StockItem objNewItem)
    {
        Boolean blnResult = false;
        
        if(objNewItem != null)
        {
            if(!this.arlStockItems.contains(objNewItem))
            {
                blnResult = this.arlStockItems.add(objNewItem);
                if(blnResult)
                {
                    objNewItem.registerObserver(this);
                    this.notifyObservers();
                }
            }
        }
        return blnResult;
    }
    
    public Boolean removeItemAt(Integer index)
    {
        Boolean blnResult = false;
        if(arlStockItems != null && index < arlStockItems.size() && index >= 0)
        {
            StockItem itemToRemove = arlStockItems.get(index);
            if(itemToRemove != null)
            {
                blnResult = this.deleteStockItem(itemToRemove);
            }
        }
        return blnResult;
    }
    
    public Boolean deleteStockItem(StockItem objOldItem)
    {
        Boolean blnResult = false;
        if(objOldItem != null)
        {
            if(arlStockItems != null && this.arlStockItems.size() > 0)
            {
                blnResult = this.arlStockItems.remove(objOldItem);
                if(blnResult)
                {
                    objOldItem.removeObserver(this);
                    this.notifyObservers();
                }
            }
        }
        return blnResult;
    }
    
    public ArrayList<StockItem> getStockList()
    {
        ArrayList<StockItem> arlResult = new ArrayList<>();
        for(StockItem currItem : this.arlStockItems)
        {
            arlResult.add(currItem);
        }
        
        return arlResult;
    }            
         

    @Override
    public Boolean registerObserver(IObserver o)
    {
        Boolean blnAdded = false;
        
        if(o != null)
        {
            if(this.observers == null)this.observers = new ArrayList<>();
            if(!this.observers.contains(o)) blnAdded = this.observers.add(o);
        }
        return blnAdded;
    }

    @Override
    public Boolean removeObserver(IObserver o)
    {
       Boolean blnRemoved = false;
       
       if(o != null)
       {
        if(this.observers != null && this.observers.size() > 0) blnRemoved = this.observers.remove(o);   
       }
       return blnRemoved;
    }

    @Override
    public void notifyObservers()
    {
        if(this.observers != null && this.observers.size() > 0)
        {
            for(IObserver currentObserver : this.observers)
            {
                currentObserver.update();
            }
        }
    }

    @Override
    public void update()
    {
        this.notifyObservers();
    }
    
}
