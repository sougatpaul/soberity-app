package com.example.myapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity_sdm extends AppCompatActivity
{

    TextView name_contact;
    TextView textResult;
    TextView person;
    TextView textResult2;
    TextView person2;

    //Spinner spinnerSource;
    Spinner spinnerDestination;

    String source;
    String destination;
    String contact;
    String Person;
    String contact2;
    String Person2;


    ArrayList<String> zone0,zone1, zone2, zone3;
    ArrayAdapter<String> adapterSpinnerDestination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdm);

        // Views
        name_contact=(TextView)findViewById(R.id.namecontact);
        textResult = (TextView) findViewById(R.id.text_result);
        person = (TextView) findViewById(R.id.text_person);

        textResult2= (TextView) findViewById(R.id.text_result2);
        person2 = (TextView) findViewById(R.id.text_person2);

        //spinnerSource = (Spinner) findViewById(R.id.spinner_source);
        spinnerDestination = (Spinner) findViewById(R.id.spinner_destination);

        // Spinner Drop down elements
//        ArrayList<String> locations = new ArrayList<String>();
//        locations.add("Select Zone");
//        locations.add("Zone 1");
//        locations.add("Zone 2");
//        locations.add("Zone 3");
//        locations.add("Zone 4");
//        locations.add("Zone 5");
//        locations.add("Zone 6");

//        zone0= new ArrayList<>();
//        zone0.add("Select District");
//
//
//        zone1= new ArrayList<>();
//        zone1.add("Select District");
//        zone1.add("Dharwad");
//        zone1.add("Gadag");
//        zone1.add("Hubballi");
//        zone1.add("Belagavi");
//
//        zone2= new ArrayList<>();
//        zone2.add("Select District");
//        zone2.add("Bengaluru");
//        zone2.add("Bidar");
//        zone2.add("Chamarajanagar");
//        zone2.add("Haveri");
//
//        zone3= new ArrayList<>();
//        zone3.add("Select District");
//        zone3.add("Chitradurga");
//        zone3.add("Dakshina Kannada");
//        zone3.add("Davangere");
//        zone3.add("Hassan");




        ArrayList<String> location2 = new ArrayList<String>();
        location2.add("Select the District");
        location2.add("Bengaluru");
        location2.add("Bidar");
        location2.add("Chamarajanagar");
        location2.add("Haveri");
        location2.add("Chitradurga");
        location2.add("Dakshina Kannada");
        location2.add("Davangere");
        location2.add("Hassan");
        location2.add("Chikkamagaluru");
        location2.add("Kalaburagi");
        location2.add("Kodagu");
        location2.add("Koppal");
        location2.add("Mandya");
        location2.add("Mysore");
        location2.add("Raichur");
        location2.add("Ramanagara");
        location2.add("Shivamogga");
        location2.add("Tumakuru");
        location2.add("Udupi");
        location2.add("Uttara Kannada");
        location2.add("Vijayapura");
        location2.add("Yadgir");
        location2.add("Bagalkot");
        location2.add("Ballari");

        Button buttonCall=(Button)findViewById(R.id.Bcall);
        Button buttonCall2=(Button)findViewById(R.id.Btcall);






        // Initialize
        //source = locations.get(0);

        // Creating adapter for spinner
        //ArrayAdapter<String> adapterSpinnerSource = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, locations);
        ArrayAdapter<String> adapterSpinnerDestination = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, location2);
        //ArrayAdapter<String> adapterSpinnerDestination = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, zone0);

        // attaching data adapter to spinners
        //spinnerSource.setAdapter(adapterSpinnerSource);
        spinnerDestination.setAdapter(adapterSpinnerDestination);

        //Spinner item select listener
