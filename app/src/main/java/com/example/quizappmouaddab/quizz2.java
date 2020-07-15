package com.example.quizappmouaddab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class quizz2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz2);
        addListenerOnButton();
    }
    public void addListenerOnButton()
    {
        final Context context = this;
        Button button = (Button) findViewById(R.id.EtNext1);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                Intent intent = new Intent(context, score.class);
                startActivity(intent);
            }
        });
    }
}
