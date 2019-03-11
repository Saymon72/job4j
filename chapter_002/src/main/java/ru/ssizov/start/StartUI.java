package ru.ssizov.start;

import ru.ssizov.tracker.*;

import java.util.*;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    private final Input input;


    /**
     * Конструтор инициализирующий поля.
     *
     * @param input ввод данных.
     */
    public StartUI(Input input) {
        this.input = input;
    }

    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("Выберите пункт Меню :", range));
        } while (!"y" .equals(this.input.ask("Выйти из программы?(y/n): ")));
    }

    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        new StartUI(input).init();
    }
}