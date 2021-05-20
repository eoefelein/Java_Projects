import java.util.Scanner;
//***************************************************************
//
//  Developer:         Erin Oefelein
//
//  Program #:         Nine
//
//  File Name:         InfixToPostfixConverter.java
//
//  Course:            ITSE 2317 Intermediate Java Programming
//
//  Instructor:        Fred Kumi
//
//  Description:       InfixToPostfixConverter class.
//                  Converts an ordinary infix arithmetic expression
//                  to a postfix expression. Program reads user input to
//                  the StringBuffer infix variable
//                  and uses the Stack class to create
//                  the StringBuffer postfix expression.
//***************************************************************
public class InfixToPostfixConverter {

    public Stack<Character> stack = new Stack<>();

    public static void main(String[] args) { // main method

        InfixToPostfixConverter obj = new InfixToPostfixConverter(); // class object

        int cont = 0; // create variable to control pre-test loop
        Scanner sc = new Scanner(System.in); // create object to capture input

        developerInfo();

        while (cont != -1) {
            System.out.println("Enter expression to convert (no spaces!): ");
            //get user input infix expression
            StringBuffer infix = new StringBuffer();
            infix.append(sc.next());
            //output user input as postfix expression
            System.out.println("Postfix expression is:" + obj.convertToPostfix(infix));

            System.out.println("Enter -1 to quit. Else enter any single digit number to continue: ");
            cont = sc.nextInt(); // continue looping until user exits program

        };
    }
    //***************************************************************
    //
    //  Method:       convertToPostfix() method
    //
    //  Description:  takes the infix StringBuffer expression as input
    //                  and returns converted postfix expression as result
    //
    //  Parameters:   StringBuffer infix
    //
    //  Returns:	  StringBuffer postfix
    //**************************************************************
    public StringBuffer convertToPostfix(StringBuffer infix) {

        StringBuffer postfix = new StringBuffer(""); // variable to store converted postfix expression
        InfixToPostfixConverter obj = new InfixToPostfixConverter(); // class object

        //push a left parenthesis onto the stack
        stack.push('(');

        //append a right parenthesis to the end of infix
        infix.append(')');

        for (int i = 0; i < infix.length(); i++) { // while there is input to read

            char c = infix.charAt(i);

            // if scanned character is operand...
            if (Character.isLetterOrDigit(c))
                postfix.append(c); // ...add to output

            // if scanned character is '('...
            else if (c == '(')
                stack.push(c); // ...push onto stack

            else if (c == ')')
            // push all input back to (
            {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()); // add to output
                }
                stack.pop(); // remove '('
            }
            else // print operators occurring before which have a higher precedence
            {
                while (!stack.isEmpty() && obj.isOperator(c) && obj.precedence(c,stack.peek()))
                {
                    postfix.append(stack.pop()); // add to output
                }
                stack.push(c); // push onto stack
            }
        }
        while (!(stack.isEmpty())) // stack is not empty...
        {
            postfix.append(stack.pop()); // ...add to output
        }
        return postfix;
    }
    //***************************************************************
    //
    //  Method:       precedence() method
    //
    //  Description:  determines whether
    //              the precedence of operator1 (from the infix expression)
    //              is less than, equal to or greater than,
    //              that of operator2 (from the stack)
    //
    //  Parameters:   char x
    //
    //  Returns:	  true if operator1 has a precedence lower than that of operator2
    //                  else, returns false
    //**************************************************************
    public boolean precedence(char operator1, char operator2)
    {
        int op1Precedence = 0;
        int op2Precedence = 0;

        //assign operator1 precedence an integer value from 1-3
        if(operator1 == '+' || operator1 == '-')
            op1Precedence = 1;
        else if(operator1 == '*' || operator1 == '/' || operator1 == '%')
            op1Precedence = 2;
        else if(operator1 == '^')
            op1Precedence = 3;

        //assign operator2 precedence an integer value from 1-3
        if(operator2 == '+' || operator2 == '-')
            op2Precedence = 1;
        else if(operator2 == '*' || operator2 == '/' || operator2 == '%')
            op2Precedence = 2;
        else if(operator2 == '^')
            op2Precedence = 3;

        //compare precedence of operator1 and operator2
        if(op1Precedence <= op2Precedence)
            return true;
        else
            return false;
    }
    //***************************************************************
    //
    //  Method:       isOperator() method
    //
    //  Description:  determines if c is an operator
    //
    //  Parameters:   char c
    //
    //  Returns:	  true if c is an operator
    //                  else, returns false
    //**************************************************************
    public boolean isOperator(char c)
    {
        // if c is operator...
        if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%')
            return true; // ...return true
        else
            return false;
    }
    //***************************************************************
    //
    //  Method:       developerInfo
    //
    //  Description:  The developer information method of the program
    //
    //  Parameters:   None
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public static void developerInfo()
    {
        System.out.println ("Name:    Erin Oefelein");
        System.out.println ("Course:  ITSE 2317 Intermediate Java Programming");
        System.out.println ("Program: Nine");

    } // End of developerInfo
}
