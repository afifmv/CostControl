package main.model;

import main.exceptions.InvalidCategoryException;
import main.exceptions.InvalidPriceRangeException;

public class Expense extends Expenditure {
    private CATEGORY category;

    public Expense(String reason, int price, String category) throws InvalidPriceRangeException, InvalidCategoryException {
        super(reason, price);
        processCategory(category);
    }

    private void processCategory(String category) throws InvalidCategoryException {
        String lowerCaseCategory = category.toLowerCase();
        if (lowerCaseCategory.equals("travel")) {
            this.category = CATEGORY.TRAVEL;
        } else if (lowerCaseCategory.equals("entertainment")) {
            this.category = CATEGORY.ENTERTAINMENT;
        } else if (lowerCaseCategory.equals("food")) {
            this.category = CATEGORY.FOOD;
        } else if (lowerCaseCategory.equals("fees")) {
            this.category = CATEGORY.FEES;
        } else {
            throw new InvalidCategoryException();
        }
    }

    public enum CATEGORY {
        TRAVEL, FOOD, ENTERTAINMENT, FEES, OTHER
    }
}
