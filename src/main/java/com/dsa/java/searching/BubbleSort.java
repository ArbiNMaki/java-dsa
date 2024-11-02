package com.dsa.java.searching;

public class BubbleSort {
    // Method bubbleSort yang mengimplementasikan algoritma Bubble Sort
    public static void bubbleSort(int[] arr) {
        // Mendapatkan panjang array
        int n = arr.length;

        // Deklarasi variabel swapped untuk memeriksa apakah ada elemen yang ditukar selama iterasi
        boolean swapped;

        // Looping eksternal yang mengulangi proses sorting untuk setiap elemen
        for (int i = 0; i < n - 1; i++) {
            swapped = false; // Setiap iterasi, set swapped ke false

            // Looping internal untuk membandingkan dan menukar elemen berdekatan
            for (int j = 0; j < n - i - 1; j++) {
                // Mencetak elemen yang akan dibandingkan
                System.out.print("Comparing: " + arr[j] + " and " + arr[j + 1] + " - ");

                // Jika elemen kiri lebih besar dari elemen kanan, tukar
                if (arr[j] > arr[j + 1]) {
                    // Melakukan swap pada arr[j] dan arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // Set swapped ke true karena terjadi pertukaran
                    swapped = true;
                    System.out.println("Swapped"); // Cetak bahwa elemen ditukar
                } else {
                    // Jika tidak ada pertukaran, cetak bahwa elemen tidak ditukar
                    System.out.println("Not Swapped");
                }
            }

            // Cetak array setelah setiap iterasi loop eksternal
            System.out.print("Array after iteration " + (i + 1) + ": ");
            printArray(arr);

            // Jika tidak ada elemen yang ditukar dalam satu iterasi, hentikan loop
            if (!swapped) break;
        }
    }

    // Method printArray untuk mencetak elemen-elemen array
    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println(); // Pindah ke baris berikutnya setelah mencetak seluruh array
    }

    // Method main sebagai titik masuk program
    public static void main(String[] args) {
        // Deklarasi dan inisialisasi array scores yang akan diurutkan
        int[] scores = {64, 34, 25, 12, 22, 11, 90};

        // Cetak array asli sebelum diurutkan
        System.out.println("Original Array:");
        printArray(scores);

        // Panggil method bubbleSort untuk mengurutkan array
        bubbleSort(scores);

        // Cetak array setelah diurutkan
        System.out.println("Sorted Array:");
        printArray(scores);
    }
}

