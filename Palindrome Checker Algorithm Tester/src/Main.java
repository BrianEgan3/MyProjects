
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Stopwatch stopwatch = new Stopwatch(); //Stopwatch object to time the algorithms
    static ReverseMethod ReverseMethod = new ReverseMethod(); //Object for method 1
    static ElementByElement ElementByElement = new ElementByElement(); //object for method 2
    static StackAndQueue StackAndQueue = new StackAndQueue(); //object for method 3
    static RecursionMethod RecursionMethod = new RecursionMethod(); //object for method 4
    static String[] inputArray = new String[1000001]; //array to store numbers as strings
    static String[] binaryArray = new String[1000001]; //array to store binary numbers as strings
    static int noOfPalindromes1 = 0;//no of palindromes from method 1
    static int noOfPalindromes2 = 0;//no of palindromes from method 2
    static int noOfPalindromes3 = 0;//no of palindromes from method 3
    static int noOfPalindromes4 =0;//no of palindromes from method 4
    static int noOfBinaryPalindromes1 = 0;//no of binary palindromes from method 1
    static int noOfBinaryPalindromes2 = 0;//no of binary palindromes from method 2
    static int noOfBinaryPalindromes3 =0;//no of binary palindromes from method 3
    static int noOfBinaryPalindromes4 =0;//no of binary palindromes from method 4
    static int noOfBoth1; //the amount of numbers with both the decimal and binary a palindrome in method 1
    static int noOfBoth2; //the amount of numbers with both the decimal and binary a palindrome in method 2
    static int noOfBoth3; //the amount of numbers with both the decimal and binary a palindrome in method 3
    static int noOfBoth4; //the amount of numbers with both the decimal and binary a palindrome in method 4
    static boolean digitIsPalindrome = false;
    static boolean binaryIsPalindrome = false;


    public static void main(String[] args) {
        for (int i = 0; i <= 1000000; i++) {//adding each number from 1 to 1,000,000 into an array as a string
            inputArray[i] = Integer.toString(i);
            binaryArray[i] = Integer.toBinaryString(i);
        }

        System.out.println("\nMethod One:");
        stopwatch.startClock();
        for (int j = 0; j <= 1000000; j++) {//checking every number from each array
            if (ReverseMethod.checkPalindrome(inputArray[j])) {
                noOfPalindromes1++;
                digitIsPalindrome=true;
            }else{
                digitIsPalindrome = false;
            }

            if (ReverseMethod.checkPalindrome(binaryArray[j])) {
                noOfBinaryPalindromes1++;
                binaryIsPalindrome = true;
            }else
            {
            binaryIsPalindrome = false;
            }
            if(binaryIsPalindrome&&digitIsPalindrome){
                noOfBoth1++;
            }
        }

        stopwatch.endClock();//stop clock and print how long it took
        System.out.println("Number of decimal palindromes: " + noOfPalindromes1); //print results
        System.out.println("Number of binary palindromes: " + noOfBinaryPalindromes1);
        System.out.println("Number of both binary and decimal palindromes: " + noOfBoth1);

        System.out.println("\nMethod Two:");
        stopwatch.startClock();
        for (int j = 0; j <= 1000000; j++) {//checking every number from each array
            if (ElementByElement.checkPalindrome(inputArray[j])) {
                noOfPalindromes2++;
                digitIsPalindrome=true;
            }else{
                digitIsPalindrome = false;
            }
            if (ElementByElement.checkPalindrome(binaryArray[j])) {
                noOfBinaryPalindromes2++;
                binaryIsPalindrome = true;

            }else{
                binaryIsPalindrome = false;
            }
            if(binaryIsPalindrome&&digitIsPalindrome){
                noOfBoth2++;
            }

        }
        stopwatch.endClock();//stop clock and print how long it took
        System.out.println("Number of decimal palindromes: " + noOfPalindromes2);//print results
        System.out.println("Number of binary palindromes: " + noOfBinaryPalindromes2);
        System.out.println("Number of both binary and decimal palindromes: " + noOfBoth2);


        System.out.println("\nMethod Three");
        stopwatch.startClock();
        for (int j = 0; j <= 1000000; j++) {//checking every number from each array
            if (StackAndQueue.checkPalindrome(inputArray[j])) {
                noOfPalindromes3++;
                digitIsPalindrome=true;
            }else{
                digitIsPalindrome = false;
            }
            if (StackAndQueue.checkPalindrome(binaryArray[j])) {
                noOfBinaryPalindromes3++;
                binaryIsPalindrome = true;

            }else{
                binaryIsPalindrome = false;

            }
            if(binaryIsPalindrome&&digitIsPalindrome){
                noOfBoth3++;
            }
        }
        stopwatch.endClock();//stop clock and print how long it took
        System.out.println("Number of decimal palindromes: " + noOfPalindromes3);//print results
        System.out.println("Number of binary palindromes: " + noOfBinaryPalindromes3);
        System.out.println("Number of both binary and decimal palindromes: " + noOfBoth3);


        System.out.println("\nMethod Four");
        stopwatch.startClock();
        for (int j = 0; j <= 1000000; j++) {//checking every number from each array
            if (RecursionMethod.checkPalindrome(inputArray[j])) {
                noOfPalindromes4++;
                digitIsPalindrome=true;
            }else{
                digitIsPalindrome = false;
            }
            if (RecursionMethod.checkPalindrome(binaryArray[j])) {
                noOfBinaryPalindromes4++;
                binaryIsPalindrome = true;
            }else{
                binaryIsPalindrome = false;
            }
            if(binaryIsPalindrome&&digitIsPalindrome){
                noOfBoth4++;
            }

        }
        stopwatch.endClock();//stop clock and print how long it took
        System.out.println("Number of decimal palindromes: " + noOfPalindromes4);//print results
        System.out.println("Number of binary palindromes: " + noOfBinaryPalindromes4);
        System.out.println("Number of both binary and decimal palindromes: " + noOfBoth4);

    }
    }

