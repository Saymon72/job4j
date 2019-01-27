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
        boolean temp = data[0][0];
        boolean result = true;
        int x = data.length - 1;
        for (int i = 1; i < data.length; i++) {
            if (data[i][i] != temp) {
                result = false;
                break;
            }
        }
        int i = 0;
        while (i < data.length) {
            if (data[i][x] != temp) {
                result = false;
                break;
            }
            x--;
            i++;
        }
        return result;
    }
}