/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author Mellor
 */
public interface ISubject
{
    Boolean registerObserver(IObserver o);
    Boolean removeObserver(IObserver o);
    void notifyObservers();
}
