package by.nikita.keywordSearch.service;

import by.nikita.keywordSearch.domain.Database;
import by.nikita.keywordSearch.domain.Form;
import by.nikita.keywordSearch.domain.MainData;
import by.nikita.keywordSearch.domain.Record;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuintaDBService {

    private RestTemplate restTemplate;
    private String url;

    //database URL
    private static String dbUrl = "https://quintadb.ru";

    //database ID
    private static String APP_ID = "cmWPxdNmngqykpxahdV1ar";

    //database's form ID
    private static String ENTITY_ID = "arveXNfCjdEioUtCkkaCor";

    //Rest API Key for this database
    private static String rest_api_key = "cgW6uMW5PcHioHW5VdTrOE";

    private static String param = "?rest_api_key=";

    public QuintaDBService() {
        this.restTemplate = new RestTemplate();
    }


    /*
    get all databases as List
     */
    public List<Database> getAllDB() {
        url = dbUrl + "/apps.json" + param + rest_api_key;
        MainData response = restTemplate.getForObject(url, MainData.class);
        return response.getDatabases();
    }

    /*
    get all database's forms as List
     */
    public List<Form> getAllForms() {
        url = dbUrl + "/apps/" + APP_ID + "/entities.json" + param + rest_api_key;
        Database response = restTemplate.getForObject(url, Database.class);
        return response.getForms();
    }

    /*
    get all database form's records  as List
     */
    public List<Record> getAllRecords() {
        url = dbUrl + "/apps/" + APP_ID + "/dtypes/entity/" + ENTITY_ID + ".json" + param + rest_api_key;
        Form response = restTemplate.getForObject(url, Form.class);
        return response.getRecords();
    }

    public List<String> getAllRecordsIDs() {
        List<String> idList = getAllRecords().stream().map(Record::getId).collect(Collectors.toList());
        for (String id : idList) {
            System.out.println(id);
        }
        return idList;
    }

    /*
     *This method return Record By endpoint (id)
     */
    public Optional<Record> getRecordBYId(String id) {
        List<Record> recordsList = getAllRecords();
        return recordsList.stream().filter(record -> record.getId().equals(id)).findFirst();

    }
}