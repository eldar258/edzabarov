package ru.job4j.generic;

/**
 * Class abstract store.
 *
 * @author edzabarov
 * @since 05.10.2017
 */
public abstract class AbstractStore implements Store<Base> {
    /**
      * simpleArray.
      */
  private SimpleArray<Base> simpleArray;

    /**
     * Constructor.
     */
    public AbstractStore() {
        simpleArray = new SimpleArray<>();
    }
    @Override
    public Base add(Base value) {
        return simpleArray.add(value);
    }
    @Override
    public Base update(Base value) {
        return simpleArray.update(value);
    }
    @Override
    public boolean delete(Base value) {
        return simpleArray.delete(value);
    }
}
