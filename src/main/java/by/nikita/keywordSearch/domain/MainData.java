package by.nikita.keywordSearch.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MainData {

    List<Database> databases = new ArrayList<>();

    @Override
    public String toString() {
        return "MainData{" +
                "databases=" + databases +
                '}';
    }
}
