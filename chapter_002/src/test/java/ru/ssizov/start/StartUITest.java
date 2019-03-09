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
            .append("����." + line)
            .append("0 - �������� ������." + line)
            .append("1 - �������� ��� ������." + line)
            .append("2 - �������� ������." + line)
            .append("3 - ������� ������." + line)
            .append("4 - ����� ������ �� ID." + line)
            .append("5 - ����� ������ �� �����." + line)
            .append("6 - ����� �� ���������." + line)
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
                                 .append("------------ ���������� ����� ������ --------------" + line)
                                 .append("------------ ����� ������ � getId : " + tracker.findAll()[0].getId() + "-----------" + line)
                         .append(menu)
                                 .append("��������� ���������" + line)
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
                                .append("------------ ����� ���� ������ --------------" + line)
                                .append("������ � : 1" + "\r" + "\n" + item1 + line)
                                .append("������ � : 2" + "\r" + "\n" + item2 + line)
                                .append("������ � : 3" + "\r" + "\n" + item3 + line)
                                .append(menu)
                                .append("��������� ���������" + line)
                                .toString()
                )
        );
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        String[] action = {"2", item.getId(), "test replace", "�������� ������", "6"};
        new StartUI(new StubInput(action), tracker).init();
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