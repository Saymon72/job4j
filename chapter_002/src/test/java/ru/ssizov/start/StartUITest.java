package ru.ssizov.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.ssizov.models.Item;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void init() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(new PrintStream(stdout));

    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        String[] action = {"0", "test name", "desc", "6"};
        new StartUI(new StubInput(action), tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        String[] action = {"2", item.getId(), "test replace", "заменили за€вку", "6"};
        new StartUI(new StubInput(action), tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenUserDeleteItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаЄм Tracker
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"0", "test name", "desc", "3", item.getId(), "6",});   //создаЄм StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаЄм StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // провер€ем, что нулевой элемент массива в трекере содержит им€, введЄнное при эмул€ции.
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

    @Test
    public void WhenUserOutAllItems() {
        Tracker tracker = new Tracker();
        String[] action = {"0", "test name", "desc", "1", "6"};
        new StartUI(new StubInput(action), tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }
}