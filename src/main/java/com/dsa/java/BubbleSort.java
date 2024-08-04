package com.dsa.java;

public class BubbleSort {

    public static void main(String[] args) {
        int[] numbers = {31, 23, 17, 2, 89, 45, 18, 67};
        int size = numbers.length;
        int temp = 0;
        boolean swapped;

        System.out.println("Before Sorting: ");
        for (int nums : numbers) {
            System.out.print(nums + " ");
        }

        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            System.out.println();
            System.out.println("Sorting: ");
            for (int nums : numbers) {
                System.out.print(nums + " ");
            }
        }

        System.out.println();
        System.out.println("After Sorting: ");
        for (int nums : numbers) {
            System.out.print(nums + " ");
        }
    }
}
