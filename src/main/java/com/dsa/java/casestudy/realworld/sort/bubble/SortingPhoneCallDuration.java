package com.dsa.java.casestudy.realworld.sort.bubble;

public class SortingPhoneCallDuration {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("Comparing: " + arr[j] + " and " + arr[j + 1] + " - ");

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                    System.out.println("Swapped");
                } else {
                    System.out.println("Not Swapped");
                }
            }

            System.out.print("Array after iteration " + (i + 1) + ": ");
            printArray(arr);

            if (!swapped) break;
        }
    }

    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] duration = {180, 15, 240, 30, 120, 300, 60, 45};

        System.out.println("Original Array:");
        printArray(duration);

        bubbleSort(duration);

        System.out.println("Sorted Array:");
        printArray(duration);
    }
}
