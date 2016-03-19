package ru.itis.inf.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
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
@EnableWebMvc
@ComponentScan("ru.itis.inf.store")
public class WebAppContext extends WebMvcConfigurerAdapter {

    

}
