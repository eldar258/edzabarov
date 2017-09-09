package ru.job4j.sortset;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SortUserTest.
 *
 * @author edzabarov
 * @since 09.09.2017
 */
public class SortUserTest {
    /**
     * test sort.
     */
    @Test
    public void whenListSortThenReturnSortedSet() {
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(new User("test1", 20), new User("test2", 5), new User("test3", 25)));
        User[] expected = new SortUser().sort(users).toArray(new User[0]);
        User[] result = {new User("test2", 5), new User("test1", 20), new User("test3", 25)};
        assertThat(result, is(expected));
    }
    /**
     * test null.
     */
    @Test
    public void whenListIsNullSortThenReturnNull() {
        List<User> users = null;
        Set<User> result = null;
        Set<User> expected = new SortUser().sort(users);
        assertThat(result, is(expected));
    }
}
