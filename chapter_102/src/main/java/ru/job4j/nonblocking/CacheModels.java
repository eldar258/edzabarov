package ru.job4j.nonblocking;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Class ru.job4j.nonblocking.
 *
 * @author edzabarov
 * @since 03.04.2018
 */
public class CacheModels {
    private ConcurrentHashMap<Integer, Base> cache = new ConcurrentHashMap<>();

    public Base add(Base model) {
        cache.put(model.getId(), model);
        return model;
    }


    public boolean update(Base model) {
        boolean result = true;
        try {
            result = cache.computeIfPresent(model.getId(), (k, v) -> {
                if (v.getVersion() == model.getVersion()) {
                    model.setVersion(v.getVersion() + 1);
                } else throw new OptimisticException();
                return model;
            }) != null;
        } catch (OptimisticException ex) {
            ex.printStackTrace();
            System.out.println("The data is outdated");
            result = false;
        }
        return result;
    }

    public boolean delete(Base model) {
        return cache.remove(model.getId()) != null;
    }

    public Base get(int key) {
        return cache.get(key);
    }

    public class OptimisticException extends RuntimeException {

    }
}
