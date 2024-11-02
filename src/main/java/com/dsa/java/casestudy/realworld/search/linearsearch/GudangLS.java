package com.dsa.java.casestudy.realworld.search.linearsearch;

import java.util.Objects;

/**
 * ["Laptop", "Mouse", "Keyboard", "Monitor", "Printer", "Scanner", "Webcam", "Speaker", "Headset", "Charger"]
 */

public class GudangLS {

    public static int linearSearch(String[] words, String key) {
        for (int i = 0; i < words.length; i++) {
            if (Objects.equals(words[i], key)) {
                System.out.println("Element found at index " + i);
                return i;
            }
        }

        System.out.println("Element not found!");
        return -1;
    }

    public static void main(String[] args) {
        String[] barang = {"Laptop", "Mouse", "Keyboard", "Monitor", "Printer", "Scanner", "Webcam", "Speaker", "Headset", "Charger"};
        String key = "Webcam";
        int index = linearSearch(barang, key);

        if (index != -1) {
            System.out.println("barang found at index: " + index);
        } else {
            System.out.println("barang not found");
        }

        String key2 = "cam";
        int index2 = linearSearch(barang, key2);

        if (index != -1) {
            System.out.println("barang found at index: " + index2);
        } else {
            System.out.println("barang not found");
        }
    }
}
