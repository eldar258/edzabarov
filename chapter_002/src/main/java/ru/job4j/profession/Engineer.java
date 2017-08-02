package ru.job4j.profession;

/**
 *Class Engineer.
 *@author edzabarov
 *@since 02.08.2017
 */
public class Engineer extends Profession {
    /**
     * Engineer.
     *@param name - name
     *@param experience - experience
     */
    public Engineer(String name, long experience) {
        super(true, name, "Engineer", experience);
    }
    /**
     * calculations.
     *@param inputData - inputData
     */
    public void calculations(String inputData) {
        //...
    }
}
