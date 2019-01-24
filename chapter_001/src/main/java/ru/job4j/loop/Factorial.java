package ru.job4j.loop;

public class Factorial {
    public int calc(int n) {
        int multiply = 1;
        for (int x = 1; x <= n; x++) {
            multiply = multiply * x;
        }
        return multiply;
    }
}
