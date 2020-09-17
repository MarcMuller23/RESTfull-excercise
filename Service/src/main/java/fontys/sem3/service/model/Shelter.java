package fontys.sem3.service.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
@XmlRootElement

public class Shelter {

    private String shelterCode;

    public Shelter(String shelterCode) {
        this.shelterCode = shelterCode;
    }



    public String getCode() {
        return shelterCode;
    }

    public void setCode(String shelterCode) {
        this.shelterCode = shelterCode;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Tiger tiger = (Tiger) o;
//        return Objects.equals(code, tiger.code);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(shelterCode);
    }

    @Override
    public String toString() {
        return "Shelter{" +
                "shelterCode='" + shelterCode + '\''  +
                '}';
    }
}
