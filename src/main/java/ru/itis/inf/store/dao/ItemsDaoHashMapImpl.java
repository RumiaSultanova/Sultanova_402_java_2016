package ru.itis.inf.store.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.itis.inf.store.dao.models.Item;
import ru.itis.inf.store.dao.reader.ItemsReader;

import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Created by rumia on 03.03.16.
 */
@Component
public class ItemsDaoHashMapImpl implements ItemsDao {

    @Autowired
    @Qualifier("csvReader")
    ItemsReader reader;

    HashMap<String, Integer> main = new HashMap<String, Integer>();
    private static Logger logger = Logger.getLogger(ItemsDaoHashMapImpl.class.getName());

    public ItemsDaoHashMapImpl() {
        this.main.put("kitty", 123);
        this.main.put("zombie", 456);
        this.main.put("love", 789);
    }

    public void init() {
        this.main = reader.getData();
    }

    @Override
    public void setReader(ItemsReader reader) {
        this.reader = reader;
    }

    @Override
    public ItemsReader getReader() {
        return reader;
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
