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
//      Class that writes values to SimpleArray using only Main thread.
//
//********************************************************************
import java.security.SecureRandom;

public class singlecoreArrayWriter {
	
	private final SimpleArray sharedSimpleArray;
	
	// secure random number generator
	private static final SecureRandom generator = new SecureRandom();
	
	// constructor
	public singlecoreArrayWriter(SimpleArray array)
	{
		sharedSimpleArray = array;
		
	}
   //***************************************************************
   //
   //  Method:       run() method
   // 
   //  Description:  returns size of the SimpleArray
   //
   //  Parameters:   None
   //
   //  Returns:      returns size 
   //
   //**************************************************************
	public void run() {
	   // get length of sharedSimpleArray
	   int length = sharedSimpleArray.getSize();
      
	   for (int i = 0; i < length; i++) {
           // generate random number between 1 and 20  
		   int randNum = (generator.nextInt(20) + 1);
    		  sharedSimpleArray.add(randNum); // add number to shared array
      } 
   }

}
