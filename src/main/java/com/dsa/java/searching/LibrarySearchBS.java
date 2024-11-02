package com.dsa.java.searching;

public class LibrarySearchBS {

    // Metode untuk mencari buku berdasarkan ID menggunakan binary search
    public static int binarySearch(int[] bookIds, int targetId) {
        int left = 0, right = bookIds.length - 1; // Inisialisasi batas kiri dan kanan
        int step = 1; // Inisialisasi langkah untuk menampilkan urutan

        // Loop selama batas kiri <= batas kanan
        while (left <= right) {
            int mid = left + (right - left) / 2; // Tentukan elemen tengah

            // Cetak langkah dan status saat ini
            System.out.println("Step " + step++ + ":");
            System.out.println("Left: " + left + ", Right: " + right + ", Mid: " + mid);
            System.out.println("Comparing target ID (" + targetId + ") with bookIds[" + mid + "] = " + bookIds[mid]);

            // Jika ID buku di tengah adalah ID target, kembalikan indeksnya
            if (bookIds[mid] == targetId) {
                System.out.println("Book with ID " + targetId + " found at index " + mid);
                return mid;
            }

            // Jika target ID lebih besar, abaikan bagian kiri
            if (bookIds[mid] < targetId) {
                System.out.println("Target ID is greater than bookIds[" + mid + "], moving left to " + (mid + 1));
                left = mid + 1;
            } else { // Jika target ID lebih kecil, abaikan bagian kanan
                System.out.println("Target ID is less than bookIds[" + mid + "], moving right to " + (mid - 1));
                right = mid - 1;
            }
            System.out.println(); // Tambahkan baris kosong untuk memisahkan langkah
        }

        System.out.println("Book with ID " + targetId + " not found.");
        return -1; // Jika target tidak ditemukan, kembalikan -1
    }

    public static void main(String[] args) {
        // Daftar ID buku yang diurutkan secara ascending
        int[] bookIds = {101, 203, 305, 407, 509, 612, 715};
        int targetId = 407; // ID buku yang dicari

        // Panggil metode binary search
        int result = binarySearch(bookIds, targetId);

        // Cek apakah ID buku ditemukan
        if (result == -1)
            System.out.println("Book not found."); // Buku tidak ditemukan
        else
            System.out.println("Book found at index " + result); // Buku ditemukan di indeks ke-berapa
    }
}
