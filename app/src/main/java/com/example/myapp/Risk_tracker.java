package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
//import com.github.mikephil.charting.charts.BarChart;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Risk_tracker extends AppCompatActivity {
    Spinner dropdown;
    Spinner dropdown2;
    EditText t1;
    TextView t3;
    TextView t4;
    TextView t5,t6;
    double ethonol_content;

    Button b1,b2,b3;
    DataBase_saver DB;

    public void risk_calculation(View v){

        int i = 0;
        t6.setText("Risk level is the risk of developing health problems");
        if(dropdown2.getSelectedItem().toString().equals("") || dropdown2.getSelectedItem().toString().equals("Select the Gender"))
        {
            i++;
            Toast.makeText(getApplicationContext(),"Please select the Gender",Toast.LENGTH_LONG).show();
            dropdown2.setFocusable(true);

        }

        if(dropdown.getSelectedItem().toString().equals("") || dropdown.getSelectedItem().toString().equals("Type of Alcohol"))
        {
            i++;
            Toast.makeText(getApplicationContext(),"Please select type of Alcohol",Toast.LENGTH_LONG).show();
            dropdown.setFocusable(true);

        }

        if(t1.getText().toString().equals(""))
        {
            i++;
            Toast.makeText(getApplicationContext(),"Please enter Average quantity",Toast.LENGTH_LONG).show();
            t1.setFocusable(true);

        }


        double result=0;
        if(dropdown.getSelectedItem().toString().equals("Vodka") && !t1.getText().toString().equals("")) {
            int t2 = Integer.parseInt(t1.getText().toString());
            result = 0.675 * t2 * 0.789;
        }
        if(dropdown.getSelectedItem().toString().equals("Gin") && !t1.getText().toString().equals("")) {
            int t2 = Integer.parseInt(t1.getText().toString());
            result = 0.43 * t2 * 0.789;
        }
        if(dropdown.getSelectedItem().toString().equals("Rum") && !t1.getText().toString().equals("")) {
            int t2 = Integer.parseInt(t1.getText().toString());
            result = 0.43 * t2 * 0.789;
        }
        if(dropdown.getSelectedItem().toString().equals("Whiskey") && !t1.getText().toString().equals("")) {
            int t2 = Integer.parseInt(t1.getText().toString());
            result = 0.43 * t2 * 0.789;
        }
        if(dropdown.getSelectedItem().toString().equals("Brandy") && !t1.getText().toString().equals("")) {
            int t2 = Integer.parseInt(t1.getText().toString());
            result = 0.475 * t2 * 0.789;
        }
        if(dropdown.getSelectedItem().toString().equals("Beer") && !t1.getText().toString().equals("")) {
            int t2 = Integer.parseInt(t1.getText().toString());
            result = 0.06 * t2 * 0.789;
        }
        if(dropdown.getSelectedItem().toString().equals("Tequila") && !t1.getText().toString().equals("")) {
            int t2 = Integer.parseInt(t1.getText().toString());
            result = 0.5 * t2 * 0.789;
        }
        if(dropdown.getSelectedItem().toString().equals("Liquors") && !t1.getText().toString().equals("")) {
            int t2 = Integer.parseInt(t1.getText().toString());
            result = 0.15 * t2 * 0.789;
        }
        if(dropdown.getSelectedItem().toString().equals("Fortified Wine") && !t1.getText().toString().equals("")) {
            int t2 = Integer.parseInt(t1.getText().toString());
            result = 0.20 * t2 * 0.789;
        }
        if(dropdown.getSelectedItem().toString().equals("Unfortified Wine") && !t1.getText().toString().equals("")) {
            int t2 = Integer.parseInt(t1.getText().toString());
            result = 0.15 * t2 * 0.789;
        }
        if(dropdown.getSelectedItem().toString().equals("Malt Beverage") && !t1.getText().toString().equals("")) {
            int t2 = Integer.parseInt(t1.getText().toString());
            result = 0.15 * t2 * 0.789;
        }
        if(dropdown.getSelectedItem().toString().equals("Cider") && !t1.getText().toString().equals("")) {
            int t2 = Integer.parseInt(t1.getText().toString());
            result = 0.0575 * t2 * 0.789;
        }
        if(dropdown.getSelectedItem().toString().equals("Others") && !t1.getText().toString().equals("")) {
            int t2 = Integer.parseInt(t1.getText().toString());
            result = 0.355 * t2 * 0.789;
        }

        double abv=result/0.789;

        if(dropdown2.getSelectedItem().toString().equals("Male"))
        {
            if (result <1) {
                ethonol_content = result;
                Toast.makeText(getApplicationContext(), "Please enter correct input", Toast.LENGTH_LONG).show();
                t4.setText("Insufficient input");
                t3.setText("");
            }
            else if (result >= 1 && result <= 40) {
                ethonol_content = result;
                Toast.makeText(getApplicationContext(), "Low Risk", Toast.LENGTH_LONG).show();
                t3.setText("Low Risk");
                t3.setTextColor(Color.parseColor("#1E8905"));
                t4.setText(String.format(Locale.US, "Alcohol by Volume(ABV):\n %.2f ml",abv));
            } else if (result >= 41 && result <= 60) {
                ethonol_content = result;
                Toast.makeText(getApplicationContext(), "Medium Risk", Toast.LENGTH_LONG).show();
                t3.setText("Medium Risk");
                t3.setTextColor(Color.parseColor("#C9D207"));
                t4.setText(String.format(Locale.US, "Alcohol by Volume(ABV):\n %.2f ml",abv));
            } else if (result >= 61 && result <= 100) {
                ethonol_content = result;
                Toast.makeText(getApplicationContext(), "High Risk", Toast.LENGTH_LONG).show();
                t3.setText("High Risk");
                t3.setTextColor(Color.parseColor("#F95C08"));
                t4.setText(String.format(Locale.US, "Alcohol by Volume(ABV):\n %.2f ml",abv));
            } else if (result >= 101) {
                ethonol_content = result;
                Toast.makeText(getApplicationContext(), "Very High Risk", Toast.LENGTH_LONG).show();
                t3.setText("Very High Risk !");
                t3.setTextColor(Color.parseColor("#F90808"));
                t4.setText(String.format(Locale.US, "Alcohol by Volume(ABV):\n %.2f ml",abv));
            }
        }

        if(dropdown2.getSelectedItem().toString().equals("Female"))
        {
            if (result <1) {
                ethonol_content = result;
                Toast.makeText(getApplicationContext(), "Please enter correct input", Toast.LENGTH_LONG).show();
                t4.setText("Insufficient input");
                t3.setText("");
            }
            else if (result >= 1 && result <= 20) {
                ethonol_content = result;
                Toast.makeText(getApplicationContext(), "Low Risk", Toast.LENGTH_LONG).show();
                t3.setText("Low Risk");
                t3.setTextColor(Color.parseColor("#1E8905"));
                t4.setText(String.format(Locale.US, "Alcohol by Volume(ABV):\n %.2f ml",abv));

            } else if (result >= 21 && result <= 40) {
                ethonol_content = result;
                Toast.makeText(getApplicationContext(), "Medium Risk", Toast.LENGTH_LONG).show();
                t3.setText("Medium Risk");
                t3.setTextColor(Color.parseColor("#C9D207"));
                t4.setText(String.format(Locale.US, "Alcohol by Volume(ABV):\n %.2f ml",abv));
            } else if (result >= 41 && result <= 60) {
                ethonol_content = result;
                Toast.makeText(getApplicationContext(), "High Risk", Toast.LENGTH_LONG).show();
                t3.setText("High Risk");
                t3.setTextColor(Color.parseColor("#F95C08"));
                t4.setText(String.format(Locale.US, "Alcohol by Volume(ABV):\n %.2f ml",abv));
            } else if (result >= 61) {
                ethonol_content = result;
                Toast.makeText(getApplicationContext(), "Very High Risk", Toast.LENGTH_LONG).show();
                t3.setText("Very High Risk !");
                t3.setTextColor(Color.parseColor("#F90808"));
                t4.setText(String.format(Locale.US, "Alcohol by Volume(ABV):\n %.2f ml",abv));
            }
        }
        if(i==0) {
            DB = new DataBase_saver(this);
            String gen = dropdown2.getSelectedItem().toString();
            String type_of_alcohol = dropdown.getSelectedItem().toString();
            int quant = Integer.parseInt(t1.getText().toString());
            Long timestamp = System.currentTimeMillis() / 1000;
            //Toast.makeText(Risk_tracker.this, gen, Toast.LENGTH_SHORT).show();
            //Toast.makeText(Risk_tracker.this, type_of_alcohol, Toast.LENGTH_SHORT).show();
            Boolean checkinsertdata = DB.insertuserdata(gen, type_of_alcohol, quant, timestamp, ethonol_content);
            if (checkinsertdata == true)
                Toast.makeText(Risk_tracker.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(Risk_tracker.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
        }
        /*Cursor cursor = DB.getdata();
        cursor.moveToFirst();
        */
    }

    public void reset(View v){
        t1.setText("");
        dropdown.setSelection(0);
        dropdown2.setSelection(0);
        t3.setText("");
        t4.setText("");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.risk_tracker);

        dropdown = findViewById(R.id.spinner1);
        dropdown2 = findViewById(R.id.spinner2);
        t1=(EditText)findViewById((R.id.editText24));
        t3=(TextView) findViewById((R.id.textView2));
        t4=(TextView) findViewById((R.id.textView3));
        t5=(TextView) findViewById(R.id.textView);
        t6=(TextView) findViewById(R.id.textView6);
        b1=findViewById(R.id.button9);
        b2=findViewById(R.id.button);
        b3=findViewById(R.id.btn_history);

        DB = new DataBase_saver(this);

        b1.setText("Submit");
        b2.setText("Reset");
        //b3.setText("History");
        t1.setHint("Enter Avg Quantity (per day in mL)");

      //  setTitle("Risk Assessment");
        t1.setCursorVisible(true);
        t1.setPressed(true);

        //create a list of items for the spinner.
        String[] items = new String[]{"Type of Alcohol                                >","Vodka","Gin","Rum","Whiskey",
                "Brandy","Beer","Tequila", "Liquors","Fortified Wine",
                "Unfortified Wine","Malt Beverage","Cider","Others"};

        String[] gender = new String[]{"Select the Gender                            >","Male","Female"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, gender);

        dropdown.setAdapter(adapter);
        dropdown.setSelection(0);
        dropdown2.setAdapter(adapter1);
        dropdown2.setSelection(0);
        //BarChart barChart;
        b3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //DB.retrievedata();
                /*ArrayList<Long>  yval= DB.queryXData();
                ArrayList<Double> xval = DB.queryYData();
                BarDataSet dataSet = new BarDataSet(yval, "Risk Level");
                dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

                BarData data = new BarData(xval, dataSet);


                LimitLine line = new LimitLine(12f, "average daily expense");
                line.setTextSize(12f);
                line.setLineWidth(4f);
                YAxis leftAxis = barChart.getAxisLeft();
                leftAxis.addLimitLine(line);

                barChart.setData(data);
                barChart.setDescription("Risk level Chart.");
                barChart.animateY(2000);*/

                Intent intent = new Intent(Risk_tracker.this, Avg_quantity.class);
                startActivity(intent);
            }
        });

    }
}