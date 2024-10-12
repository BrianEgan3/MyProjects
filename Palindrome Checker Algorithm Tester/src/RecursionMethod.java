public class RecursionMethod implements Palindrome {
    String reverse;
    int operationCount = 0;
    public RecursionMethod(){
    }
    @Override//overrides method from the interface
    public Boolean checkPalindrome(String string){
        reverse = reverse(string); //operationCount++;
        //operationCount++;
        return string.equals(reverse);
    }
    public String reverse(String string){
       // operationCount++;
    if(string.length() <= 1){
       // operationCount++;
        return string;
    }else{
        //operationCount++;
        //operationCount++;
        //operationCount++;
        //operationCount++;
        //operationCount++;
        //operationCount++;

        return string.charAt(string.length()- 1) + reverse(string.substring(1, string.length() - 1)) + string.charAt(0);
        //function calls itself in the return method. It swaps the first and last letter until the string is reversed
    }
    }
}
