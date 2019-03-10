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
        System.out.println("------------ �������� ������ --------------");
        String id = input.ask("������� ID ������ ");
        Item[] item = tracker.findAll();
        boolean rst = false;
        for (int i = 0; i < item.length; i++) {
            if (item[i].getId().equals(id)) {
                rst = true;
                tracker.delete(id);
                System.out.println("������ �������");
            }
        }
        if (!rst) {
            System.out.println(" ������ � ����� ID �� �������");
        }
    }

    @Override
    public String info() {
        return "3 - ������� ������.";
    }
}
