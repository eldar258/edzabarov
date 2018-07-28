package ru.job4j.httpprotocol;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class ru.job4j.httpprotocol.
 *
 * @author edzabarov
 * @since 28.07.2018
 */
public class MemoryStore implements Store<User> {
    private static volatile MemoryStore instance;

    private Map<Integer, User> data;

    private MemoryStore() {
        data = new ConcurrentHashMap<>();
    }

    public static MemoryStore getInstance() {
        if (instance == null) {
            synchronized (MemoryStore.class) {
                if (instance == null) {
                    instance = new MemoryStore();
                }
            }
        }
        return instance;
    }

    @Override
    public boolean add(User user) {
        return this.data.putIfAbsent(user.hashCode(), user) == null;
    }

    @Override
    public boolean delete(int id) {
        return this.data.remove(id) != null;
    }

    @Override
    public boolean update(int id, String name) {
        return this.data.computeIfPresent(id, (k, v) -> new User(name)) != null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(this.data.values());
    }

    @Override
    public User findById(int id) {
        return this.data.get(id);
    }
}
