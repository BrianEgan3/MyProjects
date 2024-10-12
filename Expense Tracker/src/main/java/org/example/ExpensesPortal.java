package org.example;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
/**
 * @author Brian Egan
 * @version 1.0
 * This class takes in Expense objects in an ArrayList and can print them or find the total cost of all the expenses
 */
public class ExpensesPortal implements ExpensePrinter {
    public int size =0;
    private final ArrayList<Expense> expenseList = new ArrayList<Expense>();
    public void ExpensePortal(){
    }

    /**
     * adds an expense to the expense portal
     * @param expense takes an expense object as an argument and adds it to the ArrayList
     */
    public void addExpense(Expense expense){
        expenseList.add(expense);
        size++;
    }

    /**
     * prints a summary of the expenses in the ExpensePortal
     * @param printer this calls the method from the ExpensePrinter interface
     * @return the summary of expenses as a String
     */
    public String printExpenses(ExpensePrinter printer) {
        String printExpensesString = "";
        printExpensesString += printer.print(expenseList);
        return printExpensesString;
    }

    /**
     * gets all the expenses in the ExpensePortal as an ArrayList
     * @return an ArrayList of expense objects
     */
    public ArrayList<Expense> getExpensesList(){
        return expenseList;
    }

    /**
     * Returns the total value of the expenses in the ExpensePortal in Euro (EUR). Only works with USD or EUR inputs or else the conversion is wrong
     * @return the expenses total in Euro (EUR)
     */
    public Money totalCostInEuro(){
        Money expenseTotal = Money.of(CurrencyUnit.EUR, 0);
        for (Expense expense : expenseList) {

            Money amount = expense.getAmount();
            if(amount.getCurrencyUnit() != CurrencyUnit.EUR) {
                amount = amount.convertedTo(CurrencyUnit.EUR, BigDecimal.valueOf(0.91), RoundingMode.HALF_UP);
            }
            expenseTotal = expenseTotal.plus(amount);
        }
        return expenseTotal;
    }

    /**
     * prints a summary of the expenses in an expense ArrayList
     * @param expenseList the ArrayList containing the expenses that are to be printed
     * @return the list of expenses as a String
     */
    @Override
    public String print(ArrayList<Expense> expenseList) {
        String expenseListString = "";
        for(Expense expense : expenseList){
            expenseListString += expense.toString();
        }
        System.out.println(expenseListString);
        return expenseListString;
    }
}
