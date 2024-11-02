package com.dsa.java.casestudy.realworld.search.binarysearch;

import java.util.Arrays;
import java.util.Comparator;

public class Flight {

    public static class Penerbangan {
        String kodePenerbangan;
        String tujuan;
        String waktuBerangkat;

        Penerbangan(String kodePenerbangan, String tujuan, String waktuBerangkat) {
            this.kodePenerbangan = kodePenerbangan;
            this.tujuan = tujuan;
            this.waktuBerangkat = waktuBerangkat;
        }

        public String getLowerCaseAttribute(String attributeName) {
            return switch (attributeName) {
                case "kodePenerbangan" -> kodePenerbangan.toLowerCase();
                case "tujuan" -> tujuan.toLowerCase();
                case "waktuBerangkat" -> waktuBerangkat.toLowerCase();
                default -> throw new IllegalArgumentException("Invalid attribute name: " + attributeName);
            };
        }
    }

    public static void main(String[] args) {
        Penerbangan[] jadwalPenerbangan = {
                new Penerbangan("GA101", "Jakarta", "08:00"),
                new Penerbangan("GA102", "Surabaya", "09:00"),
                new Penerbangan("GA103", "Bali", "10:00"),
                new Penerbangan("GA104", "Medan", "11:00"),
                new Penerbangan("GA105", "Bandung", "12:00")
        };

        String target = "ga101";
        String attribute = "kodePenerbangan";
        int result = binarySearch(jadwalPenerbangan, target, attribute);
        if (result == -1) {
            System.out.println("Flight '" + target + "' tidak ditemukan.");
        } else {
            System.out.println("Flight '" + target + "' ditemukan pada index: " + result);
        }

        String target2 = "bali";
        String attribute2 = "tujuan";
        int result2 = binarySearch(jadwalPenerbangan, target2, attribute2);
        if (result2 == -1) {
            System.out.println("Flight '" + target2 + "' tidak ditemukan.");
        } else {
            System.out.println("Flight '" + target2 + "' ditemukan pada index: " + result2);
        }

        String target3 = "12:00";
        String attribute3 = "waktuBerangkat";
        int result3 = binarySearch(jadwalPenerbangan, target3, attribute3);
        if (result3 == -1) {
            System.out.println("Flight '" + target3 + "' tidak ditemukan.");
        } else {
            System.out.println("Flight '" + target3 + "' ditemukan pada index: " + result3);
        }
    }

    public static int binarySearch(Penerbangan[] arr, String target, String attribute) {
        int left = 0;
        int right = arr.length - 1;

        String lowerCaseTarget = target.toLowerCase();

        while (left <= right) {
            int mid = left + (right - left) / 2;

            String lowerCaseMidValue = arr[mid].getLowerCaseAttribute(attribute);

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
