package ru.itis.inf.store.dao;

import ru.itis.inf.store.dao.models.Item;

import java.util.HashMap;
import java.util.List;

/**
 * Created by rumia on 15.02.16.
 */
public interface ItemsDao {

    HashMap<String, Integer> getAllItems();

    boolean setItem(String name, Integer price);

    /**
     * Удаляет товар из хранилища
     *
     * @param itemName
     */
    void delete(String itemName);

    /**
     * Возвращает описание товара из БД
     *
     * @param itemName
     * @return
     */
    Item select(String itemName);

}
