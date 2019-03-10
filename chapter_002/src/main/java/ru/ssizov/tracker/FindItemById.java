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
        System.out.println("------------ ����� ������ �� Id --------------");
        String id = input.ask("������� ID ������ ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(" ����������� ������ ");
            System.out.println(" ��� ������ : " + item.getName());
            System.out.println(" �������� ������ : " + item.getDescription());
            System.out.println(" ID ������ : " + item.getId());
        } else {
            System.out.println(" ������ � ����� ID �� �������");
        }
    }

    @Override
    public String info() {
        return "4 - ����� ������ �� ID.";
    }
}
