package fontys.sem3.service.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
public class Tiger {

    private int animalNumber;
    private String name; // full name, e.g., "Joe Smith"
    private String gender;
    private Shelter shelter;// country where the students comes from

    public Tiger(int animalNumber, String name, String gender, Shelter shelter) {
        this.animalNumber = animalNumber;
        this.name = name;
        this.gender = gender;
        this.shelter=shelter;
    }
    public int getAnimalNumber() {
        return animalNumber;
    }

    public void setAnimalNumber(int animalNumber) {
        this.animalNumber = animalNumber;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Shelter getShelter(){return shelter;}
    public void setShelter(Shelter shelter){this.shelter=shelter;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tiger tiger = (Tiger) o;
        return animalNumber == tiger.animalNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalNumber);
    }

    @Override
    public String toString() {
        return "animal{" +
                "animalNumberNumber=" + animalNumber +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
