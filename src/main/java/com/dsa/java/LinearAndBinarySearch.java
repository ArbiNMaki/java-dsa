package com.dsa.java;

public class LinearAndBinarySearch {

    public static void main(String[] args) {
        int[] numbers = {5,8,13,21,34,55,89,144,233,377};
//        int target = 12; "Element Not Found"
        int target = 55; // 5
        int target2 = 89; // 6

        int resultLinear = linearSearch(numbers, target);
        int resultBinarySearch = binarySearch(numbers, target2);

        if (resultLinear != -1 || resultBinarySearch != -1) {
            System.out.println("linearSearch = Element found at Index : " + resultLinear);
            System.out.println("binarySearch = Element found at Index : " + resultBinarySearch);
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

    public static int binarySearch(int[] numbers, int target2) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (numbers[middle] == target2) {
                return middle;
            } else if (numbers[middle] < target2){
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}
