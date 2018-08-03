package ru.job4j.httpprotocol;

import ru.job4j.jsp.DBStore;

import java.util.List;

/**
 * Class ru.job4j.httpprotocol.
 *
 * @author edzabarov
 * @since 28.07.2018
 */
public class ValidateService {
    private static ValidateService instance;

    private Store<User> store;

    private ValidateService() {
        this.store = DBStore.getInstance();
    }

    public static ValidateService getInstance() {
        if (instance == null) {
            synchronized (ValidateService.class) {
                if (instance == null) {
                    instance = new ValidateService();
                }
            }
        }
        return instance;
    }

    public boolean add(String userName) {
        return userName != null && !userName.trim().isEmpty()
                && this.store.add(new User(userName));
    }

    public boolean update(int id, String name) {
        return name != null && !name.trim().isEmpty() && this.store.update(id, name);
    }

    public boolean delete(int id) {
        return this.store.delete(id);
    }

    public List<User> findAll() {
        return this.store.findAll();
    }

    public User findById(int id) {
        return this.store.findById(id);
    }
}
