package com.example.quizappmouaddab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    public EditText EtEmail,etPassword;
    Button EtRegister;
    TextView tRegister;
    FirebaseAuth mFirebaseAuth;

    private  FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth =FirebaseAuth.getInstance();
        EtEmail =findViewById(R.id.EtEmail);
        etPassword =findViewById(R.id.etPassword);
        EtRegister = findViewById(R.id.EtRegister);
        tRegister = findViewById(R.id.tRegister);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null){
                    //Toast.makeText(LoginActivity.this,"you are logged in" , Toast.LENGTH_SHORT).show();
                  //  Intent i = new Intent(LoginActivity.this , quizz1.class);
                  //  startActivity(i);
                }else{

                    Toast.makeText(LoginActivity.this,"Please login" , Toast.LENGTH_SHORT).show();

                }

            }
        };
        EtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = EtEmail.getText().toString();
                String password = etPassword.getText().toString();
                if(email.isEmpty())
                {
                    EtEmail.setError("Please enter email id ");
                    EtEmail.requestFocus();

                }

                else if (password.isEmpty()){
                    etPassword.setError("Please enter password id ");
                    etPassword.requestFocus();
                }else if(email.isEmpty() && password.isEmpty()){

                    Toast.makeText(LoginActivity.this,"Fields are Empty",Toast.LENGTH_SHORT).show();



                }
                else if (!(email.isEmpty() && password.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()){
                                Toast.makeText(LoginActivity.this,"Login Error , please login again!",Toast.LENGTH_SHORT).show();

                            }
                            else{

                                Intent in = new Intent(LoginActivity.this,quizz1.class);
                                startActivity(in);

                            }
                        }
                    });

                }

                else {
                    Toast.makeText(LoginActivity.this,"Error Occured !",Toast.LENGTH_SHORT).show();


                }
            }
        });

        tRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(LoginActivity.this , Register.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
