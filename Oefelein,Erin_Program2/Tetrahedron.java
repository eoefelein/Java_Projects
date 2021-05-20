//********************************************************************
//
//  Developer:            Erin Oefelein
//
//  Program #:            Two
//
//  File Name:            Tetrahedron.java
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
//      Tetrahedron class extends ThreeDimensionalShape.
//
//********************************************************************
public class Tetrahedron extends ThreeDimensionalShape {
	
	private double edge;
	
	// constructor
	public Tetrahedron(double edge)
	{
		super();
		
		if (edge < 0.0) // validate edge                
	         throw new IllegalArgumentException("Edge must be >= 0.0");
	            
	      this.edge = edge;
	      
	}
	// set edge
	public void setEdge(double edge)
	{
		if (edge < 0.0) // validate edge                
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
   //  Description:  calculates surface area of Tetrahedron Shape 
   //
   //  Parameters:   None
   //
   //  Returns:      returns surface area of Tetrahedron Shape 
   //
   //**************************************************************
	@Override
	public double getArea()
	{
		return Math.sqrt(3) * Math.pow(edge, 2);
		
	}
   //***************************************************************
   //
   //  Method:       overridden getVolume method
   // 
   //  Description:  calculates volume of Tetrahedron Shape 
   //
   //  Parameters:   None
   //
   //  Returns:      returns volume of Tetrahedron Shape 
   //
   //**************************************************************
	@Override
	public double getVolume()
	{
		return Math.pow(edge, 3) / (6.0 * Math.sqrt(2));
		
	}
   //***************************************************************
   //
   //  Method:       overridden toString method
   // 
   //  Description:  outputs Tetrahedron information to console 
   //
   //  Parameters:   None
   //
   //  Returns:      returns String representation of Tetrahedron object
   //
   //**************************************************************
	@Override
	public String toString()
	{
      return String.format("Shape:\t\tTetrahedron%n%s%n%s: \t\t%.2f%n%s: \t%.2f",
    		  super.toString(),
    		  "Area", getArea(), 
    		  "Volume", getVolume()
    		  );
   } 

}