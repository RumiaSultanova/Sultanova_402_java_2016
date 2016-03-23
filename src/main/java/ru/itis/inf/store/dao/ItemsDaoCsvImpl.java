package ru.itis.inf.store.dao;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.stereotype.Component;
import ru.itis.inf.store.dao.models.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by rumia on 03.03.16.
 */
@Component
public class ItemsDaoCsvImpl implements ItemsDao {
    HashMap<String, Integer> main = new HashMap<String, Integer>();
    private static Logger logger = Logger.getLogger(ItemsDaoCsvImpl.class.getName());

    public ItemsDaoCsvImpl() {
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
                this.main.put(temp[0], Integer.valueOf(temp[1]));
            }
        } catch (IOException e) {
            System.out.println("Not today~ " + e);
        }

        logger.info("Data loaded from csv");
    }

    @Override
    public HashMap<String, Integer> getAllItems() {
        return main;
    }

    @Override
    public boolean setItem(String name, Integer price) {
        main.put(name, price);
        return true;
    }

    @Override
    public void delete(String itemName) {
        logger.info(itemName + " for " + main.get(itemName) + " was sold");
        main.remove(itemName);
    }

    @Override
    public Item select(String itemName) {
        if (main.get(itemName) == null)
            return null;
        else
            return new Item(itemName, main.get(itemName));
    }
}
