//********************************************************************
//
//  Developer:            Erin Oefelein
//
//  Program #:            Five
//
//  File Name:            Retail_Item.java
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
//      Class defines the data and features of a Retail_Item object. Defines:
//      1) Retail_Item data attributes
//      2) Retail_Item constructor
//      3) Retail_Item mutator & accessor methods
//      4) Retail_Item toString method
//
//********************************************************************
import java.text.DecimalFormat;

public class Retail_Item {
    private int item_number;
    private String item_description;
    private int units_in_inventory;
    private double price;

    // constructor
    public Retail_Item(int item_number, String item_description, int units_in_inventory, double price) {
        this.item_number = item_number;
        this.item_description = item_description;
        this.units_in_inventory = units_in_inventory;
        this.price = price;
    }

    // setter methods
    public void setItemNumber(int itemNumber){
        item_number = itemNumber;
    }
    public void setItemDescription(String itemDescription){
        item_description = itemDescription;
    }
    public void setUnitsInInventory(int unitsInInventory){
        units_in_inventory = unitsInInventory;
    }
    public void setPrice(double itemPrice){
        price = itemPrice;
    }

    // getter methods
    public int getItemNumber(){
        return item_number;
    }
    public String getItemDescription(){
        return item_description;
    }
    public int getUnitsInInventory(){
        return units_in_inventory;
    }
    public double getPrice(){
        return price;
    }

    //***************************************************************
    //
    //  Method:       toString method
    //
    //  Description:  print String representation of retail_item object
    //
    //  Parameters:   N/A
    //
    //  Returns:      String representation of retail_item object
    //
    //**************************************************************
    @Override
    public String toString() {

        // use of DecimalFormat class to format price to two (2) decimals
        DecimalFormat df = new DecimalFormat("#.00");
        String price_formatted = df.format(price); // format price

        return item_number + " " +
                item_description + " " +
                units_in_inventory + " " +
                "$" + price_formatted;
    }
}