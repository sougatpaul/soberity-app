package com.example.myapp;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

public class Avg_quantity extends AppCompatActivity {
    DataBase_saver DB;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avg_quantity);

        textView = findViewById(R.id.tv_history);

        DB = new DataBase_saver(this);
        Double new_avg = 0.0;
        ArrayList<Double> average = DB.average_ethonol();
        int i;
        for(i = 0;i< average.size();i++ )
        {
            new_avg = new_avg + average.get(i);
        }
        new_avg = new_avg/ average.size();
        String risk_level = null;
        if (new_avg >= 1 && new_avg <= 40) {
            risk_level = "Low Risk";
        } else if (new_avg >= 41 && new_avg <= 60) {
            risk_level = "Medium Risk";
        } else if (new_avg >= 61 && new_avg <= 100) {
            risk_level = "High Risk";
        } else if (new_avg >= 101) {
            risk_level = "Very High Risk";
        }
        textView.setText("Average Risk Level till date:" + risk_level + "( " + new_avg + " ml)");
    }
}