//        spinnerSource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                // Source location
//
//                if(position == 0)
//                {
//                    //adapterSpinnerDestination = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, zone0);
//                }
//                if (position == 1) {
//
//                    //adapterSpinnerDestination = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, zone1);
//
//                }
//                if (position == 2) {
//
//                    //adapterSpinnerDestination = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, zone2);
//                }
//                if (position == 3) {
//
//                    //adapterSpinnerDestination = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, zone3);
//
//                }
//                //spinnerDestination.setAdapter(adapterSpinnerDestination);
//                source = parent.getItemAtPosition(position).toString();
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        Button finalButtonCall = buttonCall;
        Button finalButtonCall2 = buttonCall2;


        spinnerDestination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Destination location
                destination = parent.getItemAtPosition(position).toString();
                if(position == 1 || position == 2 || position == 3 || position == 4 || position == 5|| position == 6|| position == 7|| position == 8|| position == 9|| position == 10|| position == 11 || position == 12 || position == 13|| position == 14 || position == 15 || position == 16 || position == 17 || position == 18 || position == 19 || position == 20 || position == 21|| position == 22 || position == 23 || position == 24 || position == 25 || position == 26 || position == 27 || position == 28 || position == 29 || position == 30)
                {
                    name_contact.setVisibility(View.VISIBLE);
                    name_contact.setText("Contact Details");
                    textResult.setVisibility(View.VISIBLE);
                    person.setVisibility(View.VISIBLE);
                    buttonCall.setVisibility(View.VISIBLE);
                    buttonCall.setText("Call");
                    textResult2.setVisibility(View.VISIBLE);
                    person2.setVisibility(View.VISIBLE);
                    buttonCall2.setVisibility(View.VISIBLE);
                    buttonCall2.setText("Call");
                }
                calculateCost();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //buttonCall = findViewById(R.id.Bcall);

        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long number = Long.valueOf(contact);
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });

        buttonCall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long number = Long.valueOf(contact2);
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });


    }

    public void calculateCost() {

        if ("Bengaluru".equals(destination)) {
            Person = "Dr.Sunita Hiremath";
            contact = "9900157426";
            Person2 = "Dr.Sunita Hiremath";
            contact2 = "9900157426";
        } else if ("Bidar".equals(destination)) {
            Person = "Snetal Gongade";
            contact = "8971376642";
            Person2 = "Snetal Gongade";
            contact2 = "8971376642";

        } else if ("Kalaburagi".equals(destination)) {
            Person = "Shivani Patil";
            contact = "8088624088";

            Person2 = "Supriya Khemalapure";
            contact2 = "8088624088";
        } else if ("Belagavi".equals(destination)) {
            Person = "Pradeep Divatagi";
            contact = "88888882546";
            Person2 = "Pradeep Divatagi";
            contact2 = "88888882546";

        } else if ("Chamarajanagar".equals(destination)) {
            Person = "Priya Hadimani";
            contact = "9999999177";

            Person2 = "Priya Hadimani";
            contact2 = "9999999177";
        } else if ("Haveri".equals(destination)) {
            Person = "Ramesh Panth";
            contact = "9989999168";
            Person2 = "Ramesh Panth";
            contact2 = "9989999168";
        } else if ("Dakshina Kannada".equals(destination)) {
            Person = "Akash Jamakhandi";
            contact = "9989997122";

            Person2 = "Akash Jamakhandi";
            contact2 = "9989997122";
        } else if ("Davangere".equals(destination)) {
            Person = "Prateek Biradar";
            contact = "9981999198";

            Person2 = "Prateek Biradar";
            contact2 = "9981999198";
        } else if ("Hassan".equals(destination)) {
            Person = "Akshansh Desai";
            contact = "9989799112";
            Person2 = "Akshansh Desai";
            contact2 = "9989799112";
        } else if ("Chitradurga".equals(destination)) {
            Person = "Shivani Guranalli";
            contact = "9229999176";
            Person2 = "Kiya Rajput";
            contact2 = "9229999176";
        }else if ("Udupi".equals(destination)) {
            Person = "Soumya Jakkalli";
            contact = "9229999176";

            Person2 = "Prateek Biradar";
            contact2 = "9981999198";
        }else if ("Tumakuru".equals(destination)) {
            Person = "Soumya Jakkalli";
            contact = "9229999176";
        }else if ("Shivamogga".equals(destination)) {
            Person = "Kiya";
            contact = "9229999176";
        }else if ("Ramanagara".equals(destination)) {
            Person = "Madura Naik";
            contact = "9229999176";

            Person2 = "Prateek Biradar";
            contact2 = "9981999198";
        }else if ("Raichur".equals(destination)) {
            Person = "Madura Naik";
            contact = "9229999176";

            Person2 = "Priya Hadimani";
            contact2 = "9999999177";
        }else if ("Mysore".equals(destination)) {
            Person = "Kiya";
            contact = "9229999176";
        }else if ("Mandya".equals(destination)) {
            Person = "Soumya Jakkalli";
            contact = "9229999176";
        }else if ("Koppal".equals(destination)) {
            Person = "Madura Naik";
            contact = "9229999176";

            Person2 = "Pradeep Divatagi";
            contact2 = "88888882546";

        }else if ("Kodagu".equals(destination)) {
            Person = "Kiya";
            contact = "9229999176";

            Person2 = "Shivani Patil";
            contact2 = "8088624088";


        }else if ("Uttara Kannada".equals(destination)) {
            Person = "Kiya";
            contact = "9229999176";

            Person2 = "Pradeep Divatagi";
            contact2 = "88888882546";

        }else if ("Vijayapura".equals(destination)) {
            Person = "Kiya";
            contact = "9229999176";

            Person2 = "Priya Hadimani";
            contact2 = "9999999177";
        }else if ("Bagalkot".equals(destination)) {
            Person = "Kiya";
            contact = "9229999176";

            Person = "Ramesh Panth";
            contact = "9989999168";

        }else if ("Ballari".equals(destination)) {
            Person = "Kiya";
            contact = "9229999176";
        }else if ("Yadgir".equals(destination)) {
            Person = "Kiya";
            contact = "9229999176";

            Person = "Ramesh Panth";
            contact = "9989999168";
        }



        // Output

        person.setText(String.valueOf(Person));
        textResult.setText(String.valueOf(contact));

        person2.setText(String.valueOf(Person2));
        textResult2.setText(String.valueOf(contact2));

    }

}




