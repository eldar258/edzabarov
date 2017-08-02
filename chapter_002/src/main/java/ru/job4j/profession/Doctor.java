package ru.job4j.profession;

/**
 *Class Doctor.
 *@author edzabarov
 *@since 02.08.2017
 */
public class Doctor extends Profession {
    /**
     * Doctor.
     *@param name - name
     *@param experience - experience
     */
    public Doctor(String name, long experience) {
        super(true, name, "Doctor", experience);
    }
    /**
     * comb. heal
     * @param patient - patient
     */
    public void heal(Profession patient) {
        //...
    }
}
