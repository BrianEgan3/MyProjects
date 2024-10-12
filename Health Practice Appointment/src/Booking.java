import java.time.LocalDateTime;
public class Booking {
    //properties of a booking object
    String patientNumber;
    HealthPractice healthPractice;
    LocalDateTime dateAndTime;
    long bookingId;
    private static long bookingCounter =0;

    //constructors
    public Booking(String patientNumber, HealthPractice healthPractice,LocalDateTime dateAndTime) throws IllegalDateException{
        bookingCounter++;
        this.patientNumber = patientNumber;
        this.healthPractice = healthPractice;
        this.dateAndTime = dateAndTime;
        bookingId = bookingCounter;

        //throws an exception if a booking object is made with a past date
        if(dateAndTime.isBefore(LocalDateTime.now())){
            throw new IllegalDateException("Data entered is in the past");
        }
    }
    public Booking(String patientNumber, HealthPractice healthPractice){ //creates an object without a date
        this.patientNumber = patientNumber;
        this.healthPractice = healthPractice;
        dateAndTime = healthPractice.getBookingDateTime(healthPractice);
    }

    //getter methods
    public String getPatientNumber(){
        return patientNumber;
    }
    public HealthPractice getHealthPractice(){
        return healthPractice;
    }
    public LocalDateTime getDateAndTime(){
        return dateAndTime;
    }
    public long getBookingId(){
        return bookingId;
    }
    //method to edit patient number
    public void editPatientNumber(String newPatientNumber){
        patientNumber = newPatientNumber;
    }

@Override
    public String toString(){

    //Putting parts of the output string into a more reader friendly format
    String dayOfWeek = "" +  dateAndTime.getDayOfWeek();
    String dayOfWeekFirstLetter = dayOfWeek.substring(0,1);
    String dayOfWeekSmallLetters = dayOfWeek.substring(1).toLowerCase();
    String monthOfYear = "" +dateAndTime.getMonth();
    String monthOfYearFirstLetter = monthOfYear.substring(0,1);
    String monthOfYearSmallLetters = monthOfYear.substring(1).toLowerCase();
    String timeInPrintableFormat = dateAndTime.toString().substring(11);

    //Appending all the booking information to a single string
    String bookingSummary = "Booking ID Number: " + bookingId +
                            "\nPatient Number: " + patientNumber+
                            "\nHealth Practice: " + healthPractice.getName()+
                            "\nAddress: " + healthPractice.getAddress()+
                            "\nDate & Time: On "+ dayOfWeekFirstLetter + dayOfWeekSmallLetters + ", "
                                                + dateAndTime.getDayOfMonth() +" "
                                                + monthOfYearFirstLetter + monthOfYearSmallLetters +" "
                                                + dateAndTime.getYear() +" at "
                                                + timeInPrintableFormat;

        return bookingSummary;
    }
}
