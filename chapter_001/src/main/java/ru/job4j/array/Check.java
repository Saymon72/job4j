package ru.job4j.array;
/**
 * @author Semyon Sizov (semen66613@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Check {
    /**
     * method mono.
     * @param data index.
     * @return result.
     */
    public boolean mono(boolean[] data) {
        //boolean result = true;
        for (int index = 0; index < data.length - 1; index++) {
            if ((data[index] != data[index + 1])) {
                return false;
            }
        }
        return true;
    }
}