package ru.itis.inf.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.itis.inf.store.dao.ItemsDao;
import ru.itis.inf.store.dao.models.Item;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by rumia on 15.02.16.
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    @Qualifier("itemsDaoHashMapImpl")
    private ItemsDao itemsDao;

    private static Logger logger = Logger.getLogger(StoreServiceImpl.class.getName());

    @Override
    public Item getItem(String name) {
        return itemsDao.select(name);
    }

    @Override
    public HashMap<String, Integer> getAllItems() {
        return itemsDao.getAllItems();
    }

    @Override
    public boolean setItem(String name, Integer price) {
        return itemsDao.setItem(name, price);
    }

    public void buy(String itemName) {
        itemsDao.delete(itemName);
        logger.info(itemName + " has just been bought");
    }

    public boolean isExist(String itemName) {
        logger.info("Is " + itemName + " exist?");
        if(itemsDao.select(itemName) != null)
            logger.info("Exists with price: " + itemsDao.select(itemName).getPrice());
        else
            logger.info("Nope.. Not today~");
        return itemsDao.select(itemName) != null;
    }
}
