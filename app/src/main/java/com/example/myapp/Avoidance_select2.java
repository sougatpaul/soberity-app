package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Avoidance_select2 extends AppCompatActivity {
    TextView textView;
    Button button1,button3,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avoidance_trigger2);

        button1=(Button)findViewById(R.id.btn_bajan1);
        button3=(Button)findViewById(R.id.btn_atma1);
        button4=(Button)findViewById(R.id.btn_prayer1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bj1=new Intent(Avoidance_select2.this,Bhajan1.class);
                startActivity(bj1);
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pt1=new Intent(Avoidance_select2.this,PrayerTalks1.class);
                startActivity(pt1);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent at1=new Intent(Avoidance_select2.this,AtmavalokanaTalks1.class);
                startActivity(at1);
            }
        });

    }
}
