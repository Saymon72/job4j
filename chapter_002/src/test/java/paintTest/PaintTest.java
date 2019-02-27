package paintTest;

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
    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out; // получаем ссылку на стандартный вывод в консоль.
        ByteArrayOutputStream out = new ByteArrayOutputStream();  // Создаем буфур для хранения вывода.
        System.setOut(new PrintStream(out));  //Заменяем стандартный вывод на вывод в пямять для тестирования.
        new Paint().draw(new Square()); // выполняем действия пишушиее в консоль.
        assertThat(  // проверяем результат вычисления
                new String(out.toByteArray()),
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
        System.setOut(stdout); // возвращаем обратно стандартный вывод в консоль.
    }

    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
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
        System.setOut(stdout);
    }
}
