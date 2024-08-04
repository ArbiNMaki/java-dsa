package com.dsa.java;

public class LinearAndBinarySearch {

    public static void main(String[] args) {
        int[] numbers = {5,8,13,21,34,55,89,144,233,377};
        int target = 144;

        int result = linearSearch(numbers, target);

        System.out.println("Element found at Index : " + result);
    }

    public static int linearSearch(int[] numbers, int target) {
        return -1;
    }
}
