//********************************************************************
//
//  Developer:            Erin Oefelein
//
//  Program #:            Five
//
//  File Name:            TestProgram5.java
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
//      Program uses ArrayList to store Retail_Item objects.
//      Each object in the list holds data about an item in the retail store.
//      Using a menu, the program allows the user to select items for purchase.
//      When the user is ready to check out, the program displays:
//      1) all items selected for purchase, sorted by item description
//      2) total price
//      3) taxes
//      4) final price
//      The Program asks the user for confirmation.
//          If confirmed, all sales information is written to a file.
//          If the user does not confirm, the cash register is cleared and the program starts over.
//
//********************************************************************
import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TestProgram5 {

    // ArrayList to store Retail_Item objects
    static List<Retail_Item> retail_item_list = new ArrayList<>();

    static Cash_Register cash_register = new Cash_Register(); // initialize Cash_Register object
    static TestProgram5 program5 = new TestProgram5(); // initialize TestProgram5 object

    public static void main(String args[]) throws IOException {
        // create Scanner object
        Scanner scanner = new Scanner(System.in);

        // initialize retail item list by reading from Inventory.txt file
        program5.read_retail_item_data_from_file();

        // This loop will only end if the user selects Exit
        String input;
        do {
            System.out.println("--------------------------------");
            System.out.println("Retail Store Program");
            System.out.println("Please select an option below");
            System.out.println("[1] Select Items for Purchase");
            System.out.println("[2] Show Inventory");
            System.out.println("[3] Clear Cash Register");
            System.out.println("[4] Check Out");
            System.out.println("[5] Exit");
            System.out.print("Enter option number here: ");
            input = scanner.nextLine();

            // switch statement to control program according to user choice
            switch (input) {
                case "1":
                    program5.add_items();
                    break;
                case "2":
                    if (cash_register.getRetail_items_in_cash_register().size() > 0) {
                        cash_register.show_items();
                    } else {
                        System.out.println("No items in the cash register.");
                    }
                    break;
                case "3":
                    cash_register.clear_cash_register();
                    break;
                case "4":
                    if (cash_register.getRetail_items_in_cash_register().size() > 0) {
                        // call check out method
                        program5.check_out(cash_register.get_total(), cash_register.getRetail_items_in_cash_register());
                    } else {
                        System.out.println("No items in the cash register.");
                    }
                    break;
                case "5":
                    System.out.println("System exiting... Thank you! Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Input is not valid. Please select a valid option 1-5: ");
            }
        } while(input != "5");
    }
    //***************************************************************
    //
    //  Method:         add_items()
    //
    //  Description:    adds store items to cash register
    //
    //  Parameters:     N/A
    //
    //  Returns:        N/A
    //
    //**************************************************************
    public void add_items() {
        Scanner scanner = new Scanner(System.in);

        // display menu
        cash_register.display_menu(retail_item_list);

            try {
                System.out.print("Enter item option number here: "); // prompt user for input
                // get user input
                String input = scanner.nextLine();
                int input_value = Integer.parseInt(input);

                // validate input
                if (input_value <= retail_item_list.size()) {
                    cash_register.purchase_item(retail_item_list.get(input_value - 1));
                } else {
                    System.out.println("Invalid option number. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid option number. Please try again.");
            }
    }
    //***************************************************************
    //
    //  Method:         check_out()
    //
    //  Description:    method calculates price of items selected for purchase by
    //                      the customer in order to check out the customer
    //
    //  Parameters:     total_price, retail_items_in_cash_register
    //
    //  Returns:        N/A
    //
    //**************************************************************
    public void check_out(double total_price, List<Retail_Item> retail_items_in_cash_register) {

        // sort retail items in cash register by item description
        retail_items_in_cash_register.sort(Comparator.comparing(Retail_Item::getItemDescription));

        // print each item in the sorted list that customer has selected for purchase
        for (Retail_Item retail_item : retail_items_in_cash_register) {
            System.out.printf(retail_item.toString());
            System.out.println();
        }

        System.out.printf("%nTotal before tax: $%.2f", total_price, "%n%n"); // print subtotal

        // calculate tax
        double tax = total_price * 0.0625;

        System.out.printf("%nTax: $%.2f", tax, "%n%n"); // print tax

        // add tax and total price
        System.out.printf("%nFinal price: $%.2f", total_price + tax); // print final price
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        // loop until user confirms choice with Y or N
        String prompt;
        do {
            // prompt user to confirm check out
            System.out.print("Are you sure you want to proceed to check out? Y for Yes or N for no: ");
            prompt = scanner.next();

            if (prompt.equalsIgnoreCase("Y")) { // why is this not breaking out of loop
                program5.print_receipt(total_price, tax, retail_items_in_cash_register);
            } else if (prompt.equalsIgnoreCase("N")) {
                System.out.println("Returning to Menu...");
            } else {
                System.out.println("Invalid input. Please enter Y or N only.");
            }
        }while(!(prompt != "Y" || prompt != "N"));

        cash_register.clear_cash_register(); // clear cash register
    }
    //***************************************************************
    //
    //  Method:         print_receipt()
    //
    //  Description:    prints sales receipt
    //
    //  Parameters:     total_price, tax, retail_items_in_cash_register
    //
    //  Returns:        N/A
    //
    //**************************************************************
    public void print_receipt(double total_price, double tax, List<Retail_Item> retail_items_in_cash_register) {

        String file_name = "Program5-output.txt";
        try {
            System.out.println("Printing sales receipt...... ");

            FileWriter fileWriter = new FileWriter(file_name);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            DateTimeFormatter date_time_format = DateTimeFormatter.ofPattern("MMM/dd/yyyy HH:mm:ss");
            LocalDateTime date_time_now = LocalDateTime.now();

            // write current date time
            bufferedWriter.write(date_time_format.format(date_time_now));
            bufferedWriter.newLine(); // write new line

            // format decimal to two (2) decimal places
            NumberFormat formatter = new DecimalFormat("#0.00");

            // write randomly-generated cashier name
            bufferedWriter.write("Cashier: " + get_random_cashier_from_file());
            bufferedWriter.newLine(); bufferedWriter.newLine(); // write new line

            // write each item in sorted retail_items_in_cash_register list
            for (Retail_Item retail_item : retail_items_in_cash_register) {
                bufferedWriter.write(retail_item.toString());
                bufferedWriter.newLine(); // write new line
            }

            bufferedWriter.newLine(); // write new line

            // write total price, tax, and final price
            bufferedWriter.write("Total Price: $" + total_price);
            bufferedWriter.newLine(); // write new line
            String tax_output = String.format("%,.2f", tax);
            bufferedWriter.write("Tax: $" + tax_output);
            bufferedWriter.newLine(); // write new line
            // add tax price and total price
            bufferedWriter.write("Final Price: $" + formatter.format(total_price + tax));

            // flush characters from write buffer to intended character stream
            bufferedWriter.flush();
            bufferedWriter.close(); // close write buffer
        } catch (Exception e) {
            System.out.println("Error. Cannot write to file: " + file_name);
        }

    }
    //***************************************************************
    //
    //  Method:         read_retail_item_data_from_file()
    //
    //  Description:    reads retail_item data from file
    //                      and creates retail_item_list
    //
    //  Parameters:     N/A
    //
    //  Returns:        N/A
    //
    //**************************************************************
    public void read_retail_item_data_from_file() throws IOException {

        Scanner scanner = new Scanner(System.in);
        // variables to collect user_input and set filname
        String user_input = "";
        String filename = "";
        System.out.printf("\n %-15s \n %s \n %s \n %s", "Welcome to the Retail Store!",
                "Should you wish to stock the store with data found in a file other than Inventory.txt, ",
                "please enter that file name now.", "Otherwise enter 0: ");
        user_input = scanner.next(); // collect use_input
        if (user_input.equals("0"))
        {
            filename = "Inventory.txt";
        }
        else
        {
            filename = user_input;
        }
        // confirm user input
        System.out.printf("%s %s %s %n", "Program will use data found in", filename, "file.");

        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String currentLineInFile; // variable to track currentLineInFile

        while ((currentLineInFile = bufferedReader.readLine()) != null) {
            // get current line data as string tokens
            StringTokenizer tokens = new StringTokenizer(currentLineInFile);

            // assign token to corresponding retail_item attribute
            int item_number = Integer.parseInt(tokens.nextToken());
            String item_description = tokens.nextToken();
            int units_in_inventory =  Integer.parseInt(tokens.nextToken());
            double price = Double.parseDouble(tokens.nextToken());

            // create retail object using constructor
            Retail_Item retail_item = new Retail_Item(item_number, item_description, units_in_inventory, price);

            // add retail_item to retail_item_list
            retail_item_list.add(retail_item);
        }
    }
    //***************************************************************
    //
    //  Method:         get_random_cashier_from_file()
    //
    //  Description:    randomly selects cashier from cashiers list in file
    //
    //  Parameters:     N/A
    //
    //  Returns:        random number by which cashier_names will be indexed
    //                      to return random cashier
    //
    //**************************************************************
    public String get_random_cashier_from_file() throws IOException {

        // create FileReader object to read contents of Cashier.txt
        FileReader fileReader = new FileReader("Cashier.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String currentLineInFile; // variable to track currentLineInFile

        // create arraylist of cashier_names to store cashier names read from file
        List<String> cashier_names = new ArrayList<>();

        while ((currentLineInFile = bufferedReader.readLine()) != null) {
            // add current line in file (equal to cashier name) to cashier_names arraylist
            cashier_names.add(currentLineInFile);
        }

        // generate random number from 0 to size of the cashier_names arraylist
        int random_number = new Random().nextInt(cashier_names.size());

        // get cashier located at random_number index and return it
        return cashier_names.get(random_number);
    }
}
