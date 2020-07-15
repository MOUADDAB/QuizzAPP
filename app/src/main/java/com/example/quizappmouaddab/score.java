package com.example.quizappmouaddab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        addListenerOnButton();
        addListenerOnButton1();
        addListenerOnButton2();
    }

    private void addListenerOnButton2() {
        final Context context =this;
        Button button =(Button) findViewById(R.id.Map);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MAP.class);
                startActivity(intent);

            }
        });
    }

    public void addListenerOnButton() {
        final Context context = this;
        Button button = (Button) findViewById(R.id.retry);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, quizz1.class);
                startActivity(intent);

            }

        });
    }

    public void addListenerOnButton1() {

        final Context context = this;

        Button button1 = (Button) findViewById(R.id.exit);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);

            }

        });

    }

}
