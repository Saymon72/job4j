package ru.job4j.array;
/*
 * @author Semyon Sizov (semen66613@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        int[] input = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] expect = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        BubbleSort sort = new BubbleSort();
        int[] result = sort.sort(input);
        assertThat(result, is(expect));
    }
}
