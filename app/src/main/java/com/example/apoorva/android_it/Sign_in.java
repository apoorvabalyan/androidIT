package com.example.apoorva.android_it;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_in extends AppCompatActivity {
    String TAG = "Sign_in_activity";
    protected SignInButton mSignInButton;
    protected Button mSignN;
    protected EditText mEmail;
    protected EditText mPassword;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        //mSignInButton = (SignInButton) findViewById(R.id.sign_in_button);
        mSignN = (Button) findViewById(R.id.sign_in);
        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);
        //Database intialization
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        //Email-Password Sign in
        mSignN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Sign_in_listener");
                if (!validateForm()) {
                    return;
                }
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Sign_in.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(Sign_in.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            //This returns the current user that has created the account
                            onAuthSuccess(task.getResult().getUser());
                        }
                    }
                });
            }
        });
    }
    //Validates the data entered by the user
    private boolean validateForm()
    {
        boolean result = true;
        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            mEmail.setError("Required");
            result = false;
        }
        else
        {
            mEmail.setError(null);
        }
        if (TextUtils.isEmpty(password)) {
            mPassword.setError("Required");
            result = false;
        }
        else
        {
            mPassword.setError(null);
        }
        if (password.length() < 6) {
            mPassword.setError("Minimum 6 Characters!!");
            result = false;
        }
        else
        {
            mPassword.setError(null);
        }
        return result;
    }
    //If the user account is created,we need to save the data in the database and then goes to user home
    private void onAuthSuccess(FirebaseUser user)
    {
        //Returns the name of the user from the email address
        String userName = getUserName(user.getEmail());
        //Write the user to the database
        writeNewUser(user.getUid(),userName,user.getEmail());
        startActivity(new Intent(Sign_in.this, Home.class));
        finish();
    }
    private String getUserName(String email)
    {
        if(email.contains("@"))
        {
            return (email.split("@")[0]);
        }
        else
            return email;
    }
    private void writeNewUser(String userId,String name,String email)
    {
        UserClass user = new UserClass(name,email);
        mDatabase.child("users").child(userId).setValue(user);
    }
}
