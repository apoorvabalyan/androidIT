package com.example.apoorva.android_it;

/**
 * Created by Apoorva on 1/15/2018.
 */

public class StudentClass extends UserClass{
    private String standard;
    private String achievements;
    String name;
    String email;
    Double studentLang;
    Double studentLat;
    public StudentClass()
    {}
    public StudentClass(String name,String email)
    {
        this.name = name;
        this.email = email;
    }
    //Getter and setter methods of teacher class
    public String getName(){return name;}
    public String getEmail(){return email;}
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
