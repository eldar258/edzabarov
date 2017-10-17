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
     * @param value -
     * @return - updated value.
     */
    public T update(T value) {
        if (value != null) {
            int index = indexOf(value);
            if (index != -1) {
                array[index] = value;
            }
        }
        return value;
    }
    /**
     * delete value.
     * @param value -
     * @return -
     */
    public boolean delete(T value) {
        boolean result = false;
        if (value != null) {
            int index = indexOf(value);
            if (index != -1) {
                result = true;
                T[] tempArray = (T[]) new Object[array.length];
                System.arraycopy(array, 0, tempArray, 0, index);
                System.arraycopy(array, index + 1, tempArray, index + 1, count);
                array = tempArray;
            }
        }
        return result;
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
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, count));
        }
    }

    /**
     * return index.
     * @param search -
     * @return -
     */
    private int indexOf(T search) {
        for (int i = 0; i < count; i++) {
            if (array[i] != null && array[i].hashCode() == search.hashCode() && array[i].equals(search)) {
                return i;
            }
        }
        return -1;
    }
}
