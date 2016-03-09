package ru.itis.inf.store;

import ru.itis.inf.store.dao.ItemsDao;
import ru.itis.inf.store.dao.reader.ItemsReader;
import ru.itis.inf.store.service.StoreService;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by rumia on 02.03.16.
 */
public class StoreSupportFactory {
    private static StoreSupportFactory instance;

    private Properties properties;

    private ItemsReader itemsReader;
    private ItemsDao itemsDao;
    private StoreService storeService;

    public StoreSupportFactory() {
        this.properties = new Properties();

        try {
            properties.load(new FileInputStream("/home/rumia/Code/Java/4th/Store/src/main/resources/store.properties"));

            String storeServiceClass = properties.getProperty("service.class");
            String itemsDaoClass = properties.getProperty("dao.class");
            String itemReaderClass = properties.getProperty("reader.class");

            this.itemsReader = (ItemsReader)Class.forName(itemReaderClass).newInstance();
            this.itemsDao = (ItemsDao)Class.forName(itemsDaoClass).newInstance();
            this.storeService = (StoreService)Class.forName(storeServiceClass).newInstance();
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }

    }

    static {
        instance = new StoreSupportFactory();
    }

    public static StoreSupportFactory getInstance(){
        return instance;
    }

    public ItemsDao getItemsDao() {
        return itemsDao;
    }

    public StoreService getStoreService() {
        return storeService;
    }

    public ItemsReader getItemsReader() {
        return itemsReader;
    }
}
