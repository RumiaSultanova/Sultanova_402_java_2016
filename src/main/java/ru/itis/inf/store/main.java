package ru.itis.inf.store;

import ru.itis.inf.store.dao.ItemsDao;
import ru.itis.inf.store.dao.reader.CsvReader;
import ru.itis.inf.store.dao.reader.ItemsReader;
import ru.itis.inf.store.service.StoreService;
import ru.itis.inf.store.service.StoreServiceImpl;

import java.io.IOException;

/**
 * Created by rumia on 15.02.16.
 */
public class main {
    public static void main(String[] args) throws IOException {
        StoreService storeService = StoreSupportFactory.getInstance().getStoreService();
        ItemsDao itemsDao = StoreSupportFactory.getInstance().getItemsDao();
        ItemsReader itemsReader = StoreSupportFactory.getInstance().getItemsReader();

        itemsDao.setReader(itemsReader);
        itemsDao.getData();
        storeService.setItemsDao(itemsDao);

        System.out.println(storeService.isExist("kitty"));
    }
}

