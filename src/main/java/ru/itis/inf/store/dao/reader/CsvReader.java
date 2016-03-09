package ru.itis.inf.store.dao.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Created by rumia on 02.03.16.
 */
public class CsvReader implements ItemsReader {
    String temp;
    String[] tempr;
    HashMap<String, Integer> main;
    private static Logger logger = Logger.getLogger(CsvReader.class.getName());

    public CsvReader() {
    }

    @Override
    public HashMap<String, Integer> getData() {
        this.main = new HashMap<String, Integer>();

        try {
            BufferedReader input = new BufferedReader(new FileReader("/home/rumia/Code/Java/4th/Store/src/main/resources/storeList.csv"));
            while ((temp = input.readLine()) !=null) {
                tempr = temp.split(",");
                main.put(tempr[0], Integer.valueOf(tempr[1]));
            }
        } catch (IOException e) {
            System.out.println("Not today~ " + e);
        }

        logger.info("Data loaded");

        return main;
    }
}
