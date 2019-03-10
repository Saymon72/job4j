package ru.ssizov.start;

import ru.ssizov.tracker.*;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    private final Input input;

    private final Tracker tracker;

    /**
     * ���������� ���������������� ����.
     *
     * @param input   ���� ������.
     * @param tracker ��������� ������.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(Integer.valueOf(input.ask("�������� ����� ���� :")));
        } while (!"y".equals(this.input.ask("Exit?(y/n): ")));
    }
    /**
     * ������ ���������.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}