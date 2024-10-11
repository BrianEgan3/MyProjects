public class Main {
    static UserInput input = new UserInput(); //UserInput object to run UserInput method
    static Converter convert = new Converter(); //Converter object to run Converter method
    static Calculator calculator = new Calculator(); //Calculator object to run Calculator method

    public static void main(String[] args) {
        String in = input.getInput(); //gets the input as a string
        char[] inputArray = input.getArray(); //gets the input as an array
        char[] postfix  = convert.convert(inputArray); //converts input array to postfix
        calculator.calculate(postfix,in); //calculates the result of the postfix and prints it
    }
}