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
public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("+++++++")
                                .append("+++++++")
                                .append("+++++++")
                                .append("+++++++")
                                .toString()
                )
        );
    }
}
