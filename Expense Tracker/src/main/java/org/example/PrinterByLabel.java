package org.example;
import java.util.ArrayList;

/**
 * This class groups a list of expenses by category and prints the result
 */
public class PrinterByLabel implements ExpensePrinter {
    /**
     * prints a list of expenses grouped by category. Adds the expenses in to separate ArrayLists for each category and prints them from there
     * @param expenseList , an ArrayList containing the expenses it will print
     * @return returns the list of grouped expenses as a string
     */
    @Override //overrides ExpensePrinter interface
    public String print(ArrayList<Expense> expenseList) {
        String labelString = ""; //string everything gets appended to it and is printed in the end

        //TRAVEL_AND_SUBSISTENCE
        ArrayList<Expense> travelAndSubsistenceArray = new ArrayList<Expense>(); //ArrayList for adding travel expenses
        for (int i = 0; i < expenseList.size(); i++) { //loop adds all travel and subsistence expenses
            if (expenseList.get(i).getCategory() == ExpenseCategory.TRAVEL_AND_SUBSISTENCE) {
                travelAndSubsistenceArray.add(expenseList.get(i));
            }
        }
        //SUPPLIES
        ArrayList<Expense> suppliesArray = new ArrayList<Expense>(); //ArrayList for adding supplies expenses
        for (int i = 0; i < expenseList.size(); i++) {//Loop adds supplies expenses to array
            if (expenseList.get(i).getCategory() == ExpenseCategory.SUPPLIES) { //checks if its a supplies expense
                suppliesArray.add(expenseList.get(i));
            }
        }
        //ENTERTAINMENT
        ArrayList<Expense> entertainmentArray = new ArrayList<Expense>();//ArrayList for adding entertainment expenses
        for (int i = 0; i < expenseList.size(); i++) {
            if (expenseList.get(i).getCategory() == ExpenseCategory.ENTERTAINMENT) {
                entertainmentArray.add(expenseList.get(i));
            }
        }
        //EQUIPMENT
        ArrayList<Expense> equipmentArray = new ArrayList<Expense>();//ArrayList for adding equipment expenses
        for (int i = 0; i < expenseList.size(); i++) {
            if (expenseList.get(i).getCategory() == ExpenseCategory.EQUIPMENT) {
                equipmentArray.add(expenseList.get(i));
            }
        }
        //OTHER
        ArrayList<Expense> otherArray = new ArrayList<Expense>(); //ArrayList for adding other expenses
        for (int i = 0; i < expenseList.size(); i++) {
            if (expenseList.get(i).getCategory() == ExpenseCategory.OTHER) {
                otherArray.add(expenseList.get(i));
            }
        }

        labelString += "TRAVEL_AND_SUBSISTENCE\n";
        for(Expense expense: travelAndSubsistenceArray){  //Appends all the travel and subsistence expenses to the string
            labelString += expense;
        }


        labelString += "\nSUPPLIES\n";
        for(Expense expense: suppliesArray){//Appends all the supplies expenses to the string
            labelString += expense;
        }

        labelString += "\nENTERTAINMENT\n";
        for(Expense expense: entertainmentArray){//Appends all the entertainment expenses to the string
            labelString += expense;
        }

        labelString += "\nEQUIPMENT\n";
        for(Expense expense: equipmentArray){ //Appends all the equipment expenses to the string
            labelString += expense;
        }

        labelString += "\nOTHER\n";
        for(Expense expense: otherArray){ //Appends all the other expenses to the string
            labelString += expense;
        }

        //prints and returns the string it created
        System.out.println(labelString);
        return labelString;

    }
}
