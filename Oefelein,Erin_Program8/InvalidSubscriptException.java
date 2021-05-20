//********************************************************************
//
//  Developer:            Erin Oefelein
//
//  Program #:            Eight
//
//  File Name:            InvalidSubscriptException.java
//
//  Course:               ITSE 2317 Intermediate Java Programming
//
//  Due Date:             4/30/2021
//
//  Instructor:           Fred Kumi
//
//  Chapter:              20
//
//  Description:
//      InvalidSubscriptException throws an error & prints an error message
//      when the user enters an index that falls out of range of the given array.
//
//********************************************************************
public class InvalidSubscriptException extends RuntimeException { // inherits the RuntimeException class

    public InvalidSubscriptException(String message){

        super(message); // constructor consisting of one (1) arg

    }
}