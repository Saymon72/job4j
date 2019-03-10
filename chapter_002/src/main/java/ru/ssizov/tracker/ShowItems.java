package ru.ssizov.tracker;

import ru.ssizov.models.Item;
import ru.ssizov.start.*;

public class ShowItems implements UserAction {
    public ShowItems(int i, String show_all_items) {
    }

    @Override
    public int key() {
        return 1;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Вывод всех заявок --------------");
        Item[] item = tracker.findAll();
        int count = 0;
        boolean rst = false;
        if (item != null) {
            for (int i = 0; i < item.length; i++) {
                count++;
                rst = true;
                System.out.println("Заявка № : " + count);
                System.out.println(" Имя заявкм : " + item[i].getName());
                System.out.println(" Описание заявки : " + item[i].getDescription());
                System.out.println(" ID заявкм : " + item[i].getId());
            }
            if (!rst) {
                System.out.println("Заявок нет");
            }
        }
    }

    @Override
    public String info() {
        return "1 - Показать все заявки.";
    }
}
