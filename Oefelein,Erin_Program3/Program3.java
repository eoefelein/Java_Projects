//********************************************************************
//
//  Developer:            Erin Oefelein
//
//  Program #:            Three
//
//  File Name:            Program3.java
//
//  Course:               ITSE 2317 Intermediate Java Programming
//
//  Due Date:             3/7/2019
//
//  Instructor:           Fred Kumi
//
//  Chapter:              11
//
//  Description:
//      Program reads Program3.txt file and creates from the file's contents
//      two (2) HashMap Objects,
//      1) one whose key corresponds to a year
//         and whose value contains that year's World Series winner
//      2) and another whose key contains a baseball team
//         and whose value holds the number of times that team has won the World Series.
//
//      The program then takes in a valid year from the user.
//      The program will then return:
//      1) the World Series baseball team winner that year
//      2) and the number of times that team has won the World Series
//
//********************************************************************
import java.io.File; // allows program to gather file information
import java.io.FileNotFoundException; // signals attempt to open specified file path has failed
import java.util.HashMap; // allows program to create HashMap object
import java.util.Scanner; // allows program to get user input

public class Program3 {

    //***************************************************************
    //
    //  Method:       processFile method
    //
    //  Description:  open File & reads contents to two (2) HashMaps
    //
    //  Parameters:   String filename, HashMap<Integer,String> yearWinner,
    //                            HashMap<String,Integer> numWins
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public void processFile(String filename, HashMap<Integer,String> yearWinner, HashMap<String,Integer> numWins)
    {
        // pass filename as arg to File class
        File worldSeriesData = new File("Program3.txt");

        // Create a Scanner object
        Scanner scan;

        // Create String line variable to read each line
        String line = "";

        // try to open file and read contents to HashMap objects
        try {

            // Set startYear
            int startYear = 1903;

            // Pass filename to Scanner object
            scan = new Scanner(worldSeriesData);

            // Check for another line in input to scan
            while(scan.hasNextLine()){
                // Skip years during which the WorldSeries was not played
                if(startYear == 1904 || startYear == 1994) {
                    startYear++;
                }
                line = scan.nextLine(); // reads nextLine of String data type
                yearWinner.put(startYear, line); //  inserts a mapping into a HashMap
                if(numWins.containsKey(line)) { // checks if a key is mapped into the HashMap or not
                    numWins.put(line, numWins.get(line)+1); // if key exists, increment numWins value
                }else {
                    numWins.put(line,1); // if key does not exist, set numWins to 1
                }
                startYear++; // increment year
            }
            // except FileNotFoundException
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    //***************************************************************
    //
    //  Method:       collectInput method
    //
    //  Description:  collects and validates user input
    //
    //  Parameters:   None
    //
    //  Returns:      year variable of Integer datatype
    //
    //**************************************************************
    public int collectInput()
    {
        // Creates Scanner object to read user input
        Scanner in = new Scanner(System.in);

        int year; // Declares year
        System.out.print("\nPlease enter a year between 1903 & 2020: ");
        year = in.nextInt(); // collect the user input

        // Checks that year is either 0(sentinel value) or within range 1903 - 2020
        while (year != 0 && (year < 1903 || year > 2020)) {
            // otherwise collect a valid year.
            System.out.print("Year is invalid! Please enter a year between 1903 & 2020: ");
            year = in.nextInt();
        }

        return year; // Returns year
    }
    //***************************************************************
    //
    //  Method:       displayOutput method
    //
    //  Description:  displays winning team & number of team wins
    //                  according to user input year
    //
    //  Parameters:   Program3 winners, HashMap<Integer, String> yearWinner,
    //                          HashMap<String, Integer> numWins
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public void displayOutput(Program3 winners, HashMap<Integer, String> yearWinner, HashMap<String, Integer> numWins)
    {

        // Loops until sentinel value of 0 is entered
        while (true) {

            // Calls collectInput() method to collect input from user
            int year = collectInput();

            // Checks for sentinel value
            if (year == 0) {
                System.out.println("Thank you, goodbye!");
                return; // Ends program
            }

            // Gets the winning team for the given year
            String winningTeam = winners.getWinningTeamForYear(year, yearWinner);

            // if winning team for the given year exists...
            if (winningTeam != null) {
                // get the number of wins of that team between 1903 and 2020.
                int numOfWins = winners.getNumberOfWins(winningTeam, numWins);
                // display the winning team and number of wins.
                System.out.println("Winning Team for the Year " + year + ": " + winningTeam);
                System.out.println("Number of " + winningTeam + " Team Wins: " + numOfWins);
            }
        }
    }
    //***************************************************************
    //
    //  Method:       getWinningTeamForYear method
    //
    //  Description:  takes in the year and gets that year's winning team
    //
    //  Parameters:   int year, HashMap<Integer, String> yearWinner
    //
    //  Returns:      String winning team
    //
    //**************************************************************
    public String getWinningTeamForYear(int year, HashMap<Integer, String> yearWinner)
    {
        // if there is an entry for the given year...
        if (yearWinner.containsKey(year)) { // if yearWinner containsKey
            return yearWinner.get(year); // Returns the winning team
        }
        else {
            // Displays message and returns null
            System.out.println("World Series not held in " + year);
            return null;
        }
    }
    //***************************************************************
    //
    //  Method:       getNumberOfWins method
    //
    //  Description:  takes in the winning team and matches to key value in HashMap
    //                      to get that teams' number of wins
    //
    //  Parameters:   String winningTeam, HashMap<String, Integer> numWins
    //
    //  Returns:      HashMap int value corresponding to team's number of wins
    //
    //**************************************************************
    public int getNumberOfWins(String winningTeam, HashMap<String, Integer> numWins) {
        return numWins.get(winningTeam);
    }
    //***************************************************************
    //
    //  Method:       main method
    //
    //  Description:  creates HashMap, filename & Program3 variables
    //
    //  Parameters:   String[] args
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public static void main(String[] args)
    {

        HashMap<Integer, String> yearWinner = new HashMap<>(); // hashmap to store year and winners
        HashMap<String, Integer> numWins = new HashMap<>(); // hashmap to store winners and number of wins
        String fileName = "Program3.txt"; // file name of where data is stored
        Program3 winners = new Program3(); // Program3 object

        // Print developerInfo
        developerInfo();

        // non static method to read text file and convert to HashMap
        winners.processFile("Program3.txt", yearWinner, numWins);
        // non static method to collect user input and display program output
        winners.displayOutput(winners, yearWinner, numWins);

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
        System.out.println ("Program: Three");

    } // End of developerInfo
}
