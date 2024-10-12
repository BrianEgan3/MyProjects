import java.time.LocalDateTime;

public class HealthPractice implements HealthPracticeAppointmentWebservice{
    //dateAndTime is hardcoded for testing because the API doesn't actually exist
    LocalDateTime dateAndTime = LocalDateTime.of(2025,10,1,13,0);

    //HealthPractice properties
    private String name;
    private String address;

    //constructor
    public HealthPractice(String name, String address){
        this.name = name;
        this.address = address;
    }

    //create booking date method from interface
    @Override
    public LocalDateTime getBookingDateTime(HealthPractice practice){
        return (dateAndTime);
    }

    //getter methods
    public String getName() {
        return name;
    }
    public String getAddress(){
        return address;
    }
}
