package ru.job4j.transformation;

import java.util.HashMap;
import java.util.List;

/**
 * Class UserConvert.
 *
 * @author edzabarov
 * @since 06.09.2017
 */
public class UserConvert {
    /**
     * convert.
     * @param list -
     * @return HashMap.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hashMap = null;
        if (list != null) {
            hashMap = new HashMap<>();
            for (User user : list) {
                hashMap.put(user.getId(), user);
            }
        }
        return hashMap;
    }
}
