package com.example.myapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class PrayerTalks extends AppCompatActivity {

    private ArrayList<Music> my_main_arraylist;
    private MusicAdapter mymusicadapter;
    private ListView listView_songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer_talks);
        listView_songs=findViewById(R.id.listview_songs);
        my_main_arraylist=new ArrayList();
        my_main_arraylist.add(new Music("prayer1","",R.raw.prayer1));
        my_main_arraylist.add(new Music("prayer2","",R.raw.prayer2));
        my_main_arraylist.add(new Music("prayer3","",R.raw.prayer3));
        my_main_arraylist.add(new Music("prayer4","",R.raw.prayer4));
        my_main_arraylist.add(new Music("prayer5","",R.raw.prayer5));
        my_main_arraylist.add(new Music("prayer6","",R.raw.prayer6));
        my_main_arraylist.add(new Music("prayer7","",R.raw.prayer7));
        MusicAdapter adapter=new MusicAdapter(this,R.layout.songs_item_listview,my_main_arraylist);
        listView_songs.setAdapter(adapter);

    }
}
