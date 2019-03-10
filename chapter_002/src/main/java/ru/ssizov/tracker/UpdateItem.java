package ru.ssizov.tracker;

import ru.ssizov.models.Item;
import ru.ssizov.start.*;

public class UpdateItem implements UserAction {


    public UpdateItem(int i, String edit_item) {
    }

    @Override
    public int key() {
        return 2;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println(" -------- �������������� ������ -------- ");
        String id = input.ask(" ������� ID ������: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(" ������ � ������ " + item.getId() + " ����� ��������! ");
            String name = input.ask(" ������� ��� ����� ������: ");
            String description = input.ask(" ������� �������� ����� ������: ");
            Item newItem = new Item(name, description);
            newItem.setId(item.getId());
            tracker.replace(id, newItem);
            System.out.println(" ������ ��������");
        } else {
            System.out.println(" ������ � ����� ID �� �������");
        }
    }

    @Override
    public String info() {
        return "2 - �������� ������.";
    }
}
