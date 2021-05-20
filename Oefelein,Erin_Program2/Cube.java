//********************************************************************
//
//  Developer:            Erin Oefelein
//
//  Program #:            Two
//
//  File Name:            Cube.java
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
//      Cube class extends ThreeDimensionalShape.
//
//********************************************************************
public class Cube extends ThreeDimensionalShape {
	
	private double edge;
	
	// constructor
	public Cube(double edge)
	{
		super();
		
		if (edge < 0.0) // validate edge                
	         throw new IllegalArgumentException("Edge must be >= 0.0");
	            
	      this.edge = edge;
	      
	}
	// set edge
	public void setREdge(double edge)
	{
		if (edge < 0.0) // validate radius                 
			throw new IllegalArgumentException("Edge must be >= 0.0");
		
		this.edge = edge;
		
	} 
	// get edge
	public double getEdge()
	{
		return edge;
	}
   //***************************************************************
   //
   //  Method:       overridden getArea method
   // 
   //  Description:  calculates surface area of Cube Shape 
   //
   //  Parameters:   None
   //
   //  Returns:      returns surface area of Cube Shape 
   //
   //**************************************************************
	@Override
	public double getArea()
	{
		return 6 * Math.pow(edge, 2);
		
	}
   //***************************************************************
   //
   //  Method:       overridden getVolume method
   // 
   //  Description:  calculates volume of Cube Shape 
   //
   //  Parameters:   None
   //
   //  Returns:      returns volume of Cube Shape 
   //
   //**************************************************************
	@Override
	public double getVolume()
	{
		return Math.pow(edge, 3);
		
	}
   //***************************************************************
   //
   //  Method:       overridden toString method
   // 
   //  Description:  outputs Cube information to console 
   //
   //  Parameters:   None
   //
   //  Returns:      returns String representation of Cube object
   //
   //**************************************************************
	@Override
	public String toString()
	{
      return String.format("Shape:\t\tCube%n%s%n%s: \t\t%.2f%n%s: \t%.2f",
    		  super.toString(),
    		  "Area", getArea(), 
    		  "Volume", getVolume()
    		  );
      }
}