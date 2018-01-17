package com.example.apoorva.android_it;

/**
 * Created by Apoorva on 1/15/2018.
 */

public class TeacherClass extends UserClass {
    //Variables to set the information about the Teacher
    String qualifications;
    String experience;
    boolean flag;
    String contactNumber;
    public TeacherClass()
    {}
    public TeacherClass(String q,String exp,String contact,boolean f)
    {
        this.flag = f;
        this.qualifications = q;
        this.experience = exp;
        this.contactNumber = contact;
    }
    //Getter and setter methods of teacher class
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
