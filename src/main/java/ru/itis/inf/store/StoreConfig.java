package ru.itis.inf.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.itis.inf.store.dao.ItemsDao;
import ru.itis.inf.store.dao.ItemsDaoHashMapImpl;
import ru.itis.inf.store.dao.reader.ItemsReader;
import ru.itis.inf.store.dao.reader.CsvReader;
import ru.itis.inf.store.service.StoreService;
import ru.itis.inf.store.service.StoreServiceImpl;

/**
 * Created by rumia on 09.03.16.
 */
@Configuration
@ComponentScan("ru.itis.inf.store")
public class StoreConfig {

    @Bean
    public ItemsReader reader() {
        return new CsvReader();
    }

    @Bean
    public ItemsDao dao() {
        return new ItemsDaoHashMapImpl();
    }

    @Bean
    public StoreService service() {
        return new StoreServiceImpl();
    }
}
