package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Select extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        Button button1 = findViewById(R.id.btn_risk);
        Button button2 = findViewById(R.id.btn_help);
        Button button3 = findViewById(R.id.btn_sober);
        Button button4 = findViewById(R.id.btn_trigger);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_risk:
                openActivity1();
                break;
            case R.id.btn_help:
                openActivity2();
                break;
            case R.id.btn_sober:
                openActivity3();
                break;
            case R.id.btn_trigger:
                openActivity4();
                break;
        }
    }
    public void openActivity1(){
        Intent intent = new Intent(this, Risk_tracker.class);
        startActivity(intent);
    }
    public void openActivity2(){
        Intent intent = new Intent(this, PhoneHospital.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent = new Intent(this, Sobriety_tracker.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent = new Intent(this, anv.class);
        startActivity(intent);
    }

}
