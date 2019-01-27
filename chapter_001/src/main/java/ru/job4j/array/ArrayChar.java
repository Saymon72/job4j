package ru.job4j.array;

/**
 * @author Semyon Sizov (semen66613@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет, что слово начинается с префикса.
     *
     * @param prefix префикс.
     * @return если слово начинается с префикса.
     */
    public boolean startWith(String prefix) {
         char[] value = prefix.toCharArray();
         boolean result = true;
        // проверить. что массив data имеет первые элементы одинаковые с value
        for (int index = 0; index < value.length; index++) {
            if (data[index] != value[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}