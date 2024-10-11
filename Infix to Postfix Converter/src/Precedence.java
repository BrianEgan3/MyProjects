public class Precedence {
    int precedenceA = 20; //if this stays at 20 then the character is invalid
    int precedenceB; //the precedence of the operator in the stack
    char[] operators ={40,94,42,47,43,45}; //list of characters in order of precedence
    // ( ^ * / + - )
    public Precedence() {
    }


    public Boolean checkPrecedence(char c,char d){ //method to check if input c has higher precedence than input d
        for(int i = 0; i<6; i++){//for loop to go through them and assign a precedence
            if(c==operators[i]){
                precedenceA = i; //assigns the index value of the operator to a
            }
            if(d == operators[i]){
                precedenceB = i; //assigns index value of operator to b
            }
            else if (i== 5 && precedenceA==20) { //error message if its not an operator
                System.out.println("ERROR! Only the following characters are valid: +,-,*,/,^,(,) and numbers 0-9");
                System.exit(0);
            }
            //lower index number means higher precedence
        }
        return precedenceB > precedenceA; //returns true if input c has a higher precedence
    }
}
