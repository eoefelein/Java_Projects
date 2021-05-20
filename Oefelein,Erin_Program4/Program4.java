//********************************************************************
//
//  Developer:            Erin Oefelein
//
//  Program #:            Four
//
//  File Name:            Program4.java
//
//  Course:               ITSE 2317 Intermediate Java Programming
//
//  Due Date:             4/03/2021
//
//  Instructor:           Fred Kumi
//
//  Chapter:              11 & 12
//
//  Description:
//     Using lambdas and streams,
//     objects of Invoice class are sorted according to various attributes.
//
//********************************************************************
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program4 {
    public static void main(String[] args) {

        // Print developerInfo
        developerInfo();

        // create an array of Invoice objects
        Invoice[] invoices = {
                new Invoice(83, "Electric sander", 7, 57.98),
                new Invoice(24, "Power saw", 18, 99.99),
                new Invoice(7, "Sledge hammer", 11, 21.50),
                new Invoice(77, "Hammer", 76, 11.99),
                new Invoice(39, "Lawn mower", 3, 79.50),
                new Invoice(68, "Screwdriver", 106, 6.99),
                new Invoice(56, "Jig saw", 21, 11.00),
                new Invoice(3, "Wrench", 34, 7.50),
        };

        // create list of Invoice objects for d, e & f
        List<Invoice> invoice_list = new ArrayList<>();

        // creating some invoices and add them to invoices list
        invoice_list.add(new Invoice(83, "Electric sander", 7, 57.98));
        invoice_list.add(new Invoice(24, "Power saw", 18, 99.99));
        invoice_list.add(new Invoice(7, "Sledge hammer", 11, 21.50));
        invoice_list.add(new Invoice(77, "Hammer", 76, 11.99));
        invoice_list.add(new Invoice(39, "Lawn mower", 3, 79.50));
        invoice_list.add(new Invoice(68, "Screwdriver", 106, 6.99));
        invoice_list.add(new Invoice(56, "Jig saw", 21, 11.00));
        invoice_list.add(new Invoice(3, "Wrench", 34, 7.50));

        Program4 processing = new Program4();
        processing.sortByPartDescription(invoices);
        processing.sortByPricePerItem(invoices);
        processing.mapToPartsDescription(invoices);
        processing.mapToInvoiceValue(invoice_list);
        processing.mapToInvoiceValueRange(invoice_list);
        processing.stringLookup(invoice_list);

    //***************************************************************
    //
    //  Method:         sortByPartDescription()
    //
    //  Description: sorts invoices Array by partDescription -> displays the result
    //
    //  Parameters:     invoices
    //
    //  Returns:        None
    //
    //**************************************************************
    }
    public void sortByPartDescription(Invoice[] invoices)
    {
        // Use streams to sort the Invoice objects by partDescription
        Function<Invoice, String> part_descr = Invoice::getPartDescription;
        Comparator<Invoice> byPartDesc = Comparator.comparing(part_descr);

        System.out.printf("%nSort invoice by part description:%n");
        // Display the results
        Arrays.stream(invoices).sorted(byPartDesc).forEach(System.out::println);
    }
    //***************************************************************
    //
    //  Method:        sortByPricePerItem()
    //
    //  Description: sorts invoices Array by pricePerItem
    //                  -> displays the result
    //
    //  Parameters:     invoices
    //
    //  Returns:	    None
    //
    //**************************************************************
    public void sortByPricePerItem(Invoice[] invoices)
    {
        // Use streams to sort the Invoice objects by pricePerItem
        Function<Invoice, Double> price = Invoice::getPrice;
        Comparator<Invoice> byPrice = Comparator.comparing(price);

        System.out.printf("%nSort invoice by price:%n");
        Arrays.stream(invoices).sorted(byPrice).forEach(System.out::println);
        System.out.printf("\n");
    }
    //***************************************************************
    //
    //  Method:        mapToPartsDescription()
    //
    //  Description: maps invoice to partsDescription & quantity
    //                  -> orders results by quantity
    //
    //  Parameters:     invoices
    //
    //  Returns:	    None
    //
    //**************************************************************
    public void mapToPartsDescription(Invoice[] invoices)
    {
        // Use streams to sort the Invoice objects by pricePerItem
        Function<Invoice, Integer> quantity = Invoice::getQuantity;
        Function<Invoice, String> part_descr = Invoice::getPartDescription;
        Comparator<Invoice> byQuantity = Comparator.comparing(quantity);

        System.out.printf("%nMap invoice to description and quantity:%n");
        Arrays.stream(invoices)
                .collect(Collectors.toMap(part_descr,quantity,(q1,q2) -> q1 + q2))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> System.out.println(String.format("Description: %-15s  Quantity: %-4d",e.getKey(),e.getValue())));
    }
    //***************************************************************
    //
    //  Method:        mapToInvoiceValue()
    //
    //  Description: maps invoice to partsDescription & invoiceValue
    //                  -> orders results by invoiceValue
    //
    //  Parameters:     invoice_list
    //
    //  Returns:	    None
    //
    //**************************************************************
    public void mapToInvoiceValue(List<Invoice> invoice_list) {

        System.out.println("\nMap invoice to part description & value, then sort results by value: ");
        invoice_list.stream()
                .sorted(Comparator.comparing((i -> i.getQuantity() * i.getPrice())))
                .map(i -> String.format("Description: %-15s  Value: %-4.2f", i.getPartDescription(), i.getQuantity() * i.getPrice()))
                .forEach(System.out::println);
    }
    //***************************************************************
    //
    //  Method:        mapToInvoiceValueRange()
    //
    //  Description: maps invoice to partsDescription & invoiceValue
    //       -> selects for invoiceValue between $200-500 & orders by invoiceValue
    //
    //  Parameters:     invoice_list
    //
    //  Returns:	    None
    //
    //**************************************************************
    public void mapToInvoiceValueRange(List<Invoice> invoice_list) {

        System.out.println("\nPrint invoices whose value falls within $200 - $500");
        invoice_list.stream()
                .filter(i -> i.getPrice()*i.getQuantity()>=200 && i.getPrice()*i.getQuantity()<=500)
                .sorted(Comparator.comparing((invoice -> invoice.getQuantity()*invoice.getPrice())))
                .map(i ->String.format("Description: %-15s  Value: %-4.2f", i.getPartDescription() , i.getQuantity()*i.getPrice()))
                .forEach(System.out::println);
    }
    //***************************************************************
    //
    //  Method:        stringLookup()
    //
    //  Description: return invoice whose partDescription contains the word "saw".
    //
    //  Parameters:     invoice_list
    //
    //  Returns:	    None
    //
    //**************************************************************
    public void stringLookup(List<Invoice> invoice_list)
    {
        System.out.printf("%nPrint invoice whose part description contains \"saw\":%n");
        Invoice saw = invoice_list.stream()
                .filter(i -> i.getPartDescription().contains("saw"))
                .findFirst()
                .get();
        System.out.println(saw);
    }
    //***************************************************************
    //
    //  Method:       developerInfo
    //
    //  Description:  Displays developer information
    //
    //  Parameters:   None
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public static void developerInfo()
    {
        System.out.println ("Name:    Erin Oefelein");
        System.out.println ("Course:  ITSE 2317 Intermediate Java Programming");
        System.out.println ("Program: Four");

    } // End of developerInfo
}