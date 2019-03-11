package ru.ssizov.start;

import java.util.List;

public class ValidateInput extends ConsoleInput {
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                //moe.printStackTrace(); //выводит нашу ошибку, продолжая при этом работу приложения.
                System.out.println("Выберите пункт меню из существующих значений:");
            } catch (NumberFormatException nfe) {
                System.out.println("Введите корректные данные повторно:");
            }
        } while (invalid);
        return value;
    }
}
