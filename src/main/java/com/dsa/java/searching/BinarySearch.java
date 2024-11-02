package com.dsa.java.searching;

public class BinarySearch {

    // Method untuk melakukan binary search pada array yang sudah diurutkan
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1; // Inisialisasi batas kiri dan kanan
        int step = 1; // Inisialisasi langkah untuk menampilkan urutan

        // Loop selama batas kiri <= batas kanan
        while (left <= right) {
            int mid = left + (right - left) / 2; // Tentukan elemen tengah

            // Cetak langkah dan status saat ini
            System.out.println("Step " + step++ + ":");
            System.out.println("Left: " + left + ", Right: " + right + ", Mid: " + mid);
            System.out.println("Comparing target (" + target + ") with arr[" + mid + "] = " + arr[mid]);

            // Jika elemen tengah adalah target, kembalikan indeksnya
            if (arr[mid] == target) {
                System.out.println("Target found at index " + mid);
                return mid;
            }

            // Jika target lebih besar, abaikan bagian kiri
            if (arr[mid] < target) {
                System.out.println("Target is greater than arr[" + mid + "], moving left to " + (mid + 1));
                left = mid + 1;
            } else { // Jika target lebih kecil, abaikan bagian kanan
                System.out.println("Target is less than arr[" + mid + "], moving right to " + (mid - 1));
                right = mid - 1;
            }
            System.out.println(); // Tambahkan baris kosong untuk memisahkan langkah
        }

        System.out.println("Target not found in the array.");
        return -1; // Jika target tidak ditemukan, kembalikan -1
    }

    // Main method untuk menguji fungsi binary search
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11}; // Array yang sudah diurutkan
        int target = 7; // Elemen yang dicari
        int result = binarySearch(arr, target); // Panggil fungsi binary search

        // Cek apakah elemen ditemukan
        if (result == -1)
            System.out.println("Element not present"); // Elemen tidak ditemukan
        else
            System.out.println("Element found at index " + result); // Elemen ditemukan di indeks ke-berapa
    }
}

