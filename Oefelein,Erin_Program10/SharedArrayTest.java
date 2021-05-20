//********************************************************************
//
//  Developer:            Erin Oefelein
//
//  Program #:            Ten
//
//  File Name:            SharedArrayTest.java
//
//  Course:               ITSE 2317 Intermediate Java Programming
//
//  Due Date:             5/14/2019
//
//  Instructor:           Fred Kumi 
//
//  Chapter:              23
//
//  Description:
//      Class that compares the time required for 
//		single & multi-thread programs to execute.
//
//********************************************************************
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.time.Instant;

public class SharedArrayTest {
   //***************************************************************
   //
   //  Method:       runSingleCore()
   // 
   //  Description:  runs a standard program using just one thread
   //
   //  Parameters:   None
   //
   //  Returns:      None 
   //
   //**************************************************************
	public void runSingleCore() 
	{
		
		//construct the SimpleArray and initialize to size of 15,000,000
		SimpleArray simpleArray = new SimpleArray(15000000);
		// construct singleCoreWriter object
		singlecoreArrayWriter singleCoreWriter = new singlecoreArrayWriter(simpleArray);
		
		System.out.println("\nBeginning ArrayWriter operation using the Main (1) thread only...");
		//get time at which tasks are submitted for processing
		Instant timeStart = Instant.now();
		// run ArrayWriter operation
		singleCoreWriter.run();
		// get time at which tasks finish executing
		Instant timeEnd = Instant.now();
		
		// print total sum of data contained in the sharedSimpleArray
		System.out.printf("%n%s%2d%n", "sharedSimpleArray members sum to: ", simpleArray.getTotalArray());
		long timeMillis = Duration.between(timeStart, timeEnd).toMillis(); // calculate time required to execute
		System.out.println("Total time to complete singleCore ArrayWriter operation: " + timeMillis + " milliseconds");

	}
   //***************************************************************
   //
   //  Method:       runMultiCore()
   // 
   //  Description:  runs multi-threaded program
   //
   //  Parameters:   None
   //
   //  Returns:      None 
   //
   //**************************************************************
	public void runMultiCore()
	{
		// construct the shared object and initialize to size of 15,000,000
		SimpleArray sharedSimpleArray = new SimpleArray(15000000);
		
		// get count of available cores
		int coreCount = Runtime.getRuntime().availableProcessors();
		// execute tasks with ExecutorService threadPool made up of threads equal to coreCount
		ExecutorService executorService = Executors.newFixedThreadPool(coreCount);
		
		System.out.println("\nBeginning ArrayWriter operation using six (" + coreCount +  ") threads...");   
		
		//get time at which tasks are submitted for processing
		Instant timeStart = Instant.now();
		// submit tasks for execution
		for (int i = 0; i < coreCount; i ++)
		{
			multicoreArrayWriter multiCoreWriter = new multicoreArrayWriter(sharedSimpleArray);
			executorService.execute(multiCoreWriter); // run ArrayWriter operation
			
		}
		
	    executorService.shutdown(); // shutdown executorService
	    
	    try {
		   
		   boolean tasksEnded = // wait 1 minute for writers to finish executing                               
            executorService.awaitTermination(1, TimeUnit.MINUTES);
		   
		   if (tasksEnded) {
            System.out.printf("%nAll threads executed task successfully.%n");
            }   
		   else {
            System.out.println(
               "Timed out while waiting for tasks to finish.");
            } 
		   
	    } 
	    catch (InterruptedException ex) {
		   ex.printStackTrace();
		   
	    }
	    // get time at which tasks finish executing
	    Instant timeEnd = Instant.now();
	    
	    System.out.println();
	    // print total value of data contained in the sharedSimpleArray
	    System.out.printf("%s%2d%n", "sharedSimpleArray members sum to: ", sharedSimpleArray.getTotalArray());
	    
	    long timeMillis = Duration.between(timeStart, timeEnd).toMillis();  // calculate time required to execute
	    System.out.println("Total time to complete multiCore ArrayWriter operation: " + timeMillis + " milliseconds");
		   
	}
	// main method
	public static void main(String[] arg) {
      
	   developerInfo();
	   
	   SharedArrayTest test = new SharedArrayTest();
	   test.runSingleCore();
	   test.runMultiCore();
	   
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
       System.out.println ("Program: Ten");

   } // End of developerInfo
}
