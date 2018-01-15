package com.example.apoorva.android_it;

/**
 * Created by Apoorva on 1/15/2018.
 */

public class StudentClass extends UserClass{
    String standard;
    String achievements;
    public StudentClass()
    {}
    public StudentClass(boolean option,String name,String std,String ach)
    {
        super(option, name);
        this.standard = std;
        this.achievements = ach;
    }
    //Getter and setter methods of teacher class
    public void setStandard(String standard)
    {
        this.standard = standard;
    }
    public void setAchievements(String achievements)
    {
        this.achievements = achievements;
    }
    public String getStandard()
    {
        return this.standard;
    }
    public String getAchievements()
    {
        return this.achievements;
    }
}
