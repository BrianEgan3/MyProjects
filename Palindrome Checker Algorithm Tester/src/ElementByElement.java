public class ElementByElement implements Palindrome{
    int operationCount = 0; //used when measuring how many operations are done
    public ElementByElement(){
    }
    @Override//overrides method from the interface
    public Boolean checkPalindrome(String string){
        for(int i = string.length()-1; i>=0; i--){//operationCount = operationCount+2;
           // operationCount++;
            if (string.charAt(i) != string.charAt(string.length() - (i+1))) {
              //operationCount++;
                return false;//ends the method early if it shows its not a palindrome
                //operationCount++;
                //operationCount++;
            }
        }
        return true;//returns true if its not proven to be not a palindrome
    }
}
