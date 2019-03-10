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
        System.out.println("------------ ���������� ����� ������ --------------");
        String name = input.ask("������� ��� ������ :");
        String description = input.ask("������� �������� ������ :");
        Item item = new Item(name, description);
        tracker.add(item);
        System.out.println("------------ ����� ������ � getId : " + item.getId() + "-----------");
    }

    @Override
    public String info() {
        return "0 - �������� ����� ������.";
    }
}