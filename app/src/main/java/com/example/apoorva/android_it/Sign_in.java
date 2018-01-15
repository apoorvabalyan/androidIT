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

public class Sign_in extends AppCompatActivity {
    static final int RC_SIGN_IN = 1;
    protected SignInButton mSignInButton;
    protected Button mSignN;
    protected EditText mEmail;
    protected EditText mPassword;
    protected GoogleApiClient mGoogleApiClient;
    protected FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mSignInButton = (SignInButton) findViewById(R.id.sign_in_button);
        mSignN = (Button) findViewById(R.id.sign_in);
        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
        //Email-Password Sign in
        mSignN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(Sign_in.this,"Enter Email Address",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(Sign_in.this,"Enter Password",Toast.LENGTH_LONG).show();
                    return;
                }
                if(password.length()<6)
                {
                    Toast.makeText(Sign_in.this,"Password too short.Enter mininum 6 characters.",Toast.LENGTH_LONG).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Sign_in.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(Sign_in.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(Sign_in.this, Home.class));
                            finish();
                        }
                    }
                });
            }
        });
        // Configure Google Sign In
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build();
//        mGoogleApiClient = new GoogleApiClient.Builder(this)
//                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
//                    @Override
//                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//
//                    }
//                } /* OnConnectionFailedListener */)
//                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
//                .build();
//        mSignInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                signIn();
//            }
//
//        });
    }
//    private void signIn() {
//        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
//        startActivityForResult(signInIntent, RC_SIGN_IN);
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
//        if (requestCode == RC_SIGN_IN) {
//            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
//            if (result.isSuccess()) {
//                // Google Sign In was successful, authenticate with Firebase
//                GoogleSignInAccount account = result.getSignInAccount();
//                firebaseAuthWithGoogle(account);
//            } else {
//                // Google Sign In failed, update UI appropriately
//                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
//        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
//        mAuth.signInWithCredential(credential)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
//
//                        if (task.isSuccessful()) {
//                            FirebaseUser user = mAuth.getCurrentUser();
//
//                        }
//                        else
//                        {
//                            Toast.makeText(Sign_in.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        //if the user is already signed in
//        //we will close this activity
//        //and take the user to profile activity
//        if (mAuth.getCurrentUser() != null) {
//            finish();
//            startActivity(new Intent(this, Home.class));
//        }
//    }

}
