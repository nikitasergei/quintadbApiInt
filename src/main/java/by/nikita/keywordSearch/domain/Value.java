package by.nikita.keywordSearch.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

    //content
    String ddOSoUuSnpWOVcKfJcISop;

    //name
    String ddQe3dPSnhW7VcMZiSW6nZ;

    @Override
    public String toString() {
        return "Value{" +
                "Content='" + ddOSoUuSnpWOVcKfJcISop + '\'' +
                ", Name='" + ddQe3dPSnhW7VcMZiSW6nZ + '\'' +
                '}';
    }
}
