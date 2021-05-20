//********************************************************************
//
//  Developer:            Erin Oefelein
//
//  Program #:            Five
//
//  File Name:            Cash_Register.java
//
//  Course:               ITSE 2317 Intermediate Java Programming
//
//  Due Date:             4/20/2019
//
//  Instructor:           Fred Kumi
//
//  Chapter:              19
//
//  Description:
//      Class defines the data and features of a Cash_Register object.
//      Cash_Register class can be used with Retail_Item.
//      Class defines the following methods:
//      1) display_menu
//      2) purchase_item
//      3) get_total
//      4) show_items
//      5) clear
//
//********************************************************************
import java.util.ArrayList;
import java.util.List;

public class Cash_Register {

    // ArrayList of Retail_Item objects kept internally to the Cash_Register class
    private List<Retail_Item> retail_items_in_cash_register = new ArrayList<>();

    // getter method to get ArrayList of Retail_Item objects (belonging to the Cash_Register class)
    public List<Retail_Item> getRetail_items_in_cash_register() {
        return retail_items_in_cash_register;
    }
    //***************************************************************
    //
    //  Method:         display_menu()
    //
    //  Description:    displays snapshot of items in the store
    //
    //  Parameters:     N/A
    //
    //  Returns:        None
    //
    //**************************************************************
    public void display_menu(List<Retail_Item> retail_items_in_store) {
        System.out.println("**** Menu ****");
        // helper counter variable to display item option number
        int idx = 1;
        // loop through Retail_Item objects
        for (Retail_Item retail_item : retail_items_in_store) {
            // print the Retail_Item by calling toString method
            System.out.printf("[%d] %s", idx, retail_item.toString());
            System.out.println();
            idx++; // increment helper counter variable
        }
    }
    //***************************************************************
    //
    //  Method:         purchase_item()
    //
    //  Description:    adds Retail_Item passed as argument
    //                      to retail_items_in_cash_register list
    //
    //  Parameters:     Retail_Item
    //
    //  Returns:        None
    //
    //**************************************************************
    public void purchase_item(Retail_Item retail_item)
    {
        // add the retail item in retail_items_in_cash_register arraylist
        retail_items_in_cash_register.add(retail_item);
        // confirm added item with user
        System.out.println("Item added: " + retail_item.getItemDescription());
    }
    //***************************************************************
    //
    //  Method:         get_total()
    //
    //  Description:    returns the  total  price  of  all
    //          Retail_Items objects stored in Cash_Register’s internal list
    //
    //  Parameters:     N/A
    //
    //  Returns:        totalPrice
    //
    //**************************************************************
    public double get_total() {
        double totalPrice = 0; // initialize totalPrice variable

        // loop through Retail_Item objects
        for (Retail_Item retail_item : retail_items_in_cash_register) {
            // get retail item price and add to totalPrice
            totalPrice += retail_item.getPrice();
        }
        return totalPrice; // return totalPrice
    }
    //***************************************************************
    //
    //  Method:         show_items()
    //
    //  Description:    displays data about of all
    //          Retail_Items objects stored in Cash_Register’s internal list
    //
    //  Parameters:     N/A
    //
    //  Returns:        None
    //
    //**************************************************************
    public void show_items() {
        System.out.println("****Items selected for Purchase****");
        // loop through Retail_Item objects
        for (Retail_Item retail_item : retail_items_in_cash_register) {
            // print retail_item using toString method
            System.out.println(retail_item.toString());
        }
    }
    //***************************************************************
    //
    //  Method:         clear()
    //
    //  Description:    clears objects from Cash_Register’s internal list
    //
    //  Parameters:     N/A
    //
    //  Returns:        None
    //
    //**************************************************************
    public void clear_cash_register() {
        //Clear the retail items in cash register
        retail_items_in_cash_register.clear();
        System.out.println("Cash Register cleared.");
    }
}
