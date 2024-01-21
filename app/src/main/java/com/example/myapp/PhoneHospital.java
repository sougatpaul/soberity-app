package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PhoneHospital<CurrentActivity> extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                openActivity1();
                break;
            case R.id.button2:
                openActivity2();
                break;
//            case R.id.button3:
//                openActivity3();
//                break;
//            case R.id.button4:
//                openActivity4();
//                break;
//            case R.id.button5:
//                openActivity5();
//                break;
        }
    }

    public void openActivity1() {
        Intent intent = new Intent( this, Activity_sdm.class);
        startActivity(intent);
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Phone_hospital2.class);
        startActivity(intent);
    }
//        public void openActivity3(){
//            Intent intent = new Intent(this, Activity3_hi.class);
//            startActivity(intent);
//        }
//        public void openActivity4(){
//            Intent intent = new Intent(this, Activity4_te.class);
//            startActivity(intent);
//        }
//        public void openActivity5(){
//            Intent intent = new Intent(this, Activity5_ma.class);
//            startActivity(intent);}

}


