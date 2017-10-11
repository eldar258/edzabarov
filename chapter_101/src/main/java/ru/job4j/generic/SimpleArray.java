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
    private T[] array;
    /**
     * count for adding.
     */
    private int count = 0;

    /**
     * constructor.
     * @param size - base size to array.
     */
    public SimpleArray(int size) {
        this.array = (T[]) new Object[size];
    }
    /**
     * constructor.
     */
    public SimpleArray() {
        this(16);
    }

    /**
     * add value in array.
     * @param value -
     * @return value.
     */
    public T add(T value) {
        if (count == array.length) {
            T[] arrayCopy = (T[]) new Object[(int) (array.length * 1.7)];
            System.arraycopy(array, 0, arrayCopy, 0, array.length);
            array = arrayCopy;
        }
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
        rangeCheck(index);
        T oldValue = array[index];
        array[index] = value;
        return oldValue;
    }
    /**
     * delete value.
     * @param index -
     */
    public void delete(int index) {
        rangeCheck(index);
        array[index] = null;
    }
    /**
     * get value.
     * @param index -
     * @return -
     */
    public T get(int index) {
        rangeCheck(index);
        return array[index];
    }

    /**
     * Checks if the given index is in range.
     * @param index -
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, array.length));
        }
    }
}
