package ru.job4j.benchmark;

/**
 * Class ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 20.06.2018
 */
public class MyString {
    private StringBuffer buffer;

    public MyString() {
        this.buffer = new StringBuffer();
    }

    public void putValue(int val) {
        buffer.append(val);
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}
