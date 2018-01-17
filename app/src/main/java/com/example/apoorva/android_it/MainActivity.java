package com.example.apoorva.android_it;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    protected ImageView mMarker;
    protected Button mSignIn;
    protected Button mSignUp;
    static final int DEFAULT_ANIMATION_DURATION = 1000;
    protected FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(MainActivity.this, Home.class));
            finish();
        }
        mMarker =findViewById(R.id.marker);
        AnimatorSet a = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.marker_animation);
        a.setTarget(mMarker);
        AnimatorSet c = new AnimatorSet();
        c.play(a);
        c.setDuration(DEFAULT_ANIMATION_DURATION);
        c.start();
        mSignIn = (Button)findViewById(R.id.sign_in);
        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(MainActivity.this,Sign_in.class);
                startActivity(i);
            }
        });
        mSignUp = (Button)findViewById(R.id.sign_up);
        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(MainActivity.this,Login.class);
                startActivity(i);
            }
        });
    }
}
