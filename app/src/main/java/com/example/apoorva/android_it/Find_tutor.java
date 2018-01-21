package com.example.apoorva.android_it;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    private EditText edit1;
    EditText edit2;
    Button btn;
    private String text1;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_tutor);
        mDatabase = FirebaseDatabase.getInstance().getReference("users").child("teachers");
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox1 = findViewById(R.id.checkbox1);
        edit1 = findViewById(R.id.edit1Edit);
        edit2 = findViewById(R.id.edit2);
        btn = findViewById(R.id.searchBtn);
        text1 = edit1.getText().toString();
        String text2 = edit2.getText().toString();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("edit1",text1 + "apoorva");
                Log.d("Entering the button cod","clicked");
                mDatabase.orderByChild("subjects").equalTo(text1).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot task:dataSnapshot.getChildren())
                            Log.d("Apoorva",".....");
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}