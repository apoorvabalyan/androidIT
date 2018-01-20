package com.example.apoorva.android_it;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Find_tutor extends AppCompatActivity {

    CheckBox checkBox1;
    CheckBox checkBox2;
    EditText edit1;
    EditText edit2;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_tutor);
        mDatabase = FirebaseDatabase.getInstance().getReference("users").child("teachers");
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox1 = findViewById(R.id.checkbox1);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        String text1 = edit1.getText().toString().trim();
        String text2 = edit2.getText().toString().trim();
        Query myQuery = mDatabase.orderByChild("teachers").startAt(text1);
        myQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot task:dataSnapshot.getChildren()){

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}