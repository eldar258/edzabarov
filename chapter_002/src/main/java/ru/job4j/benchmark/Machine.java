package ru.job4j.benchmark;

/**
 * Class Money changer.
 *
 * @author edzabarov
 * @since 26.08.2017
 */
public class Machine {
    /**
     * Various coins.
     */
    private int[] coins;
    /**
     * Entrance banknote.
     */
    private int entranceBanknote;

    /**
     * construction Machine.
     */
    public Machine() {
        this.coins = new int[] {1, 5, 10};
    }
    /**
     * set Entrance banknote.
     * @param entranceBanknote -
     */
    public void setEntranceBanknote(int entranceBanknote) {
        this.entranceBanknote = entranceBanknote;
    }
    /**
     * Show variants change money.
     * @return change.
     */
    public String variantsChange() {
        StringBuilder sb = new StringBuilder();
        int[] number = {this.entranceBanknote, 0, 0};
        sb.append(String.format("Number of coins of denomination: one - %d,five - %d,ten - %d\n", number[0], number[1], number[2]));
        for (int i = 1; i < number.length; i++) {
            while (number[i - 1] * this.coins[i - 1] >= this.coins[i]) {
                number[i - 1] -= this.coins[i] / this.coins[i - 1];
                number[i]++;
                sb.append(String.format("Number of coins of denomination: one - %d,five - %d,ten - %d\n", number[0], number[1], number[2]));
            }
        }
        for (int i = number.length - 2; i > 0 && number[number.length - 1] > 0; i--) {
            while (number[i] > 0) {
                number[i]--;
                number[i - 1] += this.coins[i] / this.coins[i - 1];
                sb.append(String.format("Number of coins of denomination: one - %d,five - %d,ten - %d\n", number[0], number[1], number[2]));
            }
        }
        return sb.toString();
    }
}
