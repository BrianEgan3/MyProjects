package org.example;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the {@code ExpensesPortal} class.
 */
class ExpensePortalTest {
    Money amount1 = Money.of(CurrencyUnit.USD, 550);
    Money amount2 = Money.of(CurrencyUnit.EUR, 5.99);
    Money amount3 = Money.of(CurrencyUnit.EUR, 2.20);
    LocalDate date1 = LocalDate.of(2027,8,5);
    LocalDate date2 = LocalDate.of(2027,7,12);
    LocalDate date3 =  LocalDate.of(2029,6,01);

    Expense expense1 = new Expense(date1,"Dell 17-inch monitor",ExpenseCategory.EQUIPMENT,amount1);
    Expense expense2 = new Expense(date2,"Spotify",ExpenseCategory.ENTERTAINMENT,amount2);
    Expense expense3 = new Expense(date3,"2L Milk",ExpenseCategory.SUPPLIES,amount3);
    ExpensesPortal expensesPortal = new ExpensesPortal();

    /**
     * This method tests the print expenses method
     */
    @Test
    public void printExpensesTest(){
        expensesPortal.addExpense(expense1); //adding an expense to the expenses portal
        String actualOutput = expensesPortal.printExpenses(expensesPortal);
        String expectedOutput = "2027-08-05: Dell 17-inch monitor - EQUIPMENT - USD 550.00"; //the string output that is expected
        assertEquals(expectedOutput,actualOutput);
    }

    /**
     * This test uses a lambda function to call the printExpenses method
     */
    @Test
    public void printWithLambdaTest(){
        String expectedOutput = "2027-08-05: Dell 17-inch monitor - EQUIPMENT - USD 550.00";
        expensesPortal.addExpense(expense1);
        expensesPortal.printExpenses(
                (expenses) -> {// Lambda expression representing the implementation of the ExpensePrinter interface's print method.
                    String expensesString = ""; //empty string to append the expenses to
                    //for loop appends each expense to the string
                    for (Expense expense : expenses){
                        expensesString += expense.toString();
                        System.out.println(expense);
                    }
                    assertEquals(expensesString,expectedOutput);// Checks actual output string matches expected output string
                    return expensesString;
                });
        ;
    }

    /**
     * This test tests the printExpenses method using an anonymous inner class
     */
    @Test
    public void printWithAnonymousInnerClassTest(){
        //expected output string
        String expectedOutput = "There are 3 expenses in the system totalling to a value of EUR 508.69";
        //add each expense to the expense list
        expensesPortal.addExpense(expense1);
        expensesPortal.addExpense(expense2);
        expensesPortal.addExpense(expense3);

        //call the printExpenses method from expensePortal using an anonymous inner class that implements ExpensePrinter
        expensesPortal.printExpenses(new ExpensePrinter() {
            //override the print method of the ExpensePrinter class
            @Override
            public String print(ArrayList<Expense> expenseList) {
                //create new string that is correctly formatted and holds information on the expense list size and total price of all expenses
                String totalCostString = "There are " + expenseList.size()+ " expenses in the system totalling to a value of " + expensesPortal.totalCostInEuro();
                System.out.println(totalCostString);//print out the totalCostString
                assertEquals(totalCostString,expectedOutput);//check if actual output is the same as the expected
                return totalCostString;
            }
        });
    }
}