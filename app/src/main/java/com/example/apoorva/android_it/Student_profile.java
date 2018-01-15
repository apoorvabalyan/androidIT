package com.example.apoorva.android_it;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.*;

public class Student_profile extends AppCompatActivity {
    private boolean flag = false;
    private static  final String REQUIRED = "Required";
    protected EditText mContact;
    protected EditText mClass;
    protected EditText mAchievements;
    protected Button mSaveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        if(!flag)
            open();
        mClass = (EditText)findViewById(R.id.standard);
        mContact = (EditText)findViewById(R.id.contact);
        mAchievements = (EditText)findViewById(R.id.acheievements);
        mSaveBtn = (Button)findViewById(R.id.saveBtn);
        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitAndSave();
            }
        });
    }
    //Pop up  that shows when user enter for the first time
    public void open()
    {
        flag = true;
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setMessage("Please fill all the details.");
        AlertDialog alert = alertBuilder.create();
        alert.show();
    }
    //Function that writes the data in the database
    private void submitAndSave()
    {
        String std = mClass.getText().toString();
        String contact = mContact.getText().toString();
        String achieve = mAchievements.getText().toString();
        if(TextUtils.isEmpty(std)){
            mClass.setError(REQUIRED);
        }
        Toast.makeText(this,"Saving..",Toast.LENGTH_SHORT).show();


    }
}
