package com.dsa.java;

public class TimeComplexityDemo {

    public static void main(String[] args) {
        double now = System.currentTimeMillis();

        TimeComplexityDemo demo = new TimeComplexityDemo();
        System.out.println(demo.findSum1(100));
        System.out.println("Time taken - " + (System.currentTimeMillis() - now) + " millisecs.");

        System.out.println(demo.findSum2(100));
        System.out.println("Time taken - " + (System.currentTimeMillis() - now) + " millisecs.");
    }

    public int findSum1(int n) {
        return n * (n + 1) / 2;
    }

    public int findSum2(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
