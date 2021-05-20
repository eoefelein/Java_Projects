//********************************************************************
//
//  Developer:            Erin Oefelein
//
//  Program #:            Two
//
//  File Name:            Triangle.java
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
//      Triangle class extends TwoDimensionalShape.
//
//********************************************************************
public class Triangle extends TwoDimensionalShape {
	
	private double base;
	private double height;
	
	// constructor
	public Triangle(double base, double height)
	{
		super();
		
		if (base < 0.0) // validate base               
	         throw new IllegalArgumentException("Base must be >= 0.0");
		if (height < 0.0) // validate height                
	         throw new IllegalArgumentException("Height must be >= 0.0");
	            
		this.base = base;  
		this.height = height;
	      
	}
	// set base
	public void setBase(double base)
	{
		if (base < 0.0) // validate base                 
			throw new IllegalArgumentException("Base must be >= 0.0");
		
		this.base = base;
		
	} 
	// get base
	public double getBase()
	{
		return base;
		
	}
	// set base
	public void setHeight(double height)
	{
		if (height < 0.0) // validate height                 
			throw new IllegalArgumentException("Height must be >= 0.0");
		
		this.height = height;
		
	} 
	// get base
	public double getHeight()
	{
		return height;
		
	}
   //***************************************************************
   //
   //  Method:       overridden getArea method
   // 
   //  Description:  calculates area of Triangle Shape 
   //
   //  Parameters:   None
   //
   //  Returns:      returns volume of Triangle Shape 
   //
   //**************************************************************
	@Override
	public double getArea()
	{
		return (base * height)/2;
		
	}
   //***************************************************************
   //
   //  Method:       overridden toString method
   // 
   //  Description:  outputs Triangle information to console 
   //
   //  Parameters:   None
   //
   //  Returns:      returns String representation of Triangle object
   //
   //**************************************************************
	@Override
	public String toString()
	{
		return String.format("Shape:\t\tTriangle%n%s%n%s: \t\t%.2f",
	    		  super.toString(),
	    		  "Area", getArea()
	    		  ); 
    }
}