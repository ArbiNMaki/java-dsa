package com.dsa.java.casestudy.realworld.search.linearsearch;

import java.util.Objects;

public class FindingBook {

    public static void main(String[] args) {
        String[] book = {"Buku A", "Buku B", "Buku C", "Buku D", "Buku E"};
        String key = "Buku D";
        int index = linearSearch(book, key);

        if (index != -1) {
            System.out.println("Word found at index: " + index);
        } else {
            System.out.println("Word not found");
        }

        String key2 = "Buku Z";
        int index2 = linearSearch(book, key2);

        if (index2 != -1) {
            System.out.println("Word found at index: " + index2);
        } else {
            System.out.println("Word not found");
        }
    }

    public static int linearSearch(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(arr[i], key)) {
                System.out.println("Element fount at index : " + i);

                return i;
            }
        }

        System.out.println("Element not found!");
        return -1;
    }
}
