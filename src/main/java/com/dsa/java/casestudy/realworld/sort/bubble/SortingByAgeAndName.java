package com.dsa.java.casestudy.realworld.sort.bubble;

public class SortingByAgeAndName {

    static class Absen {
        String nama;
        int age;

        public Absen(String nama, int age) {
            this.nama = nama;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Absen{" +
                    "nama='" + nama + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void bubbleSort(Absen[] arr) {
        int n = arr.length;

        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i -1; j++) {
                System.out.println("Comparing: " + arr[j] + " and " + arr[j + 1] + " - ");

                if (arr[j].age > arr[j + 1].age) {
                    Absen temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    System.out.println("Swapped by age");
                }
                else if (arr[j].age == arr[j + 1].age && arr[j].nama.compareTo(arr[j + 1].nama) > 0) {
                    Absen temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    System.out.println("Swapped by name");
                } else {
                    System.out.println("Not Swapped");
                }
            }

            System.out.println("Array after iteration " + (i + 1) + ": ");
            printArray(arr);

            if (!swapped) break;
        }
    }

    public static void printArray(Absen[] arr) {
        for (Absen absen : arr) {
            System.out.println(absen + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Absen[] absens = {
                new Absen("Alicia", 16),
                new Absen("Diana", 15),
                new Absen("Bryan", 14),
                new Absen("Charles", 14),
        };

        System.out.println("Before sorting:");
        printArray(absens);

        bubbleSort(absens);

        System.out.println("After sorting:");
        printArray(absens);
    }
}
