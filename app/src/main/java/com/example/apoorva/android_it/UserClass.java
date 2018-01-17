package com.example.apoorva.android_it;

/**
 * Created by Apoorva on 1/15/2018.
 */

public class UserClass {
    //Variables to maintain information about the user
    protected String name;
    protected String email;
    public UserClass(){
    }
    public UserClass( String name,String email)
    {
        this.email = email;
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
}
