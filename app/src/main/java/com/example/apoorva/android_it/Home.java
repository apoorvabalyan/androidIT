package com.example.apoorva.android_it;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends AppCompatActivity {
    protected Button signout;
    protected Button profileBtn;
    protected Button findBtn;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    private boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //Only opens when the flag is false
        if(!flag)
            open();
        mAuth = FirebaseAuth.getInstance();
        profileBtn = (Button)findViewById(R.id.my_profile);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        findBtn = (Button)findViewById(R.id.find);
        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        signout = (Button) findViewById(R.id.home_btn);
        final FirebaseUser mAuthUser = FirebaseAuth.getInstance().getCurrentUser();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(Home.this, MainActivity .class));
                    finish();
                }
            }
        };
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
    }
    //Asks for various information from the user
    public void open()
    {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setMessage("Let us customize the app for you.\nAre you a Teacher?");
        alertBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(Home.this,Teacher_profile.class));
            }
        });
        alertBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(Home.this,Student_profile.class));
            }
        });
        AlertDialog alert = alertBuilder.create();
        alert.show();
        flag = true;
    }

    //sign out method
    public void signOut() {
        mAuth.signOut();
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}