//********************************************************************
//
//  Developer:            Erin Oefelein
//
//  Program #:            Two
//
//  File Name:            Square.java
//
//  Course:               ITSE 2317 Intermediate Java Programming
//
//  Due Date:             2/12/2019
//
//  Instructor:           Fred Kumi 
//
//  Chapter:              10
//
//  Description:
//      Square class extends TwoDimensionalShape.
//
//********************************************************************
public class Square extends TwoDimensionalShape {
	
	private double length;
	
	// constructor
	public Square(double length)
	{
		super();
		
		if (length < 0.0) // validate radius                
	         throw new IllegalArgumentException("Radius must be >= 0.0");
	            
	      this.length = length;
	      
	}
	// set length
	public void setLength(double length)
	{
		if (length < 0.0) // validate radius                 
			throw new IllegalArgumentException("Length must be >= 0.0");
		
		this.length = length;
		
	} 
	// get length
	public double getLength()
	{
		return length;
		
	}
   //***************************************************************
   //
   //  Method:       overridden getArea method
   // 
   //  Description:  calculates area of Square Shape 
   //
   //  Parameters:   None
   //
   //  Returns:      returns volume of Square Shape 
   //
   //**************************************************************
	@Override
	public double getArea()
	{
		return Math.pow(length, 2);
		
	}
   //***************************************************************
   //
   //  Method:       overridden toString method
   // 
   //  Description:  outputs Square information to console 
   //
   //  Parameters:   None
   //
   //  Returns:      returns String representation of Square object
   //
   //**************************************************************
	@Override
	public String toString()
	{
		return String.format("Shape:\t\tSquare%n%s%n%s: \t\t%.2f",
	    		  super.toString(),
	    		  "Area", getArea()
	    		  );  
      }

}
