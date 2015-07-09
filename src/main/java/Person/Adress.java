package Person;

/**
 * Created by jeansmits on 9/07/15.
 */
public class Adress {
    private String city;
    private String streetName;

    public Adress(String city, String streetName) {
        this.city = city;
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Adress() {
    }
}
