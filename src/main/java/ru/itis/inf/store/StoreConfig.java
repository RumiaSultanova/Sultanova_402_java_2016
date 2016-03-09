package ru.itis.inf.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itis.inf.store.dao.ItemsDao;
import ru.itis.inf.store.dao.ItemsDaoHashMapImpl;
import ru.itis.inf.store.dao.reader.CsvReader;
import ru.itis.inf.store.dao.reader.ItemsReader;
import ru.itis.inf.store.service.StoreService;
import ru.itis.inf.store.service.StoreServiceImpl;

/**
 * Created by rumia on 09.03.16.
 */
@Configuration
public class StoreConfig {
    @Bean
    public ItemsReader reader() {
        return new CsvReader();
    }

    @Bean
    public ItemsDao dao() {
        ItemsDao dao = new ItemsDaoHashMapImpl();
        dao.setReader(reader());
        return dao;
    }

    @Bean
    public StoreService service() {
        StoreService service = new StoreServiceImpl();
        service.setItemsDao(dao());
        return service;
    }

}
