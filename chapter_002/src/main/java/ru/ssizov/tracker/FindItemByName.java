package ru.ssizov.tracker;

import ru.ssizov.models.Item;
import ru.ssizov.start.*;

public class FindItemByName implements UserAction {

    public FindItemByName(int i, String find_items_by_name) {
    }

    @Override
    public int key() {
        return 5;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = input.ask("Введите Имя заявки");
        Item[] item = tracker.findAll();
        boolean rst = false;
        for (int i = 0; i < item.length; i++) {
            if (item[i].getName().equals(name)) {
                rst = true;
                tracker.findByName(name);
                System.out.println(" Запрошенная заявка ");
                System.out.println(" Имя заявкм : " + item[i].getName());
                System.out.println(" Описание заявки : " + item[i].getDescription());
                System.out.println(" ID заявкм : " + item[i].getId());
            }
        }
        if (!rst) {
            System.out.println(" Заявка с таким именем не найдена");
        }
    }

    @Override
    public String info() {
        return "5 - Найти заявку по Имени.";
    }
}
