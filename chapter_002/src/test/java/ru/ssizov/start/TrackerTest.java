package ru.ssizov.start;

import org.junit.Test;
import ru.ssizov.models.Item;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L); //создаём заявку.
        tracker.add(previous); // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        Item next = new Item("test2", "testDescription2", 1234L); // Создаем новую заявку.
        next.setId(previous.getId()); // Проставляем старый id из previous, который был сгенерирован выше.
        tracker.replace(previous.getId(), next);  // Обновляем заявку в трекере.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));// Проверяем, что заявка с таким id имеет новые имя test2.
    }

    @Test
    public void whenDeleteItemThenReturnItemMinusOne() {
        Tracker tracker = new Tracker(); //создание нового объекта.
        Item one = new Item("test", "testDsc", 123);//создание нового объекта и передача в него параметров.
        Item two = new Item("test2", "testDsc2", 1232);//создание нового объекта и передача в него параметров.
        tracker.add(one);//выполнение метода add с парметром one (добавление заявки 123).
        tracker.add(two);//выполнение метода add с парметром two (добавление заявки 1232).
       // Item[] items = new Item[]{two}; //создание нового объекта (как я понял - итоговое значение, которое должно получиться)
        tracker.delete(one.getId());
        assertThat(tracker.findAll()[0], is(two));
    }

    @Test
    public void whenFindAllItemThenReturnCopyArray() {
        Tracker tracker = new Tracker();
        Item one = new Item("test", "testDesc", 123L);
        Item two = new Item("test", "testDesc", 123L);
        tracker.add(one);
        tracker.add(two);
        Item[] value = new Item[]{one, two};
        assertThat(tracker.findAll(), is(value));
    }

    @Test
    public void whenFindByNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test11", "testDesc", 123L);
        tracker.add(item1);
        Item item2 = new Item("test22", "testDesc", 123L);
        tracker.add(item2);
        Item item3 = new Item("test22", "testDesc", 123L);
        tracker.add(item3);
        Item[] rst = tracker.findByName("test22");
        // Проверяем, что заявка с таким id имеет новое имя test2.
        assertThat(rst[0].getName(), is("test22"));
        assertThat(rst[1].getName(), is("test22"));
    }

    @Test
    public void whenFindByIdThenReturnNewId() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test11", "testDesc", 123L);
        tracker.add(item1);
        Item item2 = new Item("test22", "testDesc", 123L);
        tracker.add(item2);
        Item item3 = new Item("test33", "testDesc", 123L);
        tracker.add(item3);
        assertThat(tracker.findById(item1.getId()).getName(), is("test11"));
    }
}
