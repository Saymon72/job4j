package ru.job4j.array;
/*
 * @author Semyon Sizov (semen66613@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    /*
     * method sort.
     *
     * @param array неотсортированный массив.
     * @return отсортированный массиа.
     */
    public int[] Sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int x = array[i];
                    array[i] = array[j];
                    array[j] = x;
                }
            }
        }
        return array;
    }
}