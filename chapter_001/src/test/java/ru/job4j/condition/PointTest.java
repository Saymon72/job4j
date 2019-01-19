package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Semyon Sizov (semen66613@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PointTest {

    @Test
    public void distanceTo() {
        Point a = new Point(0, 0);
        Point b = new Point(3, 4);
        double result = a.distanceTo(b);
        double expected = 5.0;
        assertThat(result, is(expected));


    }

}