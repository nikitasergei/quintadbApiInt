package by.nikita.keywordSearch;

import by.nikita.keywordSearch.domain.Record;
import by.nikita.keywordSearch.exception.RecordNotFoundException;
import by.nikita.keywordSearch.service.QuintaDBService;
import by.nikita.keywordSearch.service.SearchService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        QuintaDBService quintaDBService = new QuintaDBService();
        SearchService searchService = new SearchService();

        try {
            List<Record> list = searchService.search("Как Java");
            for (Record rec : list) {
                System.out.println(rec.getId());
            }
        } catch (RecordNotFoundException e) {
            e.printStackTrace();
        }
    }
}

