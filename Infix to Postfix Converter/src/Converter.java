public class Converter {
    Precedence precedence = new Precedence(); //object to use precedence methods
    UserInput userInput = new UserInput(); //object to use input methods
    char[] a; //character input array
    ArrayStack stackArray = new ArrayStack();//object to use arrayStack
    public Converter() {
    }


    public char[] convert(char[] inputArray) {//converts the inputted array to postfix
        a = inputArray;
        char[] postfix = new char[userInput.getArrayLength(a)]; //makes postfix array of the correct size
        int f = 0;
        for (int j = 0; j <= a.length - 1; j++) {//for loop to cycle through each character of the array
            if (Character.isDigit(a[j])) { //checks if the current character is a digit
                postfix[f] = a[j];
                f = f + 1;
            } else if (stackArray.isEmpty()) { //pushes current character to stack if its empty
                stackArray.push(a[j]);
            } else if (precedence.checkPrecedence(a[j], (char) stackArray.top())) {//compares the precedence of the operator and the one at the top of the stack true if higher
                stackArray.push(a[j]);//pushes higher precedence character
            }else{//pops all from the stack if precedence is lower until it gets to something of higher precedence
                for(int k = 0;k<= stackArray.size(); k++){
                    if(!stackArray.isEmpty()) {
                        if (!precedence.checkPrecedence(a[j], (char) stackArray.top()) && (char)stackArray.top() != 40 &&(char)stackArray.top()!= 4) {
                            postfix[f] = (char) stackArray.pop();
                            f++;

                        }
                    }
                }
                stackArray.push(a[j]);
            }

            if (a[j] == 41) { //if there's a closed bracket it pops until it finds an open bracket
                    int w = 0;
                    while (w < 2 && !stackArray.isEmpty()) {
                        if ((char) stackArray.top() == 40) {
                            w = 3;
                        }
                        stackArray.pop();
                    }
            }
            }
        for(f = f; f<a.length; f++){ //pops everything out of the array stack and appends them to output at the end
            if(!stackArray.isEmpty()) {
                if((char)stackArray.top() != 40 && (char)stackArray.top()!=41) {
                    postfix[f] = (char) stackArray.pop();
                }
            }
        }
        return postfix; //returns the postfix as an array
    }
}

