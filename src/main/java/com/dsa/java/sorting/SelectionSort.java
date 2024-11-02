package com.dsa.java.sorting; // Mendeklarasikan package yang berisi kelas ini

public class SelectionSort { // Mendefinisikan kelas SelectionSort

    public static void main(String[] args) { // Titik masuk program Java
        int[] numbers = {31, 23, 17, 2, 89, 45, 18, 67}; // Mendeklarasikan dan menginisialisasi array dengan nilai yang akan diurutkan
        int size = numbers.length; // Menyimpan panjang array dalam variabel size

        System.out.println("Before Sorting: "); // Mencetak pesan sebelum proses sorting dimulai
        printArray(numbers); // Memanggil metode printArray untuk mencetak elemen-elemen array sebelum sorting

        selectionSort(numbers); // Memanggil metode selectionSort untuk mengurutkan array

        System.out.println("After Sorting: "); // Mencetak pesan setelah proses sorting selesai
        printArray(numbers); // Memanggil metode printArray untuk mencetak elemen-elemen array setelah sorting
    }

    private static void selectionSort(int[] array) { // Mendefinisikan metode selectionSort yang mengurutkan array
        int size = array.length; // Menyimpan panjang array dalam variabel size
        for (int i = 0; i < size - 1; i++) { // Loop dari indeks 0 hingga size-2
            int minIndex = i; // Menetapkan minIndex ke i
            for (int j = i + 1; j < size; j++) { // Loop dari indeks i+1 hingga size-1
                if (array[minIndex] > array[j]) { // Membandingkan elemen di minIndex dengan elemen di j
                    minIndex = j; // Memperbarui minIndex jika elemen di j lebih kecil
                }
            }
            // Menampilkan status array sebelum pertukaran
            System.out.println("Step " + (i + 1) + ": Swapping element at index " + i + " with element at index " + minIndex);
            printArray(array); // Menampilkan status array sebelum melakukan pertukaran

            // Swap the elements
            int temp = array[minIndex]; // Menyimpan elemen terkecil dalam variabel temp
            array[minIndex] = array[i]; // Menetapkan elemen terkecil ke posisi i
            array[i] = temp; // Menetapkan elemen di i ke posisi minIndex

            // Menampilkan status array setelah pertukaran
            System.out.println("Array after swap:");
            printArray(array); // Menampilkan status array setelah melakukan pertukaran
        }
    }

    private static void printArray(int[] array) { // Mendefinisikan metode printArray yang mencetak elemen-elemen array
        for (int num : array) { // Loop melalui setiap elemen dalam array
            System.out.print(num + " "); // Mencetak elemen array diikuti dengan spasi
        }
        System.out.println(); // Mencetak baris baru setelah seluruh elemen array dicetak
    }
}
