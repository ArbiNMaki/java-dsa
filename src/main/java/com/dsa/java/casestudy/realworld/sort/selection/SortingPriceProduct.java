package com.dsa.java.casestudy.realworld.sort.selection;

public class SortingPriceProduct {

    static class Product {
        String product;
        int harga;

        public Product(String product, int harga) {
            this.product = product;
            this.harga = harga;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "product='" + product + '\'' +
                    ", harga=" + harga +
                    '}';
        }
    }

    public static void selectionSort(Product[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j].harga < arr[minIndex].harga) {
                    minIndex = j;
                }
            }

            Product temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            System.out.println("Step" + (i + 1) + ": ");
            printArray(arr);
        }
    }

    public static void printArray(Product[] arr) {
        for (Product prod : arr) {
            System.out.println(prod + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Product[] product = {
                new Product("Laptop", 12_000_000),
                new Product("Smartphone", 8_000_000),
                new Product("Headphone", 1_500_000),
                new Product("Smartwatch", 3_000_000),
                new Product("Tablet", 4_500_000),
        };

        System.out.println("Before sorting:");
        printArray(product);

        selectionSort(product);

        System.out.println("After sorting:");
        printArray(product);
    }
}
