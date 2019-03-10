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
        System.out.println(" -------- Редактирование заявки -------- ");
        String id = input.ask(" Введите ID заявки: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(" Заявка с именем " + item.getId() + " будет изменена! ");
            String name = input.ask(" Введите имя новой заявки: ");
            String description = input.ask(" Введите описание новой заявки: ");
            Item newItem = new Item(name, description);
            newItem.setId(item.getId());
            tracker.replace(id, newItem);
            System.out.println(" Заявка изменена");
        } else {
            System.out.println(" Заявка с таким ID не найдена");
        }
    }

    @Override
    public String info() {
        return "2 - Изменить заявку.";
    }
}
