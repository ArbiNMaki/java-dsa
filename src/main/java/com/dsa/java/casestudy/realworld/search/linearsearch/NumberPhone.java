package com.dsa.java.casestudy.realworld.search.linearsearch;

public class NumberPhone {

    public static class Kontak {
        String nama;
        String nomorTelepon;

        Kontak(String nama, String nomorTelepon) {
            this.nama = nama;
            this.nomorTelepon = nomorTelepon;
        }
    }

    public static void main(String[] args) {
        Kontak[] bukuTelepon = {
                new Kontak("Andi", "08123456789"),
                new Kontak("Budi", "08123456790"),
                new Kontak("Citra", "08123456791"),
                new Kontak("Dewi", "08123456792")
        };
        String key = "Citra";
        int index = linearSearch(bukuTelepon, key);

        if (index != -1) {
            System.out.println("Word found at index: " + index);
        } else {
            System.out.println("Word not found");
        }

        String key2 = "08123456789";
        int index2 = linearSearch(bukuTelepon, key2);

        if (index2 != -1) {
            System.out.println("Word found at index: " + index2);
        } else {
            System.out.println("Word not found");
        }

        String key3 = "081234567";
        int index3 = linearSearch(bukuTelepon, key3);

        if (index3 != -1) {
            System.out.println("Word found at index: " + index3);
        } else {
            System.out.println("Word not found");
        }
    }

    public static int linearSearch(Kontak[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].nama.equals(key)) {
                System.out.println("Element fount at index : " + i);

                return i;
            } else if (arr[i].nomorTelepon.equals(key)) {
                System.out.println("Element fount at index : " + i);

                return i;
            }
        }

        System.out.println("Element not found!");
        return -1;
    }
}
