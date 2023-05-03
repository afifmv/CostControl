package main.model;

import main.model.Exceptions.InvalidPriceRangeException;

public class Earning extends Expenditure {
    public Earning(String reason, int price) throws InvalidPriceRangeException {
        super(reason, price);
    }
}
