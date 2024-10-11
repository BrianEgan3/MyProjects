import javax.swing.JOptionPane; //imports JOptionPane
public class Calculator {
    ArrayStack arrayStack = new ArrayStack(); //Stack object
    char[] postfix; //instantiates an array for the postfix input
    float a; // Stores a digit when doing an operation
    float b;//Stores another digit when doing an operation
    public Calculator(){
    }
    public float calculate(char[] inputArray, String string){ //calculates the result of the postfix
        this.postfix = inputArray; //assigns input to postfix
        for(int i =0 ; i<=postfix.length-1; i++){ //for loop to go through
            if (Character.isDigit(postfix[i])){ //checks if it's a digit and puts it in arrayStack
                arrayStack.push((float)(postfix[i]-'0'));
            } else{
                b = (float) arrayStack.pop(); //sets a as a number
                a = (float)arrayStack.pop(); //sets b as a number
                System.out.println("" + a + postfix[i] + b); //prints what operation its doing as an infix
                switch(postfix[i]){ //switch case decides what operation to do with a and b
                    case 94: arrayStack.push((float)Math.pow(a,b));break; //a^b
                    case '*': arrayStack.push(a*b); break;
                    case '/': arrayStack.push (a/b); break;
                    case '+': arrayStack.push(a+b);break;
                    case '-': arrayStack.push(a-b);break;
                }
            }
        }
        float result = (float)arrayStack.top(); //makes the result
        JOptionPane.showMessageDialog(null, "The result of the expression is: \nInfix: " + string+ "\nPostfix: " + new String(postfix) +"\nResult: " + result); //prints results to JOptionPane
        return result;
    }
}
