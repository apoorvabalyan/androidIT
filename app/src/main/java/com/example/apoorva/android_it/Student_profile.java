package com.example.apoorva.android_it;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.*;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Student_profile extends AppCompatActivity {
    private boolean flag = false;
    private static  final String REQUIRED = "Required";
    protected TextView mContact;
    protected TextView mClass;
    protected TextView mAchievements;
    protected ImageView mEditContact;
    protected ImageView mEditClass;
    protected ImageView mEditAch;
    private DatabaseReference mDatabase;
    private String text = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        //Database intialization
        mDatabase = FirebaseDatabase.getInstance().getReference();
        if(!flag)
            open();
        mClass = (TextView)findViewById(R.id.standard);
        mContact = (TextView) findViewById(R.id.contact);
        mAchievements = (TextView) findViewById(R.id.acheievements);
        mEditAch = (ImageView)findViewById( R.id.editAch);
        mEditClass = (ImageView)findViewById(R.id.editClass);
        mEditContact = (ImageView)findViewById(R.id.editContact);
        mEditContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editData();
                mContact.setText(text);
            }
        });
        mEditClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editData();
                mClass.setText(text);
            }
        });
        mEditAch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editData();
                mAchievements.setText(text);
            }
        });
    }
    //Opens the Dialog to enter the new data
    private void editData()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Enter the data:\n");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        alert.setView(input);
        alert.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                text = (input.getText().toString());
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog a = alert.create();
        a.show();
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
