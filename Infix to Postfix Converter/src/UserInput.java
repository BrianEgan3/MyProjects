import javax.swing.JOptionPane; //importing JOptionPane
public class UserInput {
    String input; //user input
    char[] operators ={40,94,42,47,43,45,41}; //array of operators to make sure input characters are one of them
    boolean valid = false; //check if input is valid or not
    public UserInput(){

    }
    public String getInput(){//method to ask user for input
        input = JOptionPane.showInputDialog("Enter an infix expression");
        return input;
    }
    public char[] getArray(){ //method to turn the input string into an array
        char[] inputArray = new char[input.length()]; //creates the array of the correct size
        for(int i =0; i <=  input.length()-1; i++){ //for loop to go through input characters and put them in array

            inputArray[i] = input.charAt(i);
            for(int j =0; j<=6; j++){ //for loop to check are the characters valid inputs
                if (input.charAt(i) == operators[j]|| Character.isDigit(input.charAt(i))){//checks if they're a digit or an operator
                    valid = true;
                }
            }
        }
        if(!valid){//if they're invalid it displays an error message and stops the program
            JOptionPane.showMessageDialog(null, "ERROR! Only the following characters are valid: +,-,*,/,^,(,) and numbers 0-9");
            System.exit(0);
        }
        return inputArray;
    }
    public int getArrayLength(char[] inputArray) { //method to get the length of the array without brackets ie length of postfix
        int arrayLength =0;
        for(int i =0; i< inputArray.length; i++){ //loops through and adds 1 when character isn't a bracket
            if(inputArray[i]!= 41 && inputArray[i]!= 40){
                arrayLength++;
            }
        }
        if(arrayLength<3 || arrayLength>20){ //checks if array is within the size constrant
            JOptionPane.showMessageDialog(null,"ERROR! Please enter between 3 and 20 valid characters" );
            System.exit(0);//ends the program if input is too small or too big
        }
        return arrayLength;
    }



}
