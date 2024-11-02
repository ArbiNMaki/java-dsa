package com.dsa.java.casestudy.realworld.search.linearsearch;

public class DocumentSearchLS {

    public static int linearSearch(String[] words, String key) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] doc = {"This", "is", "a", "simple", "document", "search", "example"};
        String key = "document";
        int index = linearSearch(doc, key);

        if (index != -1) {
            System.out.println("Word found at index: " + index);
        } else {
            System.out.println("Word not found");
        }
    }
}
