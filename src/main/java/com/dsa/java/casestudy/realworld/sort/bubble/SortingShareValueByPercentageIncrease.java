package com.dsa.java.casestudy.realworld.sort.bubble;

public class SortingShareValueByPercentageIncrease {

    static class Stock {
        String stockName;
        double change;

        public Stock(String stockName, double change) {
            this.stockName = stockName;
            this.change = change;
        }

        @Override
        public String toString() {
            return "Stock{" +
                    "stockName='" + stockName + '\'' +
                    ", change=" + change +
                    '}';
        }
    }

    public static void bubbleSort(Stock[] arr) {
        int n = arr.length;

        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false; // Setiap iterasi, set swapped ke false

            // Looping internal untuk membandingkan dan menukar elemen berdekatan
            for (int j = 0; j < n - i - 1; j++) {
                // Mencetak elemen yang akan dibandingkan
                System.out.println("Comparing: " + arr[j] + " and " + arr[j + 1] + " - ");

                // Jika elemen kiri lebih besar dari elemen kanan, tukar
                if (arr[j].change > arr[j + 1].change) {
                    // Melakukan swap pada arr[j] dan arr[j + 1]
                    Stock temp = arr[j];
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
            System.out.println("Array after iteration " + (i + 1) + ": ");
            printArray(arr);

            // Jika tidak ada elemen yang ditukar dalam satu iterasi, hentikan loop
            if (!swapped) break;
        }
    }

    public static void printArray(Stock[] arr) {
        for (Stock share : arr) {
            System.out.println(share + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stock[] stocks = {
                new Stock("Stock A", 5.2),
                new Stock("Stock B", 2.8),
                new Stock("Stock C", 7.4),
                new Stock("Stock D", 3.1),
                new Stock("Stock E", 6.9),
        };

        System.out.println("Before sorting:");
        printArray(stocks);

        bubbleSort(stocks);

        System.out.println("After sorting:");
        printArray(stocks);
    }
}
