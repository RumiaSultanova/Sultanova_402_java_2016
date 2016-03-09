package ru.itis.inf.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by rumia on 09.03.16.
 */
public class Try {
    public static void main(String[] args) {
        HashMap<String,Integer> main = new HashMap<String, Integer>();
        try {
            BufferedReader input = new BufferedReader(new FileReader("/home/rumia/Code/Java/4th/Store/src/main/resources/storeList.tsv"));

            System.out.println(input.readLine());
            System.out.println(input.readLine());
            System.out.println(input.readLine());
            System.out.println(input.readLine());
//            String[] tempr = temp.split("\\s");
//            String[] tempro = temp.split("\\s");
//            System.out.println("name: " + tempr[0] + " price: " + tempr[1] + " 3: " + tempr[2] + tempr[3]);
//            System.out.println("name: " + tempro[0] + " price: " + tempro[1]);


//            while (((tempName = input.readLine()) != null) && ((tempPrice = input.readLine()) != null)) {
//                main.put(tempName, Integer.valueOf(tempPrice));
//                System.out.println("name: " + tempName + "price: " + Integer.valueOf(tempPrice));
        } catch (Exception e) {
            System.out.println("Not today~");
        }
    }
}
