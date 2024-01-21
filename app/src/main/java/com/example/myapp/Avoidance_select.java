package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Avoidance_select extends AppCompatActivity {

    TextView textView;
    Button button1,button2,button3,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avoidance_trigger);

        button1=(Button)findViewById(R.id.btn_bajan);
        button2=(Button)findViewById(R.id.btn_motiv);
        button3=(Button)findViewById(R.id.btn_atma);
        button4=(Button)findViewById(R.id.btn_prayer);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bj=new Intent(Avoidance_select.this,Bajan.class);
                startActivity(bj);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mot=new Intent(Avoidance_select.this,Motiv.class);
                startActivity(mot);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pt=new Intent(Avoidance_select.this,PrayerTalks.class);
                startActivity(pt);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent at=new Intent(Avoidance_select.this,AtmavalokanaTalks.class);
                startActivity(at);
            }
        });

    }
}