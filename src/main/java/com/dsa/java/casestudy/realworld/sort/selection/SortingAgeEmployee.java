package com.dsa.java.casestudy.realworld.sort.selection;

public class SortingAgeEmployee {

    static class Employee {
        String nama;
        int usia;
        String jabatan;

        public Employee(String nama, int usia, String jabatan) {
            this.nama = nama;
            this.usia = usia;
            this.jabatan = jabatan;
        }

        @Override
        public String toString() {
            return "{ nama: " + nama + ", usia: " + usia + ", jabatan: " + jabatan + " }";
        }
    }


    public static void selectionSort(Employee[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j].usia < arr[minIndex].usia) {
                    minIndex = j;
                }
            }

            Employee temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            System.out.println("Step" + (i + 1) + ": ");
            printArray(arr);
        }
    }

    public static void printArray(Employee[] arr) {
        for (Employee emp : arr) {
            System.out.println(emp + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Employee[] employees = {
                new Employee("Andi", 35, "Manager"),
                new Employee("Budi", 29, "Senior Developer"),
                new Employee("Citra", 32, "Product Manager"),
                new Employee("Dewi", 24, "Junior Developer"),
                new Employee("Eko", 28, "Business Analyst")
        };

        System.out.println("Before sorting:");
        printArray(employees);

        selectionSort(employees);

        System.out.println("After sorting:");
        printArray(employees);
    }
}
