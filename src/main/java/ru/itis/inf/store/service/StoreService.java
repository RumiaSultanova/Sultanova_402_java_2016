package ru.itis.inf.store.service;

import ru.itis.inf.store.dao.ItemsDao;
import ru.itis.inf.store.dao.models.Item;

import java.util.HashMap;
import java.util.List;

/**
 * Created by rumia on 15.02.16.
 */
public interface StoreService {
    Item getItem(String name);

    HashMap<String, Integer> getAllItems();

    boolean setItem(String name, Integer price);

    /**
     * Покупка товара по имени
     *
     * @param itemName имя товара
     */
    void buy(String itemName);

    /**
     * Проверяет, есть ли товар на складе
     *
     * @param itemName название товара
     * @return true - если товар найден,
     * false - в противном случае
     */
    boolean isExist(String itemName);
}
