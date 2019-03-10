package ru.ssizov.start;

import ru.ssizov.models.Item;

import java.util.Arrays;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализующий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описания, для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());    //из библиотеки util
    }

    /**
     * Метод заменяет ячейку в массиве this.items.
     * Возвращает boolean результат.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаляет ячейку в массиве this.items.
     *
     * @return boolean результат.
     */
    public boolean delete(String id) {
        boolean check = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.items.length - 1 - i);
                position--;
                check = true;
                break;
            }
        }
        return check;
    }

    /**
     * Метод возвращает копию массива this.items без null элементов.
     */
    public Item[] findAll() {
        Item[] rst = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            rst[i] = this.items[i];
        }
        return Arrays.copyOf(rst, this.position);
    }

    /**
     * Метод получения списка по имени.
     *++++++++
     *
     * @param key ключ по которому будем искать.
     * @return массив со списком собранный по имени.
     */
    public Item[] findByName(String key) {
        Item[] temp = new Item[this.position];
        int count = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                temp[count++] = item;
            }
        }
        Item[] rst = Arrays.copyOf(temp, count);
        return rst;
    }

    /**
     * Метод сравнивает id с аргументом String id.
     * Возвращает найденный item.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}