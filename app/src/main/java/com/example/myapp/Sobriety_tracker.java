package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
        import android.widget.Button;
        import android.os.Bundle;
        import android.widget.TextView;
        import android.widget.Toast;


public class Sobriety_tracker extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2,btn3;
    Long systime = 0L , curtime = 0L;
    TextView tview,t1view;
    SharedPreferences sh ;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sobriety_tracker);

        btn1 = (Button) findViewById(R.id.btn_set);
        btn2 = (Button) findViewById(R.id.btn_reset);

        //new
        btn3 = (Button) findViewById(R.id.btn_count);
        // new

        tview = (TextView) findViewById(R.id.textView);
        t1view = (TextView) findViewById(R.id.textView2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        sh = getSharedPreferences("Mypref",MODE_PRIVATE);
    }
    @Override
    public void onClick(View view) {
        //void setTime()  set timer

        if (view == btn1 ) {

            // Get Current Date
                systime = System.currentTimeMillis() / 1000;
                editor = sh.edit();
                editor.putLong("systemtime", systime);
                editor.commit();

                //String time1  = systime.toString();
                Context context = getApplicationContext();
                CharSequence text = "Timer is Set";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                tview.setText("");
                t1view.setText("");
        }
        if (view == btn2) {

            // Get Current Time
            // for reset
            systime = sh.getLong("systemtime", systime);
            if( systime == 0L)
            {
                tview.setText("You have not set timer yet");
                t1view.setText("");
            }
            else {
                curtime = System.currentTimeMillis() / 1000;
                calculate_time(systime, curtime);
                systime = 0L;
                editor = sh.edit();
                editor.putLong("systemtime", systime);
                editor.commit();
            }

        }

        if(view == btn3){
            systime = sh.getLong("systemtime", systime);
            Long c_time = System.currentTimeMillis()/1000;
            get_time(systime,c_time);

        }
    }
    void calculate_time(long sys, long cur)
    {
        Context context1 = getApplicationContext();
        CharSequence text = "Timer is Reset";
        int duration = Toast.LENGTH_SHORT;
        Toast toast1 = Toast.makeText(context1, text, duration);
        toast1.show();
        Long cal = cur - sys;


        String cal_string = cal.toString();

        String cal_string1 = String.format("%02d hours %02d minutes %02d seconds", cal / 3600, (cal % 3600) / 60, (cal % 60));

        //Toast toast3 = Toast.makeText(context1, cal_string1, duration);
        //toast3.show();
        tview.setText("Sobriety Period is " + cal_string1);
        if (cal >= 120) {
            t1view.setText("Forget what's gone. Appreciate what still remains. Look forward to what's coming next");
        } else if (cal > 10) {
            t1view.setText("Don't drink, be sober. You can do it.");
        }
        //systime = 0L;
    }
    //if(view == btn3)   give the time without resetting
    void get_time(long sys,long cnt){
        if( systime == 0L )
        {
            tview.setText("You have not set timer yet");
            t1view.setText("");
        }
        else {
            Long g_time = cnt - sys;

            String gtime_string = String.format("%02d hours %02d minutes %02d seconds", g_time / 3600,
                    (g_time % 3600) / 60, (g_time % 60));
            tview.setText("Sobriety Period is " + gtime_string);
        }
    }
}