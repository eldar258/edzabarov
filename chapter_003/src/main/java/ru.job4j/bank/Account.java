package ru.job4j.bank;

/**
 * Class ru.ru.job4j.bank.
 *
 * @author edzabarov
 * @since 14.09.2017
 */
public class Account {
    /**
     * money on the account.
     */
    private double value;
    /**
     * Account number.
     */
    private long requisites;

    /**
     * Constructor.
     * @param value -
     * @param requisites -
     */
    public Account(double value, long requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * equals.
     * @param o -
     * @return -
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return requisites == account.requisites;

    }

    /**
     * hashCode.
     * @return -
     */
    @Override
    public int hashCode() {
        return (int) (requisites ^ (requisites >>> 32));
    }

    /**
     * get value.
     * @return -
     */
    public double getValue() {
        return value;
    }

    /**
     * get requisites.
     * @return -
     */
    public long getRequisites() {
        return requisites;
    }

    /**
     * changeValue.
     * @param amount -
     *               sum value and amount.
     */
    public void changeValue(double amount) {
        this.value += amount;
    }
}
