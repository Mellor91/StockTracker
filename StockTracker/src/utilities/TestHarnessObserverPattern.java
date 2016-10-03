/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.Scanner;

/**
 *
 * @author rtucker
 */
public class TestHarnessObserverPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        TestHarness objTester = new TestHarness();
        Integer userInputResult = 0;
        
        System.out.println("Which test would you like to run?");
        System.out.println("1: Observer Testing on updating stock attributes");
        System.out.println("2: Adding and removing warehouse items?");
        Scanner userInput = new Scanner(System.in);
        userInputResult = userInput.nextInt();
        
        switch(userInputResult)
        {
            case 1:
                objTester.executeChangeStockAttributesTests();
                break;
            case 2:
                objTester.executeAddRemoveWearhouseItemTest();
                break;
            default:
                System.out.println("NOT A RECOGNISED COMMAND!");
                break;
        }
        
        
       
    }
}
