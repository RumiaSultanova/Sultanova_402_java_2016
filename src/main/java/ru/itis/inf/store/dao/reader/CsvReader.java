package ru.itis.inf.store.dao.reader;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by rumia on 02.03.16.
 */
@Component
public class CsvReader implements ItemsReader {
    public HashMap<String, Integer> main;
    private static Logger logger = Logger.getLogger(CsvReader.class.getName());

    public CsvReader() {
        getData();
    }

    @Override
    public HashMap<String, Integer> getData() {
        this.main = new HashMap<String, Integer>();
        String[] temp;

        try {
            BufferedReader input = new BufferedReader(new FileReader("/home/rumia/Code/Java/4th/Store/src/main/resources/storeList.csv"));

            CsvParserSettings settings = new CsvParserSettings();
            settings.getFormat().setLineSeparator("\n");
            CsvParser parser = new CsvParser(settings);
            List<String[]> amount = parser.parseAll(input);

            Iterator<String[]> iterator = amount.iterator();

            while (iterator.hasNext()) {
                temp = iterator.next();
                main.put(temp[0], Integer.valueOf(temp[1]));
            }
        } catch (IOException e) {
            System.out.println("Not today~ " + e);
        }

        logger.info("Data loaded from csv");

        return main;
    }
}
