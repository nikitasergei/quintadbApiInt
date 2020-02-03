package by.nikita.keywordSearch.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Form {

    private String id;
    private String name;
    private List<Record> records;

    @Override
    public String toString() {
        return "Form{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", records=" + records +
                '}';
    }
}
