package by.nikita.keywordSearch.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Database {

    private String id;
    private String name;
    private List<Form> forms;

    @Override
    public String toString() {
        return "Database{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", forms=" + forms +
                '}';
    }
}


