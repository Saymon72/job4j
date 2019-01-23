package ru.job4j.loop;

public class Counter{
    // public static void main(String[] args){
    public int add(int start, int finish) {
        finish = 10;
        int sum = 0;
        for (start=1;start<=finish;start++) {
            if (start % 2 == 0) {
                sum = sum + start;
            }
        }
        return sum;
    }
}
