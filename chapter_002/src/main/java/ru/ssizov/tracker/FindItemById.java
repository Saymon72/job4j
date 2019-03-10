package ru.ssizov.tracker;

import ru.ssizov.models.Item;
import ru.ssizov.start.*;

public class FindItemById implements UserAction {

    public FindItemById(int i, String find_item_by_id) {
    }

    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по Id --------------");
        String id = input.ask("Введите ID заявки ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(" Запрошенная заявка ");
            System.out.println(" Имя заявкм : " + item.getName());
            System.out.println(" Описание заявки : " + item.getDescription());
            System.out.println(" ID заявкм : " + item.getId());
        } else {
            System.out.println(" Заявка с таким ID не найдена");
        }
    }

    @Override
    public String info() {
        return "4 - Найти заявку по ID.";
    }
}
