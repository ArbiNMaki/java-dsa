package com.dsa.java.searching;

public class LinearSearch {

    // Method untuk melakukan pencarian linier
    public static int linearSearch(int[] array, int key) {
        // Looping melalui setiap elemen dalam array
        for (int i = 0; i < array.length; i++) {
            // Cetak langkah saat ini
            System.out.println("Step " + (i + 1) + ": Checking index " + i + " (value: " + array[i] + ")");

            // Jika elemen saat ini sama dengan kunci, kembalikan indeks
            if (array[i] == key) {
                System.out.println("Element found at index " + i);
                return i;
            }
        }
        // Jika elemen tidak ditemukan, kembalikan -1
        System.out.println("Element not found in the array");
        return -1;
    }

    public static void main(String[] args) {
        // Inisialisasi array dan elemen kunci yang akan dicari
        int[] array = {34, 78, 19, 45, 12, 89, 67};
        int key = 45;

        // Panggil method linearSearch dan simpan hasilnya dalam variabel index
        int index = linearSearch(array, key);

        // Cek apakah elemen ditemukan atau tidak
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}
