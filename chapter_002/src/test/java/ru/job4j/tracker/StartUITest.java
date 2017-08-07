package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class Test.
 *
 * @author edzabarov
 * @since 07.08.2017
 */
public class StartUITest {
    /**
     * test add().
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).start();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }
    /**
     * test editItem().
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"2", "test name", "desc", item.getId(), "6"});
        new StartUI(input, tracker).start();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }
    /**
     * test delete.
     */
    @Test
    public void whenDeleteThenTrackerHasDeletedItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test name1", "desc", 123L);
        tracker.add(item);
        Input input = new StubInput(new String[]{"0", "test name2", "desc2", "3", item.getId(), "6"});
        new StartUI(input, tracker).start();
        assertThat(tracker.getAll()[0].getName(), is("test name2"));
    }
    /**
     * test 3 add().
     */
    @Test
    public void whenAddThreeItemsTrackerHasNewItemsWithSameThreeNames() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name1", "desc1",
                "0", "test name2", "desc2",
                "0", "test name3", "desc3", "6"});
        new StartUI(input, tracker).start();
        Item[] items = tracker.getAll();
        assertThat(new String[]{items[0].getName(), items[1].getName(), items[2].getName()},
                is(new String[]{"test name1", "test name2", "test name3"}));
    }
}
