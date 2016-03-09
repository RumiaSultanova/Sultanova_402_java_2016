package ru.itis.inf.store.dao;

import ru.itis.inf.store.dao.models.Item;
import ru.itis.inf.store.dao.reader.ItemsReader;

import java.util.HashMap;

/**
 * Created by rumia on 15.02.16.
 */
public interface ItemsDao {
    /**
     *
     * @param reader
     */
    void setReader(ItemsReader reader);

    /**
     *
     * @return
     */
    ItemsReader getReader();

    HashMap<String,Integer> getData();

    /**
     * Удаляет товар из хранилища
     * @param itemName
     */
    void delete(String itemName);

    /**
     * Возвращает описание товара из БД
     * @param itemName
     * @return
     */
    Item select(String itemName);

}
