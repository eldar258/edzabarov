package ru.job4j.benchmark;

import org.junit.Test;

//import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;
/**
 * Class Test Machine.
 *
 * @author edzabarov
 * @since 27.08.2017
 */
public class MachineTest {
    /**
     * test 17.
     */
    @Test
    public void whenEnter27ThenMachineReturn9Variant() {
        Machine machine = new Machine();
        machine.setEntranceBanknote(27);
        StringBuilder sb = new StringBuilder();
        sb.append("Number of coins of denomination: one - 27,five - 0,ten - 0\n");
        sb.append("Number of coins of denomination: one - 17,five - 2,ten - 0\n");
        sb.append("Number of coins of denomination: one - 7,five - 4,ten - 0\n");
        sb.append("Number of coins of denomination: one - 2,five - 5,ten - 0\n");
        sb.append("Number of coins of denomination: one - 2,five - 1,ten - 2\n");
        sb.append("Number of coins of denomination: one - 7,five - 0,ten - 2\n");
        sb.append("Number of coins of denomination: one - 2,five - 3,ten - 1\n");
        sb.append("Number of coins of denomination: one - 22,five - 1,ten - 0\n");
        sb.append("Number of coins of denomination: one - 12,five - 3,ten - 0\n");
        String[] result = sb.toString().split("\n");
        String[] expected = machine.variantsChange().split("\n");
        assertThat(result, arrayContainingInAnyOrder(expected));
    }
    /**
     * test 17.
     */
    @Test
    public void whenEnter2ThenMachineReturn1Variant() {
        Machine machine = new Machine();
        machine.setEntranceBanknote(2);
        StringBuilder sb = new StringBuilder();
        sb.append("Number of coins of denomination: one - 2,five - 0,ten - 0\n");
        String[] result = sb.toString().split("\n");
        String[] expected = machine.variantsChange().split("\n");
        assertThat(result, arrayContainingInAnyOrder(expected));
    }
    /**
     * test 17.
     */
    @Test
    public void whenEnter5ThenMachineReturn2Variant() {
        Machine machine = new Machine();
        machine.setEntranceBanknote(5);
        StringBuilder sb = new StringBuilder();
        sb.append("Number of coins of denomination: one - 0,five - 1,ten - 0\n");
        sb.append("Number of coins of denomination: one - 5,five - 0,ten - 0\n");
        String[] result = sb.toString().split("\n");
        String[] expected = machine.variantsChange().split("\n");
        assertThat(result, arrayContainingInAnyOrder(expected));
    }
}
