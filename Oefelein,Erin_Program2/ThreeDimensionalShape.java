//********************************************************************
//
//  Developer:            Erin Oefelein
//
//  Program #:            Two
//
//  File Name:            ThreeDimensionalShape.java
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
//     ThreeDimensionalShape abstract class, implemented using the Shape class.  
//
//********************************************************************
public abstract class ThreeDimensionalShape extends Shape {
	
	// constructor
	public ThreeDimensionalShape()
	{
		super();
	}
   //***************************************************************
   //
   //  Method:       toString method
   // 
   //  Description:  outputs Three-Dimensional information to console 
   //
   //  Parameters:   None
   //
   //  Returns:      returns String representation of Three-Dimensional object
   //
   //**************************************************************
	public String toString()
	{
      return String.format("%s","Dimension:\tThree Dimensional");
      
	}
	// abstract method
	public abstract double getArea(); // no implementation
	// abstract method
	public abstract double getVolume(); // no implementation
	
}
