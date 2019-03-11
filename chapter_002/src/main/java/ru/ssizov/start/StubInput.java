package ru.ssizov.start;

import java.util.List;

public class StubInput implements Input {
    /**
     * ��� ���� �������� ������������������ ������� ������������.
     * ��������. ���� ������������
     * ����� ������� ���������� ����� ������ ��� ����� ������:
     * 0 - ����� ������ ���� "�������� ����� ������".
     * name - ��� ������
     * desc - �������� ������
     * y - ����� �� �������.
     */
    private final String[] value;

    /**
     * ���� ������� ���������� ������� ������ ask.
     * ��� ������ ������ ���� ����������� ��������� �� ����� �����.
     */
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * ������� ����������, ��� �������� ���� �����.
     * � ��� ���� ������ � ������� ���������� ������� ����������� ������.
     * ��� ���������������� ������ ������ ask ��� ���� ���������� ��������������� ������.
     * ��� ���� �� �� ������������ ��������� ������������.
     * ��� ����� ��� ������ ������ ������ ask �� ����������� ������� �
     * ��� ��������� ������ �� ������ ��� ����� ��������.
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    public int ask(String question, List<Integer> range) {
        //  throw new UnsupportedOperationException("�� �������������� ������");
        return -1;
    }
}