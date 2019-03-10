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
        System.out.println("------------ ����� ���� ������ --------------");
        Item[] item = tracker.findAll();
        int count = 0;
        boolean rst = false;
        if (item != null) {
            for (int i = 0; i < item.length; i++) {
                count++;
                rst = true;
                System.out.println("������ � : " + count);
                System.out.println(" ��� ������ : " + item[i].getName());
                System.out.println(" �������� ������ : " + item[i].getDescription());
                System.out.println(" ID ������ : " + item[i].getId());
            }
            if (!rst) {
                System.out.println("������ ���");
            }
        }
    }

    @Override
    public String info() {
        return "1 - �������� ��� ������.";
    }
}
