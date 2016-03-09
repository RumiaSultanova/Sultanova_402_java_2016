package ru.itis.inf.store.service;

import ru.itis.inf.store.dao.ItemsDao;

/**
 * Created by rumia on 15.02.16.
 */
public interface StoreService {
    /**
     *
     * @param dao
     */
    void setItemsDao(ItemsDao dao);


    ItemsDao getItemsDao();

    /**
     * Покупка товара по имени
     * @param itemName имя товара
     */
    void buy(String itemName);

    /**
     * Проверяет, есть ли товар на складе
     * @param itemName название товара
     * @return true - если товар найден,
     * false - в противном случае
     */
    boolean isExist(String itemName);
}
