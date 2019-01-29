package ru.job4j.array;

/*
 * @author Semyon Sizov (semen66613@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class MatrixCheck {
    /**
     * method mono.
     *
     * @param data массив с true и false.
     * @return результат.3
     */
    public boolean mono(boolean[][] data) {
        boolean diagonal1 = true, diagonal2 = true;
        for (int i = 0, j = data.length - 1; i < data.length - 1 && (diagonal2 || diagonal1); i++, j--) {
            if (data[i][i] != data[i + 1][i + 1] && diagonal2) {
                diagonal2 = false;
            }
            if (data[j][j] != data[i + 1][j - 1] && diagonal1) {
                diagonal1 = false;
            }
        }
        return diagonal2 || diagonal1;
    }
}