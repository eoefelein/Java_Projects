//********************************************************************
//
//  Developer:            Erin Oefelein
//
//  Program #:            Two
//
//  File Name:            TwoDimensionalShape.java
//
//  Course:               ITSE 2317 Intermediate Java Programming
//
//  Due Date:             2/12/2021
//
//  Instructor:           Fred Kumi 
//
//  Chapter:              10
//
//  Description:
//     TwoDimensionalShape abstract class, implemented using the Shape class.
//********************************************************************
public abstract class TwoDimensionalShape extends Shape {
	
		// constructor
		public TwoDimensionalShape()
		{
			super();
			
		}                                       

	   //***************************************************************
	   //
	   //  Method:       toString method
	   // 
	   //  Description:  outputs Two-Dimensional information to console 
	   //
	   //  Parameters:   None
	   //
	   //  Returns:      returns String representation of Two-Dimensional object
	   //
	   //**************************************************************
		public String toString()
		{
			return String.format("%s","Dimension:\tTwo Dimensional");
			
		}
		// abstract method
		public abstract double getArea(); // no implementation
		
}
