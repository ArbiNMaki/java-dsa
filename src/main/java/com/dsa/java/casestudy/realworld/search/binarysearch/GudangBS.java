package com.dsa.java.casestudy.realworld.search.binarysearch;

public class GudangBS {

    public static void main(String[] args) {
        String[] barang = {"Charger", "Headset", "Keyboard", "Laptop", "Monitor", "Mouse", "Printer", "Scanner", "Speaker", "Webcam"};

        String[] targets = {"Webcam", "Keyboard", "Scanner", "NotFound"};

        for (String target : targets) {
            int result = binarySearch(barang, target);

            if (result == -1) {
                System.out.println("Kata '" + target + "' tidak ditemukan.");
            } else {
                System.out.println("Kata '" + target + "' ditemukan pada index: " + result);
            }
        }
    }

    public static int binarySearch(String[] arr, String target) {
        int left = 0;
        int right = arr.length - 1;

        String lowerCaseTarget = target.toLowerCase();

        while (left <= right) {
            int mid = left + (right - left) / 2;

            String lowerCaseMidValue = arr[mid].toLowerCase();

            int comparison = lowerCaseMidValue.compareTo(lowerCaseTarget);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
