package com.example.myapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HospitalActivity extends AppCompatActivity {
    TextView hospitalName,address,phone;
    Button callBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        hospitalName = findViewById(R.id.hospital_name);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        callBtn = findViewById(R.id.callBtn);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        Intent i = getIntent();
        String name = i.getStringExtra("hn");
        ArrayList<String> addr = databaseAccess.getAddress(name);
        ArrayList<String> phonenum = databaseAccess.getPhone(name);
        hospitalName.setText(name);
        address.setText(addr.get(0));
        phone.setText(phonenum.get(0));
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HospitalActivity.this,"Calling "+phonenum.get(0),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phonenum.get(0)));
                startActivity(intent);
            }
        });

    }
}