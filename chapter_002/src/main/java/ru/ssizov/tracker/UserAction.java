package ru.ssizov.tracker;

import ru.ssizov.start.*;

public interface UserAction {

    int key();

    void execute(Input input, Tracker tracker);

    String info();
}
