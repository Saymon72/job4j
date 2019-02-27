package paintTest;

import org.junit.Test;
import ru.ssizov.paint.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Semen Sizov (semen66613@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    @Test
    public void whenDrawTriangle2() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("    +    ")
                                .append("  +++++  ")
                                .append("+++++++++")
                                .append("++++++++++")
                                .toString()
                )
        );
    }
}
