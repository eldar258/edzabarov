package ru.job4j.profession;

/**
 *Class Profession.
 *@author edzabarov
 *@since 02.08.2017
 */
public class Profession {
    /**
     * diploma.
     */
    private boolean diploma;
    /**
     * name.
     */
    private String name;
    /**
     * professionName.
     */
    private String professionName;
    /**
     * experience.
     */
    private long experience;

    /**
     * Profession.
     *@param diploma - diplom
     *@param name - name
     *@param professionName - professionName
     *@param experience - experience
     */
    public Profession(boolean diploma, String name, String professionName, long experience) {
        this.diploma = diploma;
        this.name = name;
        this.professionName = professionName;
        this.experience = experience;
    }
    /**
     * getName.
     *@return  name - name
     */
    public String getName() {
        return this.name;
    }
    /**
     * getProfessionName.
     *@return  ProfessionName - ProfessionName
     */
    public String getProfessionName() {
        return this.professionName;
    }
    /**
     * isDiploma.
     *@return  diploma - diploma
     */
    public boolean isDiploma() {
        return this.diploma;
    }
    /**
     * getExperience.
     *@return  Experience - Experience
     */
    public long getExperience() {
        return this.experience;
    }

}
