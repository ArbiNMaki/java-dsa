package com.dsa.java.casestudy.realworld.sort.selection;

public class SortingDeviceStorageCapacity {

     static class DeviceStorage {
        String nama;
        int capacity;

        public DeviceStorage(String nama, int capacity) {
            this.nama = nama;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return "DeviceStorage{" +
                    "nama='" + nama + '\'' +
                    ", capacity=" + capacity +
                    '}';
        }
    }

    public static void selectionSort(DeviceStorage[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j].capacity > arr[minIndex].capacity) {
                    minIndex = j;
                }
            }

            DeviceStorage temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            System.out.println("Step" + (i + 1) + ": ");
            printArray(arr);
        }
    }

    public static void printArray(DeviceStorage[] arr) {
        for (DeviceStorage stor : arr) {
            System.out.println(stor + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeviceStorage[] device = {
                new DeviceStorage("Gawai A", 64),
                new DeviceStorage("Gawai B", 128),
                new DeviceStorage("Gawai C", 256),
                new DeviceStorage("Gawai D", 32),
                new DeviceStorage("Gawai E", 512),
        };

        System.out.println("Before sorting:");
        printArray(device);

        selectionSort(device);

        System.out.println("After sorting:");
        printArray(device);
    }
}
