package org.example;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the {@code PrinterByLabel} class.
 */

class PrinterByLabelTest {
    //creating all the objects and variables to add to the expenses
    Money amount1 = Money.of(CurrencyUnit.USD, 540);
    Money amount2 = Money.of(CurrencyUnit.EUR, 5.99);
    Money amount3 = Money.of(CurrencyUnit.EUR, 2.20);
    LocalDate date1 = LocalDate.of(2027,8,5);
    LocalDate date2 = LocalDate.of(2027,7,12);
    LocalDate date3 =  LocalDate.of(2029,6,01);
    //creating the expense objects for the tests
    Expense expense1 = new Expense(date1,"Dell 17-inch monitor",ExpenseCategory.EQUIPMENT,amount1);
    Expense expense2 = new Expense(date2,"Spotify",ExpenseCategory.ENTERTAINMENT,amount2);
    Expense expense3 = new Expense(date3,"2L Milk",ExpenseCategory.SUPPLIES,amount3);

    /**
     * This method tests the functionality of the {@code print} method which prints
     * expenses grouped by their categories.
     */
    @Test
    public void printByLabelTest() {
        PrinterByLabel printerByLabel = new PrinterByLabel();
        ExpensesPortal expensesPortal = new ExpensesPortal();

        //adding expenses to the portal
        expensesPortal.addExpense(expense1);
        expensesPortal.addExpense(expense2);
        expensesPortal.addExpense(expense3);

        //calls printerByLabel.print method
        String labelStringTest = printerByLabel.print(expensesPortal.getExpensesList());

        String expectedString = //the expected output of the printerByLabel.print method
                        "TRAVEL_AND_SUBSISTENCE\n" +
                        "\nSUPPLIES\n" +
                        "2029-06-01: 2L Milk - SUPPLIES - EUR 2.20" +
                        "\nENTERTAINMENT\n" +
                        "2027-07-12: Spotify - ENTERTAINMENT - EUR 5.99" +
                        "\nEQUIPMENT\n" +
                        "2027-08-05: Dell 17-inch monitor - EQUIPMENT - USD 540.00" +
                        "\nOTHER\n";

        assertEquals(labelStringTest, expectedString); //asset that expected output is the same as actual output

    }
}