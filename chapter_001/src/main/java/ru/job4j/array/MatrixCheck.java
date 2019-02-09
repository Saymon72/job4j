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
        boolean result = true;
        for (int i = 0, j = data.length - 1; i < data.length - 1; i++, j--) {
            if (data[0][0] != data[i + 1][i + 1]) {
                result = false;
                break;
            }
            if (data[0][j] != data[i + 1][j - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}