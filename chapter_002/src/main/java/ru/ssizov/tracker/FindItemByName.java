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
        System.out.println("------------ ����� ������ �� ����� --------------");
        String name = input.ask("������� ��� ������");
        Item[] item = tracker.findAll();
        boolean rst = false;
        for (int i = 0; i < item.length; i++) {
            if (item[i].getName().equals(name)) {
                rst = true;
                tracker.findByName(name);
                System.out.println(" ����������� ������ ");
                System.out.println(" ��� ������ : " + item[i].getName());
                System.out.println(" �������� ������ : " + item[i].getDescription());
                System.out.println(" ID ������ : " + item[i].getId());
            }
        }
        if (!rst) {
            System.out.println(" ������ � ����� ������ �� �������");
        }
    }

    @Override
    public String info() {
        return "5 - ����� ������ �� �����.";
    }
}
