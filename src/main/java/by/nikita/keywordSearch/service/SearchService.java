package by.nikita.keywordSearch.service;

import by.nikita.keywordSearch.domain.Record;
import by.nikita.keywordSearch.exception.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class SearchService {
    private QuintaDBService quintaDBService;

    public SearchService() {
        this.quintaDBService = new QuintaDBService();
    }

    /*
     * @param substring - what we a looking for
     * This method returns from the CRM database using the method 'GET' the name of the record
     * in which the words from the @param substring are most often found.
     * */
    public List<Record> search(String substring) throws RecordNotFoundException {
        Map<Integer, Record> resultMap = new HashMap<>();
        Map<String, Integer> wordToCount;
        List<Record> records = quintaDBService.getAllRecords();
        if (records != null && !records.isEmpty()) {
            for (Record record : records) {
                int temp = 0;
                wordToCount = getWordsForCount(substring);
                String[] textForSearch = record.getValues().getDdOSoUuSnpWOVcKfJcISop().split(" ");
                for (String word : textForSearch) {
                    wordToCount.computeIfPresent(word, (key, value) -> value + 1);
                }
                for (Integer i : wordToCount.values()) {
                    temp = temp + i;
                }
                resultMap.put(temp, record);
            }
            return getRecordList(resultMap);
        } else throw new RecordNotFoundException();
    }

    /*
     * This method put in HashMap values in the map
     * keys - words from @param substring;
     * value - int 0.
     */
    private Map<String, Integer> getWordsForCount(String substring) {
        Map<String, Integer> wordToCount = new HashMap<>();
        String[] subStr = substring.split(" ");
        for (String word : subStr) {
            wordToCount.put(word, 0);
        }
        return wordToCount;
    }

    private List<Record> getRecordList(Map<Integer, Record> map) {
        List<Record> recordsList = new ArrayList();
        List<Integer> list = map.keySet().stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());
        for (Integer i : list) {
            System.out.println(i);
            recordsList.add(map.get(i));
        }
        return recordsList;
    }
}
