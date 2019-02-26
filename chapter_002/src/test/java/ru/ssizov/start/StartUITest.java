package ru.ssizov.start;

import org.junit.Test;
import ru.ssizov.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаЄм Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаЄм StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаЄм StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // провер€ем, что нулевой элемент массива в трекере содержит им€, введЄнное при эмул€ции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаЄм Tracker
        Tracker tracker = new Tracker();
        //Ќапр€мую добавл€ем за€вку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаЄм StubInput с последовательностью действий(производим замену за€вки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили за€вку", "6"});
        // создаЄм StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // провер€ем, что нулевой элемент массива в трекере содержит им€, введЄнное при эмул€ции.
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
        Tracker tracker = new Tracker();     // создаЄм Tracker
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"0", "test name", "desc", "4", item.getId(), "6",});   //создаЄм StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаЄм StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // провер€ем, что нулевой элемент массива в трекере содержит им€, введЄнное при эмул€ции.
    }

    @Test
    public void whenUserFindNameItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаЄм Tracker
        //Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"0", "test name", "desc", "5", "test name", "6",});   //создаЄм StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаЄм StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // провер€ем, что нулевой элемент массива в трекере содержит им€, введЄнное при эмул€ции.
    }
}