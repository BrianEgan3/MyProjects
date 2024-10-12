public class IllegalDateException extends Exception{
    //two constructors allow the exception to be thrown either with or without a message
    public IllegalDateException(){
    }
    public IllegalDateException(String message){
        super(message);
    }
}
