package ru.itis.inf.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.inf.store.dao.models.Item;
import ru.itis.inf.store.service.StoreService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by rumia on 21.03.16.
 */
@RestController
public class ItemController {
    @Autowired
    StoreService service;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public HashMap<String, Integer> getAllItems(){
        return service.getAllItems();
    }

    @RequestMapping(value = "/items/{item-id}", method = RequestMethod.GET)
    public Item getItem(@PathVariable("item-id") String itemId){
        return service.getItem(itemId);
    }

    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public boolean setItem(String name, Integer price){
        return service.setItem(name, price);
    }
}