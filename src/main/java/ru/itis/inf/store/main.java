package ru.itis.inf.store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.inf.store.service.StoreService;

import java.io.IOException;

/**
 * Created by rumia on 15.02.16.
 */
public class main {
    public static void main(String[] args) throws IOException {
/*
        StoreService storeService = StoreSupportFactory.getInstance().getStoreService();
        ItemsDao itemsDao = StoreSupportFactory.getInstance().getItemsDao();
        ItemsReader itemsReader = StoreSupportFactory.getInstance().getItemsReader();

        itemsDao.setReader(itemsReader);
        storeService.setItemsDao(itemsDao);

        System.out.println(storeService.isExist("kitty"));
*/

//        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext("/home/rumia/Code/Java/4th/Store/src/main/java/ru/itis/inf/store/StoreConfig.java");

        StoreService service = context.getBean("service", StoreService.class);

        System.out.println(service.isExist("kitty"));

    }
}

