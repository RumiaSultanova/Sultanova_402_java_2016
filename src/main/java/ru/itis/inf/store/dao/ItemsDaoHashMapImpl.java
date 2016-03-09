package ru.itis.inf.store.dao;

import ru.itis.inf.store.dao.models.Item;
import ru.itis.inf.store.dao.reader.ItemsReader;

import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Created by rumia on 03.03.16.
 */
public class ItemsDaoHashMapImpl implements ItemsDao {
    ItemsReader reader;
    HashMap<String, Integer> main = new HashMap<String, Integer>();
    private static Logger logger = Logger.getLogger(ItemsDaoHashMapImpl.class.getName());

    @Override
    public void setReader(ItemsReader reader) {
        this.reader = reader;
    }

    @Override
    public ItemsReader getReader() {
        return reader;
    }

    @Override
    public HashMap<String, Integer> getData() {
        this.main = reader.getData();
        return main;
    }

    @Override
    public void delete(String itemName) {
        System.out.println("name: " + itemName + " price: " + main.get(itemName));
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
