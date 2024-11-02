package com.dsa.java.searching;

public class SelectionSort {

    // Method untuk melakukan Selection Sort pada array
    public static void selectionSort(int[] arr) {
        int n = arr.length;  // Menyimpan panjang array

        // Looping untuk menggerakkan batas dari bagian yang belum diurutkan
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;  // Anggap elemen pertama dari bagian yang belum diurutkan adalah yang terkecil

            // Looping untuk menemukan elemen terkecil dalam bagian yang belum diurutkan
            for (int j = i + 1; j < n; j++) {
                // Jika ditemukan elemen yang lebih kecil, update minIndex
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;  // Update minIndex jika elemen yang lebih kecil ditemukan
                }
            }

            // Tukar elemen terkecil yang ditemukan dengan elemen pertama dari bagian yang belum diurutkan
            int temp = arr[minIndex];  // Simpan nilai elemen terkecil di variabel sementara
            arr[minIndex] = arr[i];    // Pindahkan elemen pertama ke posisi elemen terkecil
            arr[i] = temp;             // Pindahkan elemen terkecil ke posisi pertama

            // Print array setelah setiap langkah pengurutan untuk melihat proses step-by-step
            System.out.print("Step " + (i + 1) + ": ");
            printArray(arr);
        }
    }

    // Method untuk mencetak array
    public static void printArray(int[] arr) {
        for (int num : arr) {  // Loop untuk mencetak setiap elemen dalam array
            System.out.print(num + " ");  // Cetak elemen diikuti dengan spasi
        }
        System.out.println();  // Pindah ke baris baru setelah mencetak seluruh elemen
    }

    // Method utama untuk menjalankan program
    public static void main(String[] args) {
        // Array dengan harga produk yang akan diurutkan
        int[] prices = { 20000, 5000, 15000, 8000, 30000 };

        // Cetak array sebelum pengurutan
        System.out.println("Before sorting:");
        printArray(prices);

        // Panggil method untuk mengurutkan array menggunakan Selection Sort
        selectionSort(prices);

        // Cetak array setelah pengurutan
        System.out.println("After sorting:");
        printArray(prices);
    }
}
