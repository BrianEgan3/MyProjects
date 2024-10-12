public class StackAndQueue implements Palindrome {
    int operationCount =0;//used when measuring how many operations are done
    public StackAndQueue(){//constructor
    }
    @Override//overrides method from the interface
    public Boolean checkPalindrome(String string){
        ArrayQueue queue = new ArrayQueue();
        ArrayStack stack = new ArrayStack();

        for(int i = string.length()-1; i>=0; i--){ //operationCount= operationCount+2;
            queue.enqueue(string.charAt(i)); //operationCount++;
            stack.push(string.charAt(i));  // operationCount++;
        }
        for(int j = string.length()-1; j>=0; j--){// operationCount=operationCount+2;
            if(queue.dequeue() != stack.pop()){ //operationCount++;
               // queue.dequeue();
               // stack.pop();
                //operationCount++;
                return false;//ends the method early if it shows its not a palindrome
            }
        }
        //operationCount++;
        return true;//returns true if its not proven to be not a palindrome
    }
}
