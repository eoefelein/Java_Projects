//********************************************************************
//
//  Developer:            Erin Oefelein
//
//  Program #:            Two
//
//  File Name:            Circle.java
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
//      Circle class extends TwoDimensionalShape.
//
//********************************************************************
public class Circle extends TwoDimensionalShape {
	
	private double radius;
	
	// constructor
	public Circle(double radius)
	{
		super();
		
		if (radius < 0.0) // validate radius                
	         throw new IllegalArgumentException("Radius must be >= 0.0");
	            
	      this.radius = radius;
	      
	}
	// set radius
	public void setRadius(double radius)
	{
		if (radius < 0.0) // validate radius                 
			throw new IllegalArgumentException("Radius must be >= 0.0");
		
		this.radius = radius;
		
	} 
	// get radius
	public double getRadius()
	{
		return radius;
		
	}
   //***************************************************************
   //
   //  Method:       overridden getArea method
   // 
   //  Description:  calculates area of Circle Shape 
   //
   //  Parameters:   None
   //
   //  Returns:      returns volume of Cube Shape 
   //
   //**************************************************************
	@Override
	public double getArea()
	{
		return Math.PI * Math.pow(radius, 2);
		
	}
   //***************************************************************
   //
   //  Method:       overridden toString method
   // 
   //  Description:  outputs Circle information to console 
   //
   //  Parameters:   None
   //
   //  Returns:      returns String representation of Circle object
   //
   //**************************************************************
	@Override
	public String toString()
	{
      return String.format("Shape:\t\tCircle%n%s%n%s: \t\t%.2f",
    		  super.toString(),
    		  "Area", getArea()
    		  ); 
      }


}
