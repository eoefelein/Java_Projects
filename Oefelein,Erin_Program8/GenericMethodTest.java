//********************************************************************
//
//  Developer:            Erin Oefelein
//
//  Program #:            Eight
//
//  File Name:            Program8.java
//
//  Course:               ITSE 2317 Intermediate Java Programming
//
//  Due Date:             4/30/2021
//
//  Instructor:           Fred Kumi
//
//  Chapter:              20
//
//  Description:
//      Program overloads generic method, printArray,
//      so that it takes two (2) additional arguments, lowSubscript and highSubscript.
//      A call to the overloaded method will only print the designated portion of the array.
//      If lowSubscript & highSubscript are valid,
//      the overloaded method will return the number of elements printed.
//
//********************************************************************
public class GenericMethodTest {

    //***************************************************************
    //
    //  Method:       generic printArray() method
    //
    //  Description:  prints an array of any data type
    //
    //  Parameters:   T[] inputArray
    //
    //  Returns:	  N/A
    //
    //***************************************************************
    public static <T> void printArray(T[] inputArray)
    {
        for (T element : inputArray)
            System.out.printf("%s, ", element); // display array elements
    }

    //***************************************************************
    //
    //  Method:       overloaded printArray() method
    //
    //  Description:  prints only the designated portion of the array,
    //                  as designated by the lowSubscript and highSubscript values
    //
    //  Parameters:   T[] inputArray, int lowSubscript, int highSubScript
    //
    //  Returns:	  the length of the array,
    //                  found by subtracting the lowSubscript from the highSubscript
    //
    //***************************************************************
    public <T> int printArray(T[] inputArray, int lowSubscript, int highSubScript)
    {
        // validate the subscripts
        if(lowSubscript < 0 || highSubScript > inputArray.length)
            // thrown if either lowSubscript or highSubscript is out of range
            throw new InvalidSubscriptException("\nSubscripts entered are invalid!" +
                    " Please pass a number corresponding to an index found within the array.");

        for (int idx=lowSubscript; idx < highSubScript; idx++)
        {
            System.out.printf("%s, ", inputArray[idx]); // display only designated array elements
        }
        return highSubScript-lowSubscript; // return number of array elements printed
    }

    //***************************************************************
    //
    //  Method:       main
    //
    //  Description:  The main method; drives program execution
    //
    //  Parameters:   String array
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public static void main(String[] args)
    {
        GenericMethodTest test = new GenericMethodTest();

        Character[] charArray={'A', 'B', 'C', 'D', 'E'};
        Integer[] intArray={1, 2, 3, 4, 5};
        Double[] doubleArray={1.0, 5.5, 8.9, 4.2, 9.6};

        // generic printArray method calls
        System.out.println("\nGeneric printArray method calls:");
        System.out.printf("%n%s", "charArray contains: ");
        printArray(charArray); // pass Character array as argument to generic printArray method

        System.out.printf("%n%s", "intArray contains: ");
        printArray(intArray); // pass Integer array as argument to generic printArray method

        System.out.printf("%n%s", "doubleArray contains: ");
        printArray(doubleArray); // pass Double array as argument to generic printArray method

        // overloaded printArray method calls
        System.out.println("\n\nOverloaded printArray method calls:");
        try {
            System.out.printf("%n%s", "Designated segment of charArray contains: ");
            int a = test.printArray(charArray, 0, 6);
            System.out.printf("%n%s%d%s%n", "overloaded printArray method displays ", a, " charArray elements.");
        }
        catch (InvalidSubscriptException e) { // if program sees an InvalidSubscriptException...
            System.out.println(e.getMessage()); // ... then print the error message
        }
        try {
            System.out.printf("%n%s", "Designated segment of intArray contains: ");
            int b = test.printArray(intArray, 1, 3);
            System.out.printf("%n%s%d%s%n", "Overloaded printArray method output displays ", b, " intArray elements.");
        }
        catch (InvalidSubscriptException e) { // if program sees an InvalidSubscriptException...
            System.out.println(e.getMessage()); // ... then print the error message
            }
        try {
            System.out.printf("%n%s", "Designated segment of doubleArray contains: ");
            int c = test.printArray(doubleArray, 0, 4);
            System.out.printf("%n%s%d%s%n", "Overloaded printArray method output displays ", c, " doubleArray elements.");
        }
        catch (InvalidSubscriptException e) { // if program sees an InvalidSubscriptException...
            System.out.println(e.getMessage()); // ... then print the error message
        }
    }
    //***************************************************************
    //
    //  Method:       developerInfo
    //
    //  Description:  The developer information method of the program
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
        System.out.println ("Program: Eight");

    } // End of developerInfo
}
