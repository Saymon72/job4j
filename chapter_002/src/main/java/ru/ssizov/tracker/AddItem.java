package ru.ssizov.tracker;

import ru.ssizov.start.*;
import ru.ssizov.models.Item;

public class AddItem implements UserAction {

    public AddItem(int i, String add_program) {
    }

    @Override
    public int key() {
        return 0;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки :");
        String description = input.ask("Введите описание заявки :");
        Item item = new Item(name, description);
        tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    @Override
    public String info() {
        return "0 - Добавить новую заявку.";
    }
}