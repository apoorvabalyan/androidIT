package com.example.apoorva.android_it;

/**
 * Created by Apoorva on 1/15/2018.
 */

public class TeacherClass extends UserClass {
    //Variables to set the information about the Teacher
    String qualifications;
    String experience;
    String name;
    String email;
    String contactNumber;
    Double teacherLang;
    Double teacherLat;
    public TeacherClass()
    {}
    public TeacherClass(String name,String email)
    {
        this.email = email;
        this.name= name;
    }
    //Getter and setter methods of teacher class
    public String getName(){return name;}
    public String getEmail(){return email;}
    public void setQualifications(String qualifications)
    {
        this.qualifications = qualifications;
    }
    public void setExperience(String experience)
    {
        this.experience = experience;
    }
    public  void setContactNumber(String contactNumber)
    {
        this.contactNumber = contactNumber;
    }
    public String getQualifications()
    {
        return this.qualifications;
    }
    public String getExperience()
    {
        return this.experience;
    }
    public String getContactNumber()
    {
        return this.contactNumber;
    }
}
