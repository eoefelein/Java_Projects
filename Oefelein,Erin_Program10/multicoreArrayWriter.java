//********************************************************************
//
//  Developer:            Erin Oefelein
//
//  Program #:            Ten
//
//  File Name:            multicoreArrayWriter.java
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
//      Class that implements Runnable interface,
//		to write values to SimpleArray using multiple threads.
//
//********************************************************************
import java.security.SecureRandom;

public class multicoreArrayWriter implements Runnable {
	
	public final SimpleArray sharedSimpleArray;
	
	// secure random number generator
	private static final SecureRandom generator = new SecureRandom();

    // constructor
	public multicoreArrayWriter(SimpleArray array)
	{
		sharedSimpleArray = array;
		
	}
   //***************************************************************
   //
   //  Method:       overridden run() method
   // 
   //  Description:  returns size of the SimpleArray
   //
   //  Parameters:   None
   //
   //  Returns:      returns size 
   //
   //**************************************************************
	@Override
   public void run() {
	   
		//get count of available cores
	   int coreCount = Runtime.getRuntime().availableProcessors();
	   // calculate number of iterations
	   int length = sharedSimpleArray.getSize()/coreCount;
      
	   for (int i = 0; i < length; i++) {
		   	  // generate random number between 1 and 20
    		  int randNum = (generator.nextInt(20) + 1);
    		  sharedSimpleArray.add(randNum); // add number to shared array
      } 
   }
}
