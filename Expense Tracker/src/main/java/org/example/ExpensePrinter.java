package org.example;
import java.util.ArrayList;
/**
 * This is an interface that defines a single method for printing expenses.
 * <p>
 *  The method is takes an ArrayList of expenses as an argument and prints the details of it. It returns the string it prints.
 *  This interface can be used as a lambda expression.
 * </p>
 *
 */
@FunctionalInterface
public interface ExpensePrinter {
    public String print(ArrayList<Expense> expenseList);
}
