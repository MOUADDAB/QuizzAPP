package com.example.quizappmouaddab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
 public EditText EtEmail,etPassword;
 Button EtRegister;
 TextView tRegister;
 FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth =FirebaseAuth.getInstance();
        EtEmail =findViewById(R.id.EtEmail);
        etPassword =findViewById(R.id.etPassword);
        EtRegister = findViewById(R.id.EtRegister);
        tRegister = findViewById(R.id.tvRegister);
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

              Toast.makeText(Register.this,"Fields are Empty",Toast.LENGTH_SHORT).show();



           }
           else if (!(email.isEmpty() && password.isEmpty())){
               mFirebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()){

                            Toast.makeText(Register.this,"SignUp unsuccessful",Toast.LENGTH_SHORT).show();

                        }else{

                            startActivity(new Intent(Register.this,LoginActivity.class));


                        }
                   }
               });

           }

           else {
               Toast.makeText(Register.this,"Error Occured !",Toast.LENGTH_SHORT).show();


           }

            }

        });


        tRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this,LoginActivity.class);
                startActivity(i);
            }
        });



    }
}
