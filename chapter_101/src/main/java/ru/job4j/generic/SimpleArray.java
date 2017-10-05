package ru.job4j.generic;

/**
 * Class SimpleArray.
 *
 * @author edzabarov
 * @since 05.10.2017
 * @param <T> - Generic.
 */
public class SimpleArray<T> {
    /**
     * array.
     */
    private Object[] array;
    /**
     * count for adding.
     */
    private int count = 0;

    /**
     * constructor.
     * @param size - base size to array.
     */
    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * add value in array.
     * @param value -
     * @return value.
     */
    public T add(T value) {
        array[count++] = value;
        return value;
    }

    /**
     * update value in array.
     * @param index -
     * @param value -
     * @return - updated value.
     */
    public T update(int index, T value) {
        array[index] = value;
        return value;
    }
    /**
     * delete value.
     * @param index -
     */
    public void delete(int index) {
        array[index] = null;
    }
    /**
     * get value.
     * @param index -
     * @return -
     */
    public T get(int index) {
        return (T) array[index];
    }
}
