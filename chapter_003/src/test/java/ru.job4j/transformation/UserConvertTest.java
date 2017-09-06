package ru.job4j.transformation;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class UserConvertTest.
 *
 * @author edzabarov
 * @since 06.09.2017
 */
public class UserConvertTest {
    /**
     * test convert.
     */
    @Test
    public void whenListConvertHashMapThenConvertedToHashMap() {
        HashMap<Integer, User> result = new HashMap<>();
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            User user = new User();
            user.setName("u" + i);
            user.setId(i);
            user.setCity("s" + i);
            result.put(i, user);

            User us = new User();
            us.setName("u" + i);
            us.setId(i);
            us.setCity("s" + i);
            list.add(us);
        }
        assertThat(result, is(new UserConvert().process(list)));
    }
    /**
     * test null.
     */
    @Test
    public void whenNullConvertHashMapThenConvertedToHashMap() {
        HashMap<Integer, User> result = null;
        List<User> list = null;
        assertThat(result, is(new UserConvert().process(list)));
    }
    /**
     * test empty.
     */
    @Test
    public void whenEmptyListConvertHashMapThenConvertedToHashMap() {
        HashMap<Integer, User> result = new HashMap<>();
        List<User> list = new ArrayList<>();
        assertThat(result, is(new UserConvert().process(list)));
    }
}
