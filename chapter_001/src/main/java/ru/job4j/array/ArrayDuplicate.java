package ru.job4j.array;
/*
 * @author Semyon Sizov (semen66613@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.Arrays;
public class ArrayDuplicate {
    /**
     * method remove удаление дубликатов.
     * @param array мвссив с дубликатами.
     * @return массив без дубликатов.
     */
    public String[] remove(String[] array) {
        int duplicate = array.length;
        for (int out = 0; out < duplicate; out++) {
            for (int in = out + 1; in < duplicate; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[duplicate - 1];
                    duplicate--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, duplicate);
    }
}
