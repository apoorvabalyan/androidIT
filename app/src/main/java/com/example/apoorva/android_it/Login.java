package com.example.apoorva.android_it;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    protected SignInButton mLogInButton;
    protected Button mLogN;
    protected EditText mEmail;
    protected EditText mPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLogN = (Button) findViewById(R.id.log_in);
        mEmail = (EditText) findViewById(R.id.log_email);
        mPassword = (EditText) findViewById(R.id.log_password);
        mAuth = FirebaseAuth.getInstance();
        //Email-Password Sign in
        mLogN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                final String password = mPassword.getText().toString().trim();
                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(Login.this,"Enter Email Address",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(Login.this,"Enter Password",Toast.LENGTH_LONG).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            // there was an error
                            if (password.length() < 6) {
                                Toast.makeText(Login.this, "Wrong credentials", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(Login.this, "Not a valid account", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            startActivity(new Intent(Login.this, Home.class));
                            finish();
                        }
                    }
                });
            }
        });

    }
}
