package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DistrictActivity extends AppCompatActivity {
    private TextView textView;
    private ListView listView;
//    String[] hospPhone = {"9866673764","9353642221","8660558996"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);
        Intent intent = getIntent();
        textView=findViewById(R.id.district_name);
        listView = findViewById(R.id.hospital_names);
        String name = intent.getStringExtra("District");
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
       databaseAccess.open();
        ArrayList<String> hospitals =  databaseAccess.getHospitals(name);
//        ArrayList<String> hospPhone = databaseAccess.getPhone(name);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(DistrictActivity.this, android.R.layout.simple_list_item_1,hospitals);
        listView.setAdapter(arrayAdapter);

//        System.out.println(name);
        textView.setText(name);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                Toast.makeText(DistrictActivity.this,"Calling "+hospPhone.get(i),Toast.LENGTH_SHORT).show();
                Intent callIntent = new Intent(DistrictActivity.this,HospitalActivity.class);
                callIntent.putExtra("hn",hospitals.get(i));
                databaseAccess.close();
//                callIntent.setData(Uri.parse("tel:"+hospPhone.get(i)));
                startActivity(callIntent);
            }
        });
    }
}