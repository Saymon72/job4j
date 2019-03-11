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
                //moe.printStackTrace(); //������� ���� ������, ��������� ��� ���� ������ ����������.
                System.out.println("�������� ����� ���� �� ������������ ��������:");
            } catch (NumberFormatException nfe) {
                System.out.println("������� ���������� ������ ��������:");
            }
        } while (invalid);
        return value;
    }
}
