package ru.job4j.monitore;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class ru.job4j.monitore.
 *
 * @author edzabarov
 * @since 26.02.2018
 */
public class UserStoreTest {

    UserStore userStore = new UserStore();
    User user1 = new User(1, 20000000);
    User user2 = new User(2, 20000000);

    private class UserStoreTestThread implements Runnable {

        @Override
        public void run() {
            userStore.transfer(1, 2, 50);
            userStore.transfer(4, 2, 50); //no
            userStore.transfer(1, 2, 50);
            userStore.transfer(10, 20, 50); //no
            userStore.transfer(1, 2, 50);
            userStore.transfer(2, 1, 100);
            userStore.transfer(2, 1, 200);
        }
    }

    @Test
    public void whenUserStoreUseOneThreadThenOperationsCorrect() {
        userStore.add(user1);
        userStore.add(user2);

        userStore.transfer(1, 2, 50);
        userStore.transfer(4, 2, 50); //no
        userStore.transfer(1, 2, 50);
        userStore.transfer(10, 20, 50); //no
        userStore.transfer(1, 2, 50);
        userStore.transfer(2, 1, 100);
        userStore.transfer(2, 1, 200); // user1 -150, user2 +150 = 300

        int expected = user1.getAmount() - user2.getAmount();
        int result = 300;
        assertThat(expected, is(result));
    }

    @Test
    public void whenUserStoreUseTwoThreadThenOperationsCorrect() throws InterruptedException {
        userStore.add(user1);
        userStore.add(user2);

        Thread thread1 = new Thread(new UserStoreTestThread());
        Thread thread2 = new Thread(new UserStoreTestThread());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        int expected = user1.getAmount() - user2.getAmount();
        int result = 300 * 2;
        assertThat(expected, is(result));
    }

    @Test
    public void whenUserStoreUseMuchThreadThenOperationsCorrect() throws InterruptedException {
        userStore.add(user1);
        userStore.add(user2);

        List<Thread> list = new ArrayList<>();
        int num = 10000;
        for (int i = 0; i < num; i++) {
            list.add(new Thread(new UserStoreTestThread()));
            list.get(i).start();
        }
        for (Thread el : list) {
            el.join();
        }
        int expected = user1.getAmount() - user2.getAmount();
        int result = 300 * num;
        assertThat(expected, is(result));
    }
}