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
        System.out.println("------------ �������� ������ --------------");
        String id = input.ask("������� ID ������ ");
        if (tracker.delete(id)) {
            //   tracker.delete(id);
            System.out.println("������ �������");
        }else {
            System.out.println(" ������ � ����� ID �� �������");
        }
    }


    @Override
    public String info() {
        return "3 - ������� ������.";
    }
}