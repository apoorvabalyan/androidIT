package com.example.apoorva.android_it;

/**
 * Created by Apoorva on 1/15/2018.
 */

public class UserClass {
    //Variables to maintain information about the user
    protected boolean studentOrTeacher;
    protected String name;

    public UserClass(){
    }
    public UserClass(boolean option, String name)
    {
        this.studentOrTeacher = option;
        this.name = name;
    }
    //Getter and setter methods to access the variables value
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setOption(boolean option)
    {
        this.studentOrTeacher = option;
    }
    public boolean getOption()
    {
        return this.studentOrTeacher;
    }

}
