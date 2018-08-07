package ru.job4j.httpprotocol;

import java.util.List;

/**
 * Class ru.job4j.httpprotocol.
 *
 * @author edzabarov
 * @since 28.07.2018
 */
public interface Store<T> {
    boolean add(User user);
    boolean delete(int id);
    boolean update(int id, String name, String role);
    List<T> findAll();
    T findById(int id);
    String findRoleByLoginPassword(String login, String password);
}
