import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    //first test to check if all the getter methods are working
    @Test
    void createBookingTest() throws IllegalDateException {
        HealthPractice healthPractice = new HealthPractice("Riverview Health Centre", "5 Lyster Square, Ballinasloe, Galway");
        Booking booking = new Booking("WH1659741", healthPractice, LocalDateTime.of(2024, 9,25,13,0));
        assertTrue(booking.getPatientNumber().equals("WH1659741"));
        assertTrue(healthPractice == booking.getHealthPractice());

        assertTrue(LocalDateTime.of(2024,9,25,13,0).equals(booking.getDateAndTime()));
    }

    //test to see if booking patient number can be changed
    @Test
    void editBookingTest() throws IllegalDateException {
        HealthPractice healthPractice = new HealthPractice("Riverview Health Centre", "5 Lyster Square, Ballinasloe, Galway");
        Booking booking = new Booking("WH1659741", healthPractice, LocalDateTime.of(2024, 9,25,13,0));
        booking.editPatientNumber("WL8765468");

        assertTrue(booking.getPatientNumber().equals("WL8765468"));
    }

    //test to see if booking can be made without a date and date can be set from HealthPractice
    @Test
    void noDateBookingTest(){
        HealthPractice healthPractice = new HealthPractice("Riverview Health Centre", "5 Lyster Square, Ballinasloe, Galway");
        Booking booking = new Booking("WH1659741", healthPractice);

        //same date as the one defined in HealthPractice class
        assertTrue(LocalDateTime.of(2025,10,1,13,0).equals(booking.getDateAndTime()));
    }

    //test to see if the exception is triggered
    @Test
    void illegalDateTest(){
        try{
            HealthPractice healthPractice = new HealthPractice("Riverview Health Centre", "5 Lyster Square, Ballinasloe, Galway");
            Booking booking = new Booking("A1", healthPractice, LocalDateTime.of(2023,9,19,15,0));
            fail(); //if exception is triggered this line will never run
        }catch (IllegalDateException e) {
           System.out.println("Illegal date exception thrown. Test Success");
           assertTrue(1==1); //runs only if exception is triggerd and caught
        }

    }

    //test to see if the 2 booking numbers generated are unique
    @Test
    void bookingIdTest() throws IllegalDateException {
        HealthPractice healthPractice = new HealthPractice("Riverview Health Centre", "a");
        Booking booking1 = new Booking("WH1659741", healthPractice, LocalDateTime.of(2024, 9,25,13,0));
        Booking booking2 = new Booking("LK6243073", healthPractice, LocalDateTime.of(2024, 9,26,15,0));

        //printing them to double-check that they're unique
        System.out.println("Booking ID one: " + booking1.bookingId);
        System.out.println("Booking ID two: " + booking2.bookingId);

        assertNotEquals(booking1.getBookingId() , booking2.getBookingId());
    }


    @Test
    void bookingToStringTest() throws IllegalDateException{
        HealthPractice healthPractice = new HealthPractice("Riverview Health Centre", "5 Lyster Square, Ballinasloe, Galway H53 NWX4");
        Booking booking1 = new Booking("WH1659741", healthPractice, LocalDateTime.of(2025, 9,22,8,0));

        //what the output string should be
        String testString = "Booking ID Number: 5\n" + //booking ID number has to be changed to 1 if you're running this test on its own
                            "Patient Number: WH1659741\n" +
                            "Health Practice: Riverview Health Centre\n" +
                            "Address: 5 Lyster Square, Ballinasloe, Galway H53 NWX4\n" +
                            "Date & Time: On Monday, 22 September 2025 at 08:00";

        System.out.println(booking1);
        System.out.println(testString);

        assertEquals(testString, booking1.toString());
    }
}