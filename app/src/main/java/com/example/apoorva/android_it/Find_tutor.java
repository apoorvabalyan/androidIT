package com.example.apoorva.android_it;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;

public class Find_tutor extends AppCompatActivity {

    CheckBox checkBox1;
    CheckBox checkBox2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_tutor);
        checkBox2 = findViewById(R.id.checkbox);
    }
}