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
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
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
            menu.select(Integer.valueOf(input.ask("Выберите пункт Меню :")));
        } while (!"y".equals(this.input.ask("Exit?(y/n): ")));
    }
    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}