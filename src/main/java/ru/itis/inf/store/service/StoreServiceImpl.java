package ru.itis.inf.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.itis.inf.store.dao.ItemsDao;

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
    public void setItemsDao(ItemsDao dao) {
        this.itemsDao = dao;
    }

    @Override
    public ItemsDao getItemsDao() {
        return itemsDao;
    }

    public void buy(String itemName) {
        itemsDao.delete(itemName);
        logger.info(itemName + " has just been bought");
    }

    public boolean isExist(String itemName) {
        logger.info("Is " + itemName + " exist?");
        return itemsDao.select(itemName) != null;
    }
}
