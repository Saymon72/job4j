package ru.ssizov.tracker;

import ru.ssizov.start.Input;
import ru.ssizov.start.Tracker;

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
        if (tracker.delete(id)) {
            //   tracker.delete(id);
            System.out.println("Заявка удалена");
        }else {
            System.out.println(" Заявка с таким ID не найдена");
        }
    }


    @Override
    public String info() {
        return "3 - Удалить заявку.";
    }
}