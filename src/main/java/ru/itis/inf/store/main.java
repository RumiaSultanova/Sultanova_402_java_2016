package ru.itis.inf.store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");

        StoreService service = context.getBean("service", StoreService.class);

        System.out.println(service.isExist("kitty"));
    }
}

