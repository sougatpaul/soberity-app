package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button1:
                openActivity1();
                break;
            case R.id.button2:
                openActivity2();
                break;
            case R.id.button3:
                openActivity3();
                break;
            case R.id.button4:
                openActivity4();
                break;
            case R.id.button5:
                openActivity5();
                break;
        }
    }
    public void openActivity1(){
        Intent intent = new Intent(this, Select.class);
        startActivity(intent);
    }
    public void openActivity2(){
        Intent intent = new Intent(this, Select.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent = new Intent(this, Select.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent = new Intent(this, Select.class);
        startActivity(intent);
    }
    public void openActivity5(){
        Intent intent = new Intent(this, Select.class);
        startActivity(intent);
    }

}