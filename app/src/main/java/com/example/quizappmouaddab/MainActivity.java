package com.example.quizappmouaddab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    //Declaration
    EditText etLogin , etPassword;
    Button bLogin;
    TextView tvRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperation des ids
        etLogin=(EditText)findViewById(R.id.etLogin);
        etPassword=(EditText)findViewById(R.id.etPassword);
        bLogin=(Button)findViewById(R.id.bLogin);
        tvRegister=(TextView)findViewById(R.id.tvRegister);
        //Association de listeners
        bLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Traitement
                if (etLogin.getText().toString().equals("nabil") && etPassword.getText().toString().equals("Mouaddab"))
                {
                    startActivity(new Intent(MainActivity.this, quizz1.class));
                }
                else{
                    Toast.makeText(getApplicationContext(),"Login or password incorrect !",Toast.LENGTH_LONG).show();
                }
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,Register.class));
            }
        });
    }
}
