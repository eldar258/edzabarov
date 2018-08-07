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

    public boolean add(String userName, String password, String role) {
        return userName != null && !userName.trim().isEmpty() && password != null && !password.trim().isEmpty()
                && this.store.add(new User(userName, password, role));
    }

    public boolean update(int id, String name, String role) {
        return name != null && !name.trim().isEmpty() && this.store.update(id, name, role);
    }

    public boolean delete(int id) {
        return this.store.delete(id);
    }

    public List<User> findAll() {
        return this.store.findAll();
    }

    public String findRoleByLoginPassword(String login, String password) {
        return this.store.findRoleByLoginPassword(login, password);
    }

    public User findById(int id) {
        return this.store.findById(id);
    }
}
