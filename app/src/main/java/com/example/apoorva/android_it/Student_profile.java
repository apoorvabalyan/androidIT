package com.example.apoorva.android_it;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class Student_profile extends AppCompatActivity {
    private boolean flag = false;
    private static  final String REQUIRED = "Required";
    protected  TextView mStudentName;
    protected String mId;
    protected TextView mContact;
    protected TextView mClass;
    protected TextView mAchievements;
    protected ImageView mEditContact;
    protected ImageView mEditClass;
    protected ImageView mEditAch;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        //Database intialization
        mStudentName = findViewById(R.id.student_name);
        //Shows the name of the user
        mId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference("users").child("students").child(mId);
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("name").getValue(String.class);
                mStudentName.setText(name);
            }
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        //To write the data about the user in the profile
        mClass = findViewById(R.id.standard);
        mContact = findViewById(R.id.contact);
        mAchievements =  findViewById(R.id.acheievements);
        mEditAch = findViewById( R.id.editAch);
        mEditClass = findViewById(R.id.editClass);
        mEditContact = findViewById(R.id.editContact);
        mEditContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editData(R.id.contact,mContact);
            }
        });
        mEditClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editData(R.id.standard,mClass);
            }
        });
        mEditAch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editData(R.id.acheievements,mAchievements);
            }
        });
    }
    //Opens the Dialog to enter the new data
    private void editData(final int id,final TextView v)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Enter the data:\n");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        alert.setView(input);
        alert.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String text = (input.getText().toString());
                submitAndSave(text,id,v);
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
    //Function that writes the data in the database
    private void submitAndSave(String text,int id,TextView v)
    {
        Toast.makeText(this,"Saving..",Toast.LENGTH_SHORT).show();
        v.setText(text);
    }
}
