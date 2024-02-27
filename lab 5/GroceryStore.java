/**
 * A class for a grocery store. Complete the following tasks:
 *
 * - Implement a constructor that takes in initial values for each item type
 * - Add a method that adds inventory of a given type
 * - Add a method that returns the inventory of a given type
 */
public class GroceryStore
{
    // A set of possible items at the grocery store
    public enum GroceryItem
    {LETTUCE, TOMATO, CUCUMBER}

    private int lettuceInventory;
    private int tomatoInventory;
    private int cucumberInventory;
    private String name;

    // Implement a grocery store constructor which takes in a store name, and initial
    // amounts for each of the inventory types
    public GroceryStore(String name, int lettuce, int tomato, int cucumber)
    {
        //-----------Start below here. To do: approximate lines of code = 4
        //
        this.name = name;
        this.lettuceInventory = lettuce;
        this.tomatoInventory = tomato;
        this.cucumberInventory = cucumber;
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    // Adds the given amount of the given type to the given inventory
    // You can assume the given amount is always non-negative
    public void addInventory(GroceryItem type, int amount)
    {
        //-----------Start below here. To do: approximate lines of code = 6
        //
        if(type == GroceryItem.CUCUMBER){
            cucumberInventory+=amount;
        }
        else if(type == GroceryItem.LETTUCE){
            lettuceInventory += amount;
        }
        else{
            tomatoInventory+=amount;
    }
        
        
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    // Gets the inventory of the given type
    public int getInventory(GroceryItem type)
    {
        //-----------Start below here. To do: approximate lines of code = 7
        //
        
        if(type == GroceryItem.CUCUMBER){
            return cucumberInventory;
        }
        else if(type == GroceryItem.LETTUCE){
             return lettuceInventory;
        }
        else{
             return tomatoInventory;
    }
        
        
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
