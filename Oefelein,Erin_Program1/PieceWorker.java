//********************************************************************
//
//  Developer:            Erin Oefelein
//
//  Program #:            One
//
//  File Name:            PieceWorker.java
//
//  Course:               ITSE 2317 Intermediate Java Programming
//
//  Due Date:             2/08/2021
//
//  Instructor:           Fred Kumi 
//
//  Chapter:              9 & 10
//
//  Description:
//     PieceWorker concrete class, implemented using the Employee abstract class.  
//
//********************************************************************
public class PieceWorker extends Employee {

	// stores the employee's wage
	private double wage;
	// stores the employee's pieces
	private double pieces;
	
	// 3) Do I need to incldue full documentation here,
	// as is done with all class methods?
	// constructor
	public PieceWorker(String firstName, String lastName, 
		      String socialSecurityNumber, double wage,
		      double pieces)
	{
		super(firstName, lastName, socialSecurityNumber);
		
	// 1) do I need to validate here, if  I validate in the set method?
		if (wage < 0.0) // validate wage
	         throw new IllegalArgumentException(
	            "Hourly salary must be >= 0.0");
		
		if (pieces < 0.0) // validate pieces
        throw new IllegalArgumentException(
           "Pieces produced must be >= 0");
	
	      this.wage = wage;
	      this.pieces = pieces;
	 } 
	// 2) Create an array of Employee variables to store references to objects of each  concrete  class  inthe  new  Employee  hierarchy. This has been done in the PayRoll System Test file, correct?
   //***************************************************************
   //
   //  Method:       setWage() method
   // 
   //  Description:  validates and sets wage
   //
   //  Parameters:   wage
   //
   //  Returns:		 None
   //
   //**************************************************************
	public void setWage(double wage)
	{
		if (wage < 0.0) // validate wage
         throw new IllegalArgumentException(
            "Hourly wage must be >= 0.0");

		this.wage = wage;
	} 
   //***************************************************************
   //
   //  Method:       getWage() method
   // 
   //  Description:  gets wage
   //
   //  Parameters:   None
   //
   //  Returns:		 returns PieceWorker wage
   //
   //**************************************************************
	public double getWage()
	{
		return wage;
	} 
   //***************************************************************
   //
   //  Method:       setPieces() method
   // 
   //  Description:  validates and sets number of pieces
   //
   //  Parameters:   pieces
   //
   //  Returns:		 None
   //
   //**************************************************************
	public void setPieces(int pieces)
	{
		if (pieces < 0) // validate pieces
         throw new IllegalArgumentException(
            "Pieces produced must be >= 0");

		this.pieces = pieces;
	} 
   //***************************************************************
   //
   //  Method:       getPieces() method
   // 
   //  Description:  gets number of pieces
   //
   //  Parameters:   None
   //
   //  Returns:		 returns PieceWorker pieces
   //
   //**************************************************************
	public double getPieces()
	{
		return pieces;
	}
   //***************************************************************
   //
   //  Method:       overridden earnings method
   // 
   //  Description:  calculates PieceWorker earnings to console 
   //
   //  Parameters:   None
   //
   //  Returns:      returns PieceWorker earnings
   //
   //**************************************************************
	@Override                                                            
	public double earnings()                                             
	{                                                                    
		return getWage() * getPieces();                    
	}              
   //***************************************************************
   //
   //  Method:       overridden toString method
   // 
   //  Description:  outputs PieceWorker information to console 
   //
   //  Parameters:   None
   //
   //  Returns:      returns String representation of PieceWorker object
   //
   //**************************************************************
	@Override                                                             
	public String toString()                                              
	{                                                                     
		return String.format("PieceWorker: %s%n%s: $%,.2f; %s: %,.2f",
				super.toString(), 
				"hourly wage", getWage(),
				"pieces produced", getPieces());
	}
}
