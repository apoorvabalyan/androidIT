package com.example.apoorva.android_it;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Teacher_profile extends AppCompatActivity {
    private boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);
        if(!flag)
            open();
    }
    public void open()
    {
        flag = true;
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setMessage("Please fill all the Necessary details.");
        AlertDialog alert = alertBuilder.create();
        alert.show();
    }
}
