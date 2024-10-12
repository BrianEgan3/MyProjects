package org.example;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the {@code Expense} class.
 */
class ExpenseTest {
    LocalDate date = LocalDate.of(2027,8,5);
    Money amount = Money.parse("USD 550");
    Expense expense = new Expense(date,"Dell 17-inch monitor",ExpenseCategory.EQUIPMENT,amount);

    /**
     * Tests if getter methods work
     */
    @Test
    public void testGetterMethods(){
    assertEquals(expense.getDate(),date);
    assertEquals(expense.getDescription(),"Dell 17-inch monitor");
    assertEquals(expense.getCategory(), ExpenseCategory.EQUIPMENT);
    assertEquals(expense.getAmount(), amount);
    }

    /**
     * Test if soString method works
     */
    @Test
    public void toStringTest(){
        String expectedString = "2027-08-05: Dell 17-inch monitor - EQUIPMENT - USD 550.00"; //the expected output of toString
        String actualString  = expense.toString(); //the actual output of toString
        System.out.println(actualString);
        assertEquals(actualString,expectedString);
    }
}