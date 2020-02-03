package by.nikita.keywordSearch.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Record {

    private String id;
    private String name;

    private Value values;

    @Override
    public String toString() {
        return "Record{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", values=" + values +
                '}';
    }
}
