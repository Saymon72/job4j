package ru.ssizov.start;

import org.junit.Test;
import ru.ssizov.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // ������ Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //������ StubInput � ������������������� ��������
        new StartUI(input, tracker).init();     //   ������ StartUI � �������� ����� init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // ���������, ��� ������� ������� ������� � ������� �������� ���, �������� ��� ��������.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // ������ Tracker
        Tracker tracker = new Tracker();
        //�������� ��������� ������
        Item item = tracker.add(new Item("test name", "desc"));
        //������ StubInput � ������������������� ��������(���������� ������ ������)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "�������� ������", "6"});
        // ������ StartUI � �������� ����� init()
        new StartUI(input, tracker).init();
        // ���������, ��� ������� ������� ������� � ������� �������� ���, �������� ��� ��������.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenUserDeleteItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // ������ Tracker
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"0", "test name", "desc", "3", item.getId(), "6",});   //������ StubInput � ������������������� ��������
        new StartUI(input, tracker).init();     //   ������ StartUI � �������� ����� init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // ���������, ��� ������� ������� ������� � ������� �������� ���, �������� ��� ��������.
    }

    @Test
    public void whenUserFindIdItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // ������ Tracker
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"0", "test name", "desc", "4", item.getId(), "6",});   //������ StubInput � ������������������� ��������
        new StartUI(input, tracker).init();     //   ������ StartUI � �������� ����� init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // ���������, ��� ������� ������� ������� � ������� �������� ���, �������� ��� ��������.
    }

    @Test
    public void whenUserFindNameItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // ������ Tracker
        //Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"0", "test name", "desc", "5", "test name", "6",});   //������ StubInput � ������������������� ��������
        new StartUI(input, tracker).init();     //   ������ StartUI � �������� ����� init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // ���������, ��� ������� ������� ������� � ������� �������� ���, �������� ��� ��������.
    }
}