package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 *
 * @author edzabarov
 * @since 05.08.2017
 */
public class TrackerTest {
    /**
     * test add.
     */
    @Test
    public void whenAddNewItemThenItemAddInTracker() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        assertThat(tracker.add(item), is(item));
    }
    /**
     * test getAll.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }
    /**
     * test findByName.
     */
    @Test
    public void whenAddNewItemThenTrackerFindByNameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(((ArrayList<Item>) tracker.findByName("test1")).get(0), is(item));
    }
    /**
     * test update.
     */
    @Test
    public void whenAddNewItemThenTrackerUpdateNewItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item result = new Item("result", "resultDesc", 321L);
        result.setId(tracker.add(item).getId());
        tracker.update(result);
        assertThat(tracker.getAll().get(0), is(result));
    }
    /**
     * test delete.
     */
    @Test
    public void whenAddNewThreeItemsAndDeleteOneItemThenTrackerHasSameTwoItems() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item item1 = new Item("test2", "testDescription", 123L);
        Item item2 = new Item("test3", "testDescription", 123L);
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        List<Item> result = new ArrayList<>();
        result.add(item);
        result.add(item2);
        tracker.delete(item1);
        assertThat(tracker.getAll(), is(result));
    }
    /**
     * test findById.
     */
    @Test
    public void whenAddNewItemThenTrackerFindFindByIdItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item item1 = new Item("test2", "testDescription", 123L);
        Item item2 = new Item("test3", "testDescription", 123L);
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findById(item1.getId()), is(item1));
    }
}
