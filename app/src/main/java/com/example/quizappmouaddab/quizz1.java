package com.example.quizappmouaddab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class quizz1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        addListenerOnButton();
    }
    public void addListenerOnButton()
    {
        final Context context = this;
        Button button = (Button) findViewById(R.id.EtNext);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                Intent intent = new Intent(context, quizz2.class);
                startActivity(intent);
            }
        });
    }

}
