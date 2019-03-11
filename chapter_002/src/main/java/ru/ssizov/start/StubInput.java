package ru.ssizov.start;

import java.util.List;

public class StubInput implements Input {
    /**
     * Ёто поле содержит последовательность ответов пользовател€.
     * Ќапример. ≈сли пользователь
     * хочет выбрать добавление новой за€вки ему нужно ввести:
     * 0 - выбор пункта мен€ "добавить новую за€вку".
     * name - им€ за€вки
     * desc - описание за€вки
     * y - выйти из трекера.
     */
    private final String[] value;

    /**
     * ѕоле считает количество вызовом метода ask.
     * ѕри каждом вызове надо передвинуть указатель на новое число.
     */
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * ƒавайте рассмотрим, как работает этот метод.
     * у нас есть объект в котором содержатс€ заранее продуманные ответы.
     * ѕри последовательном вызове метода ask нам надо возвращать соответствующие данные.
     *  ак если бы мы симулировали поведение пользовател€.
     * ƒл€ этого при каждом вызове метода ask мы увеличиваем счетчик и
     * при следующем вызове он вернет нам новое значение.
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    public int ask(String question, List<Integer> range) {
        //  throw new UnsupportedOperationException("Ќе поддерживаемый символ");
        return -1;
    }
}