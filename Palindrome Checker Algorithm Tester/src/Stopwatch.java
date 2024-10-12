public class Stopwatch {
    long startTime; //time clock starts
    long endTime; //time clock ends
    public Stopwatch(){ //constructor
    }
    public void startClock(){
        startTime = System.currentTimeMillis(); //gets time the clock starts
    }

    public long endClock(){ //gets time the clock stops and subtracts time clock started from it
        endTime = System.currentTimeMillis();
        System.out.println("time taken: " + (endTime - startTime) + "ms");
        return (endTime - startTime); //returns time the clock was running for
    }
}
