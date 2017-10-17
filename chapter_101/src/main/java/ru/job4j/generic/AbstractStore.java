package ru.job4j.generic;

/**
 * Class abstract store.
 *
 * @author edzabarov
 * @since 05.10.2017
 * @param <T> - Generic.
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    /**
      * simpleArray.
      */
  private SimpleArray<T> simpleArray;

    /**
     * Constructor.
     */
    public AbstractStore() {
        simpleArray = new SimpleArray<>();
    }
    @Override
    public T add(T value) {
        return simpleArray.add(value);
    }
    @Override
    public T update(T value) {
        return simpleArray.update(value);
    }
    @Override
    public boolean delete(T value) {
        return simpleArray.delete(value);
    }
}
