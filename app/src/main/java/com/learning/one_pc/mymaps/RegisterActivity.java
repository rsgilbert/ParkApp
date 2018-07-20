package com.learning.one_pc.mymaps;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    //widgets
    private EditText emailBox, passwordBox;
    private Button registerButton, signButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //declaring widgets
        emailBox = findViewById(R.id.email_box);
        passwordBox = findViewById(R.id.password_box);
        registerButton = findViewById(R.id.button_register);
        signButton = findViewById(R.id.button_sign_in);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Toast.makeText(RegisterActivity.this, "signed in: " + user.getUid(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, ManagerActivity.class);
                    startActivity(intent);
                }
                else Toast.makeText(RegisterActivity.this, "signed out", Toast.LENGTH_SHORT).show();
            }
        };

        signButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String email = emailBox.getText().toString();
                        String password = passwordBox.getText().toString();

                        if(!email.equals("") && !password.equals("")){
                            mAuth.signInWithEmailAndPassword(email, password)
                                    .addOnCompleteListener(RegisterActivity.this,
                                            new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (!task.isSuccessful()) {
                                                Toast.makeText(RegisterActivity.this, "Failed to complete sign in", Toast.LENGTH_SHORT).show();
                                            }
                                            else{
                                                checkIfEmailIsVerified();
                                            }

                                        }
                                    }
                                    );
                        }
                        else if (email.equals(""))
                            Toast.makeText(RegisterActivity.this, "Email field is empty", Toast.LENGTH_SHORT).show();
                        else if (password.equals(""))
                            Toast.makeText(RegisterActivity.this, "Password field is empty", Toast.LENGTH_SHORT).show();

                    };
                }
        );

        registerButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(RegisterActivity.this, Registration.class);
                        startActivity(intent);
                    }
                }
        );
    }
    public void checkIfEmailIsVerified(){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if(user.isEmailVerified()){
                        Intent intent = new Intent(RegisterActivity.this, ManagerActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(this, "Account not verified", Toast.LENGTH_SHORT).show();
                        FirebaseAuth.getInstance().signOut();
                        overridePendingTransition(0, 0);
                    }
        }
    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
        //check to see if user is signed in
        // FirebaseUser currentUser = mAuth.getCurrentUser();

    }
    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(mAuthListener);
    }
}