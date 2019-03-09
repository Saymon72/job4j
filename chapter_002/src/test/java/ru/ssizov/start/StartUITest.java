package ru.ssizov.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.ssizov.models.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    public String line = System.lineSeparator();
    public String menu = new StringBuilder()
            .append("МЕНЮ." + line)
            .append("0 - ДОБАВИТЬ ЗАЯВКУ." + line)
            .append("1 - ПОКАЗАТЬ ВСЕ ЗАЯВКИ." + line)
            .append("2 - ИЗМЕНИТЬ ЗАЯВКУ." + line)
            .append("3 - УДАЛИТЬ ЗАЯВКУ." + line)
            .append("4 - НАЙТИ ЗАЯВКУ ПО ID." + line)
            .append("5 - НАЙТИ ЗАЯВКУ ПО ИМЕНИ." + line)
            .append("6 - ВЫХОД ИЗ ПРОГРАММЫ." + line)
            .toString();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(new PrintStream(this.stdout));

    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        String[] action = {"0", "test name", "desc", "6"};
        new StartUI(new StubInput(action), tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
     public void whenAddItemsThenPrintAllItems() {
         Tracker tracker = new Tracker();
         String[] action = {"0", "test item", "test1", "6"};
         new StartUI(new StubInput(action), tracker).init();
         String line = System.lineSeparator();
         assertThat(
                 this.out.toString(),
                 is(
                         new StringBuilder()
                                 .append(menu)
                                 .append("------------ Добавление новой заявки --------------" + line)
                                 .append("------------ Новая заявка с getId : " + tracker.findAll()[0].getId() + "-----------" + line)
                         .append(menu)
                                 .append("ПРОГРАММА ЗАВЕРШЕНА" + line)
                                 .toString()
                 )
         );
     }

   @Test
    public void whenShowAllItemsThenPrintAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc1"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        Item item3 = tracker.add(new Item("test name3", "desc3"));
        String[] action = {"1", "6"};
        new StartUI(new StubInput(action), tracker).init();
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("------------ Вывод всех заявок --------------" + line)
                                .append("Заявка № : 1" + "\r" + "\n" + item1 + line)
                                .append("Заявка № : 2" + "\r" + "\n" + item2 + line)
                                .append("Заявка № : 3" + "\r" + "\n" + item3 + line)
                                .append(menu)
                                .append("ПРОГРАММА ЗАВЕРШЕНА" + line)
                                .toString()
                )
        );
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        String[] action = {"2", item.getId(), "test replace", "заменили заявку", "6"};
        new StartUI(new StubInput(action), tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenUserDeleteItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"0", "test name", "desc", "3", item.getId(), "6",});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUserFindIdItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        String[] action = {"0", "test name", "desc", "4", item.getId(), "6",};
        new StartUI(new StubInput(action), tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUserFindNameItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        String[] action = {"0", "test name", "desc", "5", "test name", "6",};
        new StartUI(new StubInput(action), tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }
}