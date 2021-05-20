//********************************************************************
//
//  Developer:            Erin Oefelein
//
//  Program #:            Ten
//
//  File Name:            SimpleArray.java
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
//      Class that manages an integer array to be shared by multiple
// 		threads with synchronization.
//
//********************************************************************
import java.util.Arrays;

public class SimpleArray {
  
	private final int[] array; // the shared integer array
	private int writeIndex = 0; // index of next element to be written
	
	public int size = 0; // stores the size of the array
	private int totalArray = 0; // stores the sum  of members of the array
	
	// constructor
	public SimpleArray(int size) { // constructs a SimpleArray of a given size
      array = new int[size];
      this.size = size;
      
	} 
   //***************************************************************
   //
   //  Method:       getSize method
   // 
   //  Description:  returns size of the SimpleArray
   //
   //  Parameters:   None
   //
   //  Returns:      returns size 
   //
   //**************************************************************
   public int getSize()
   {
	   return this.size;
   }
   //***************************************************************
   //
   //  Method:       getTotalArray method
   // 
   //  Description:  returns total sum of all members of the SimpleArray
   //
   //  Parameters:   None
   //
   //  Returns:      returns size 
   //
   //**************************************************************
   public int getTotalArray()
   {
	   return totalArray;
   }
   //***************************************************************
   //
   //  Method:       add method
   // 
   //  Description:  this method both,
   //					adds value to the indexed position in the array,
   //					and increments totalArray by value
   //
   //  Parameters:   None
   //
   //  Returns:      N/A
   //
   //**************************************************************
   public synchronized void add(int value) {
      int position = writeIndex; // store the write index
      
      array[position] = value; // put value in the appropriate element             

      totalArray += value; // adds value to totalArray count
      
      ++writeIndex; // increment index of element to be written next
   } 
   //***************************************************************
   //
   //  Method:       add method
   // 
   //  Description:  used to output contents of the shared integer array
   //
   //  Parameters:   None
   //
   //  Returns:      N/A
   //
   //**************************************************************
   @Override
   public synchronized String toString() {
      return Arrays.toString(array);
   } 
}
