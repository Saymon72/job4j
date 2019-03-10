package ru.ssizov.tracker;

import ru.ssizov.start.*;

import java.util.*;

public class MenuTracker {
    /**
     * @param ������ ������ �� ������ .
     */
    private Input input;
    /**
     * @param ������ ������ �� ������ .
     */
    private Tracker tracker;
    /**
     * @param ������ ������ �� ������ ���� UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * �����������.
     *
     * @param input   ������ ���� Input
     * @param tracker ������ ���� Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * ����� ��� ��������� ������� ����.
     *
     * @return ����� �������
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * ����� ��������� ������.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add program"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }

    /**
     * ����� � ����������� �� ���������� �����, ��������� �������������� ��������.
     *
     * @param key ���� ��������
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * ����� ������� �� ����� ����.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}