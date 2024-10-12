package org.example;
import org.joda.money.Money;
import  java.time.LocalDate;

/**
 * @author Brian Egan
 * @version 1.0
 * This class holds Expense objects which contain details of each expense
 */
public class Expense {
    private LocalDate date;
    private String description;
    private boolean approved = false;
    private ExpenseCategory category;
    private Money amount;

    /**
     *
     * @param date date of the expense in format (YYYY-MM-DD). Object of java.time.LocalDate class
     * @param description string object containing description of the expense
     * @param category ExpenseCategory Enum. defines which category the expense is part of
     * @param amount contains an org.joda.money.Money object which has a numerical value and a currency
     */
    public Expense(LocalDate date, String description , ExpenseCategory category, Money amount){
        this.date = date;
        this.description=description;
        this.category=category;
        this.amount = amount;
    }

    /**
     * returns the date of the expense
     * @return the date of the expense
     */
    public LocalDate getDate(){
        return date;
    }

    /**
     * returns the description of the expense as a string
     * @return the description of the expense
     */
    public String getDescription(){
        return description;
    }

    /**
     * returns if the expense is approved or not
     * @return the approved boolean
     */
    public boolean getApproved(){
        return approved;
    }

    /**
     * returns the Expense Category of the expense
     * @return the category of the expense
     */
    public ExpenseCategory getCategory() {
        return category;
    }

    /**
     * returns the monetary value of the expense and the currency associated with it
     * @return the monetaary value of the expense as an org.joda.money.Money object
     */
    public Money getAmount(){
        return amount;
    }

    /**
     * approves an expense.
     * Sets the value of the approved boolean to true
     */
    public void approveExpense(){
        approved = true;
    }

    /**
     * To string method
     * returns the Expense object as a string in the form (date-description-category-amount)
     * @return
     */
    @Override
    public String toString(){
        String string = "";
        string += date.toString() + ": ";
        string += description + " - ";
        string += category + " - ";
        string += amount.toString();

        return string;
    }
}