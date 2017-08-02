package ru.job4j.profession;

/**
 *Class Teacher.
 *@author edzabarov
 *@since 02.08.2017
 */
public class Teacher extends Profession {
    /**
     * Teacher.
     *@param name - name
     *@param experience - experience
     */
    public Teacher(String name, long experience) {
        super(true, name, "Teacher", experience);
    }
    /**
     * teach.
     *@return String
     */
    public String teach() {
        return "Hello, my name is " + getName() + ". I'm your teacher.";
    }
}