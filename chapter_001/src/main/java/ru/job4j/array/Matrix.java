package ru.job4j.array;
/*
 * @author Semyon Sizov (semen66613@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Matrix {
    /**
     * method multipe.
     * @param size размер таблицы.
     * @return таблица умножения.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}