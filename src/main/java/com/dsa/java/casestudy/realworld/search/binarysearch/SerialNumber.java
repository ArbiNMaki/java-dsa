package com.dsa.java.casestudy.realworld.search.binarysearch;

/*
1001L, 1003L, 1005L, 1007L, 1009L, 1011L, 1013L, 1015L, 1017L, 1019L
 */

public class SerialNumber {

    public static void main(String[] args) {
        long[] serial = {1001L, 2002L, 3003L, 4004L, 5005L, 6006L, 7007L, 8008L, 9009L, 1010L, 1111L};

        System.out.println("1. ======================");
        long target = 4004L; // index 3
        long result = binarySearch(serial, target);
        if (result != -1) {
            System.out.println("Element found at index :" + result);
        } else {
            System.out.println("Element not found!");
        }

        System.out.println();
        System.out.println("2. ======================");
        long target2 = 8008L; // index 7
        long result2 = binarySearch(serial, target2);
        if (result2 == -1) {
            System.out.println("Element not found!");
        } else {
            System.out.println("Element found at index :" + result2);
        }

        System.out.println();
        System.out.println("3. ======================");
        long target3 = 6006L; // index 5
        long result3 = binarySearch(serial, target3);
        if (result3 != -1) {
            System.out.println("Element found at index :" + result3);
        } else {
            System.out.println("Element not found!");
        }

        System.out.println();
        System.out.println("4. ======================");
        long target4 = 1020L; // not found
        long result4 = binarySearch(serial, target4);

        if (result4 != -1) {
            System.out.println("Element found at index :" + result4);
        } else {
            System.out.println("Element not found!");
        }
    }

    public static long binarySearch(long[] arr, long target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                System.out.println("Target found in the middle!! : " + mid);
                return mid;
            }

            if (arr[mid] < target) {
                System.out.println("Target is greater than arr[" + mid + "], moving left to " + (mid + 1));
                left = mid + 1;
            } else {
                System.out.println("Target is less than arr[" + mid + "], moving right to " + (mid - 1));
                right = mid - 1;
            }
        }

        System.out.println("Target not found!");
        return -1;
    }
}
