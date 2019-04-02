package com.ammar.letsgetplaced;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

public class SignUpActivity extends AppCompatActivity {

    EditText signupid,signuppwd,signupschno,signupcgpa;
    Button signupbutton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        signupid = findViewById(R.id.signupEmail);
        signuppwd = findViewById(R.id.signuppwd);
        signupcgpa = findViewById(R.id.signupcgpa);
        signupschno = findViewById(R.id.signupschno);

        signupbutton = findViewById(R.id.signupbutton);

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registeruser();
            }
        });

    }

    private void registeruser() {
        final String email = signupid.getText().toString();
        String pwd = signuppwd.getText().toString();
        final String cgpa = signupcgpa.getText().toString();
        final String schno = signupschno.getText().toString();

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            signupid.setError("Enter valid email");
            signupid.requestFocus();
            return;
        }

        if(pwd.length()<6){
            signuppwd.setError("Password should not be less than 6 characters");
            signuppwd.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    User user = new User(email,cgpa,schno);

                    FirebaseDatabase.getInstance().getReference("Users").
                            child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user);

                    addToGroup(cgpa);

                    Intent intent = new Intent(SignUpActivity.this,Home.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();

                }
                else{
                    Toast.makeText(SignUpActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void addToGroup(String cgpa) {
        float grade = Float.parseFloat(cgpa);

        if(grade > 9.0){
            FirebaseMessaging.getInstance().subscribeToTopic("above9");
        }
        if(grade > 8.5){
            FirebaseMessaging.getInstance().subscribeToTopic("above8.5");
        }
        if(grade > 8.0){
            FirebaseMessaging.getInstance().subscribeToTopic("above8");
        }
        if(grade > 7.5){
            FirebaseMessaging.getInstance().subscribeToTopic("above7.5");
        }
        if(grade > 7.0){
            FirebaseMessaging.getInstance().subscribeToTopic("above7");
        }
        if(grade > 6.5){
            FirebaseMessaging.getInstance().subscribeToTopic("above6.5");
        }
        if(grade > 6.0){
            FirebaseMessaging.getInstance().subscribeToTopic("above6");
        }
    }
}
