package ru.job4j.benchmark2;

/**
 * Class ru.job4j.benchmark2.
 *
 * @author edzabarov
 * @since 18.02.2018
 */
public class MyInteger {
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void iterate() {
        value++;
    }
    public void sumNumValue(int num) {
        value += num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyInteger myInteger = (MyInteger) o;

        return value == myInteger.value;

    }

    @Override
    public int hashCode() {
        return value;
    }
}
