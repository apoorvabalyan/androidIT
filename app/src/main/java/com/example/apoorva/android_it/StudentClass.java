package com.example.apoorva.android_it;

/**
 * Created by Apoorva on 1/15/2018.
 */

public class StudentClass extends UserClass{
    String standard;
    String achievements;
    boolean flag;
    public StudentClass()
    {}
    public StudentClass(String std,String ach,boolean f)
    {
        this.standard = std;
        this.achievements = ach;
        this.flag = f;
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
