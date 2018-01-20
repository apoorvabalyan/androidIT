package com.example.apoorva.android_it;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Teacher_profile extends AppCompatActivity {
    private String text1;
    private TextView textView;
    private String mId;
    private TextView contactT;
    private TextView exp;
    private TextView qual;
    private TextView sub;
    private ImageView contactTI;
    private ImageView expTI;
    private ImageView qualTI;
    private ImageView subTI;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);
        mId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference("users").child("teachers").child(mId).child("subjects");
        contactT = findViewById(R.id.contactT);
        exp = findViewById(R.id.experience);
        qual = findViewById(R.id.qualifications);
        sub = findViewById(R.id.subjects);
        contactTI = findViewById(R.id.editContactT);
        expTI = findViewById(R.id.editExpT);
        qualTI = findViewById(R.id.editQT);
        subTI = findViewById(R.id.editSubjectsT);
        contactTI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editData(contactT);
            }
        });
        expTI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editData(exp);
            }
        });
        qualTI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editData(qual);
            }
        });
        subTI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(Teacher_profile.this);
                alert.setMessage("Enter the data:\n");
                final EditText input = new EditText(Teacher_profile.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                alert.setView(input);
                alert.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                         text1 = (input.getText().toString());
                        mDatabase.setValue(text1);
                        sub.setText(text1);
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
        });
        //This shows the name of the user
        textView = findViewById(R.id.user_name);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("name").getValue(String.class);
                textView.setText(name);
                Log.d("Name","I am apoorva" + name);
            }
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    //Opens the Dialog to enter the new data
    private void editData(final TextView v)
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
                submitAndSave(text,v);
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
    private void submitAndSave(String text,TextView v)
    {
        Toast.makeText(this,"Saving..",Toast.LENGTH_SHORT).show();
        v.setText(text);
    }
}
