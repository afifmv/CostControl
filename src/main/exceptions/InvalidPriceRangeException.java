package main.exceptions;

public class InvalidPriceRangeException extends Exception {
    public InvalidPriceRangeException() {
        System.out.println("The given price/quantity is invalid");

    }
}
