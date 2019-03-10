package ru.ssizov.tracker;

import ru.ssizov.models.Item;
import ru.ssizov.start.*;

public class DeleteItem implements UserAction {

    public DeleteItem(int i, String delete_item) {
    }

    @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Удаление заявки --------------");
        String id = input.ask("Введите ID заявки ");
        Item[] item = tracker.findAll();
        boolean rst = false;
        for (int i = 0; i < item.length; i++) {
            if (item[i].getId().equals(id)) {
                rst = true;
                tracker.delete(id);
                System.out.println("Заявка удалена");
            }
        }
        if (!rst) {
            System.out.println(" Заявка с таким ID не найдена");
        }
    }

    @Override
    public String info() {
        return "3 - Удалить заявку.";
    }
}
