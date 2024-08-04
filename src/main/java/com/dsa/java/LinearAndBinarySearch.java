package com.dsa.java;

public class LinearAndBinarySearch {

    public static void main(String[] args) {
        int[] numbers = {5,8,13,21,34,55,89,144,233,377};
//        int target = 12; "Element Not Found"
        int target = 21; // 3

        int result = linearSearch(numbers, target);

        if (result != -1) {
            System.out.println("Element found at Index : " + result);
        } else  {
            System.out.println("Element not found!");
        }
    }

    public static int linearSearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
