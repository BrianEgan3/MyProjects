public class ReverseMethod implements Palindrome{
    int operationCount =0; //used when measuring how many operations are done
    @Override//overrides method from the interface
    public Boolean checkPalindrome(String string){
        String backwards = "";
       operationCount++;
        for(int i = string.length() -1 ; i>=0; i--){ operationCount = operationCount+2;
            backwards += string.charAt(i);//adds a character from input string onto the end of the reversed string
            operationCount++;
        }
        operationCount++;

        return string.equals(backwards);//returns if its a palindrome
    }
    public int oppCount(){
        return operationCount;
    }
}
