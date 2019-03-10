package ru.ssizov.tracker;

import ru.ssizov.start.*;

public class ExitProgram implements UserAction {

    public ExitProgram(int i, String exit_program) {
    }

    @Override
    public int key() {
        return 6;
    }

    @Override
    public void execute(Input input, Tracker tracker) {

    }

    @Override
    public String info() {
        return "6 - Выход из программы.";
    }
}
