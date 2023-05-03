package main.model.Exceptions;

public class InvalidCategoryException extends Exception{
    public void InvalidCategoryException() {
        System.out.println("The selected category does not exist.");
    }
}
