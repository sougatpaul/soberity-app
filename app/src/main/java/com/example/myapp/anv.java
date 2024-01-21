package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class anv extends AppCompatActivity{

    Button button10,button12;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anv);
        button10=(Button)findViewById(R.id.btn_audio);
        button12=(Button)findViewById(R.id.btn_video);

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainActivity =new Intent(anv.this,Avoidance_select.class);
                startActivity(MainActivity);

            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainActivity1 =new Intent(anv.this,Avoidance_select2.class);
                startActivity(MainActivity1);
            }
        });
    }
}
