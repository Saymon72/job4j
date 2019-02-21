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
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт Меню : ");
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
                System.out.println("ПРОГРАММА ЗАВЕРШЕНА");
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void addItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String description = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, description);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует вывод всех заявок из хранилища.
     */
    private void showAllItem() {
        System.out.println("------------ Вывод всех заявок --------------");
        Item[] item = this.tracker.findAll();
        int count = 0;
        if (item != null) {
            for (int i = 0; i < item.length; i++) {
                count++;
                System.out.println("Заявка № : " + count);
                System.out.println(" Имя заявкм : " + item[i].getName());
                System.out.println(" Описание заявки : " + item[i].getDescription());
                System.out.println(" ID заявкм : " + item[i].getId());
            }
            System.out.println("Заявок нет");
        }
    }

    /**
     * Метод реализует изменение заявки.
     */
    private void editItem() {
        System.out.println(" -------- Редактирование заявки -------- ");
        String id = this.input.ask(" Введи ID заявки: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println(" Заявка с именем " + item.getId() + " будет изменена! ");
            String name = this.input.ask(" Введите имя новой заявки: ");
            String description = this.input.ask(" Введите описание новой заявки: ");
            Item newItem = new Item(name, description);
            newItem.setId(item.getId());
            this.tracker.replace(id, newItem);
            System.out.println(" Заявка с  ID  изменена");
        } else {
            System.out.println(" Заявка с таким ID не найдена");
        }
    }

    /**
     * Метод реализует удаление заявки.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ID заявки");
        Item[] item = this.tracker.findAll();
        boolean rst = false;
        for (int i = 0; i < item.length; i++) {
            if (item[i].getId().equals(id)) {
                rst = true;
                this.tracker.delete(id);
                System.out.println("Заявка удалена");
            }
        }
        if (rst == false) {
            System.out.println(" Заявка с таким ID не найдена");
        }
    }

    /**
     * Метод реализует поиск заявки по Id.
     */
    private void findidItem() {
        System.out.println("------------ Поиск заявки по Id --------------");
        String id = this.input.ask("Введите ID заявки");
        Item[] item = this.tracker.findAll();
        boolean rst = false;
        for (int i = 0; i < item.length; i++) {
            if (item[i].getId().equals(id)) {
                rst = true;
                this.tracker.findById(id);
                System.out.println(" Запрошенная заявка ");
                System.out.println(" Имя заявкм : " + item[i].getName());
                System.out.println(" Описание заявки : " + item[i].getDescription());
                System.out.println(" ID заявкм : " + item[i].getId());
            }
        }
        if (rst == false) {
            System.out.println(" Заявка с таким ID не найдена");
        }
    }

    /**
     * Метод реализует поиск заявки по имени.
     */
    private void findnameItem() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите Имя заявки");
        Item[] item = this.tracker.findAll();
        boolean rst = false;
        for (int i = 0; i < item.length; i++) {
            if (item[i].getName().equals(name)) {
                rst = true;
                this.tracker.findByName(name);
                System.out.println(" Запрошенная заявка ");
                System.out.println(" Имя заявкм : " + item[i].getName());
                System.out.println(" Описание заявки : " + item[i].getDescription());
                System.out.println(" ID заявкм : " + item[i].getId());
            }
        }
        if (rst == false) {
            System.out.println(" Заявка с таким именем не найдена");
        }
    }

    /**
     * Метод реализует вывод Меню.
     */
    private void showMenu() {
        System.out.println("МЕНЮ.");
        System.out.println("0 - ДОБАВИТЬ ЗАЯВКУ.");
        System.out.println("1 - ПОКАЗАТЬ ВСЕ ЗАЯВКИ.");
        System.out.println("2 - ИЗМЕНИТЬ ЗАЯВКУ.");
        System.out.println("3 - УДАЛИТЬ ЗАЯВКУ.");
        System.out.println("4 - НАЙТИ ЗАЯВКУ ПО ID.");
        System.out.println("5 - НАЙТИ ЗАЯВКУ ПО ИМЕНИ.");
        System.out.println("6 - ВЫХОД ИЗ ПРОГРАММЫ.");

    }

    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}