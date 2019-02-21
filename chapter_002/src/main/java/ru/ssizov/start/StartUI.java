package ru.ssizov.start;

import ru.ssizov.models.*;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    private static final String ADD = "0";

    private static final String SHOWALL = "1";

    private static final String EDIT = "2";

    private static final String DELETE = "3";

    private static final String FINDID = "4";

    private static final String FINDNAME = "5";

    private static final String EXIT = "6";

    private final Input input;

    private final Tracker tracker;

    /**
     * ���������� ���������������� ����.
     *
     * @param input   ���� ������.
     * @param tracker ��������� ������.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("������� ����� ���� : ");
            if (ADD.equals(answer)) {
                this.addItem();
            } else if (SHOWALL.equals(answer)) {
                this.showAllItem();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDID.equals(answer)) {
                this.findidItem();
            } else if (FINDNAME.equals(answer)) {
                this.findnameItem();
            } else if (EXIT.equals(answer)) {
                System.out.println("��������� ���������");
                exit = true;
            }
        }
    }

    /**
     * ����� ��������� ���������� ����� ������ � ���������.
     */
    private void addItem() {
        System.out.println("------------ ���������� ����� ������ --------------");
        String name = this.input.ask("������� ��� ������ :");
        String description = this.input.ask("������� �������� ������ :");
        Item item = new Item(name, description);
        this.tracker.add(item);
        System.out.println("------------ ����� ������ � getId : " + item.getId() + "-----------");
    }

    /**
     * ����� ��������� ����� ���� ������ �� ���������.
     */
    private void showAllItem() {
        System.out.println("------------ ����� ���� ������ --------------");
        Item[] item = this.tracker.findAll();
        int count = 0;
        if (item != null) {
            for (int i = 0; i < item.length; i++) {
                count++;
                System.out.println("������ � : " + count);
                System.out.println(" ��� ������ : " + item[i].getName());
                System.out.println(" �������� ������ : " + item[i].getDescription());
                System.out.println(" ID ������ : " + item[i].getId());
            }
            System.out.println("������ ���");
        }
    }

    /**
     * ����� ��������� ��������� ������.
     */
    private void editItem() {
        System.out.println(" -------- �������������� ������ -------- ");
        String id = this.input.ask(" ����� ID ������: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println(" ������ � ������ " + item.getId() + " ����� ��������! ");
            String name = this.input.ask(" ������� ��� ����� ������: ");
            String description = this.input.ask(" ������� �������� ����� ������: ");
            Item newItem = new Item(name, description);
            newItem.setId(item.getId());
            this.tracker.replace(id, newItem);
            System.out.println(" ������ �  ID  ��������");
        } else {
            System.out.println(" ������ � ����� ID �� �������");
        }
    }

    /**
     * ����� ��������� �������� ������.
     */
    private void deleteItem() {
        System.out.println("------------ �������� ������ --------------");
        String id = this.input.ask("������� ID ������");
        Item[] item = this.tracker.findAll();
        boolean rst = false;
        for (int i = 0; i < item.length; i++) {
            if (item[i].getId().equals(id)) {
                rst = true;
                this.tracker.delete(id);
                System.out.println("������ �������");
            }
        }
        if (rst == false) {
            System.out.println(" ������ � ����� ID �� �������");
        }
    }

    /**
     * ����� ��������� ����� ������ �� Id.
     */
    private void findidItem() {
        System.out.println("------------ ����� ������ �� Id --------------");
        String id = this.input.ask("������� ID ������");
        Item[] item = this.tracker.findAll();
        boolean rst = false;
        for (int i = 0; i < item.length; i++) {
            if (item[i].getId().equals(id)) {
                rst = true;
                this.tracker.findById(id);
                System.out.println(" ����������� ������ ");
                System.out.println(" ��� ������ : " + item[i].getName());
                System.out.println(" �������� ������ : " + item[i].getDescription());
                System.out.println(" ID ������ : " + item[i].getId());
            }
        }
        if (rst == false) {
            System.out.println(" ������ � ����� ID �� �������");
        }
    }

    /**
     * ����� ��������� ����� ������ �� �����.
     */
    private void findnameItem() {
        System.out.println("------------ ����� ������ �� ����� --------------");
        String name = this.input.ask("������� ��� ������");
        Item[] item = this.tracker.findAll();
        boolean rst = false;
        for (int i = 0; i < item.length; i++) {
            if (item[i].getName().equals(name)) {
                rst = true;
                this.tracker.findByName(name);
                System.out.println(" ����������� ������ ");
                System.out.println(" ��� ������ : " + item[i].getName());
                System.out.println(" �������� ������ : " + item[i].getDescription());
                System.out.println(" ID ������ : " + item[i].getId());
            }
        }
        if (rst == false) {
            System.out.println(" ������ � ����� ������ �� �������");
        }
    }

    /**
     * ����� ��������� ����� ����.
     */
    private void showMenu() {
        System.out.println("����.");
        System.out.println("0 - �������� ������.");
        System.out.println("1 - �������� ��� ������.");
        System.out.println("2 - �������� ������.");
        System.out.println("3 - ������� ������.");
        System.out.println("4 - ����� ������ �� ID.");
        System.out.println("5 - ����� ������ �� �����.");
        System.out.println("6 - ����� �� ���������.");

    }

    /**
     * ������ ���������.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}