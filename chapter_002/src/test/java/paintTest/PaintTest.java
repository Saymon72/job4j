package paintTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.ssizov.paint.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Semen Sizov (semen66613@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class PaintTest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("+++++++")
                                .append("+++++++")
                                .append("+++++++")
                                .append("+++++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("    +    ")
                                .append("  +++++  ")
                                .append("+++++++++")
                                .append("++++++++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
