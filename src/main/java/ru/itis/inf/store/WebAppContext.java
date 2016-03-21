package ru.itis.inf.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
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
@EnableAspectJAutoProxy
//@EnableWebMvc
@ComponentScan("ru.itis.inf.store")
public class WebAppContext
//        extends WebMvcConfigurerAdapter
{

/*
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
*/

}
