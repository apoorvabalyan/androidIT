package com.example.apoorva.android_it;

/**
 * Created by Apoorva on 1/15/2018.
 */

public class UserClass {
    //Variables to maintain information about the user
    private String id;
    private String name;
    private String email;
    public UserClass(){
    }
    public UserClass( String id,String name,String email)
    {
        this.id = id;
        this.email = email;
        this.name = name;
    }
    public void setName(String a)
    {
        this.name  = a;
    }
    public void setEmail(String a)
    {
        this.email = a;
    }
    public String getName()
    {
        return name;
    }
    public String getId()
    {
        return id;
    }
}
