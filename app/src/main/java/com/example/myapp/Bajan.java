package com.example.myapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bajan extends AppCompatActivity {


    private ArrayList<Music> my_main_arraylist;
    private MusicAdapter mymusicadapter;
    private ListView listView_songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bajan);
        listView_songs=findViewById(R.id.listview_songs);
        my_main_arraylist=new ArrayList();
        my_main_arraylist.add(new Music("krishna","bhajan",R.raw.bajan1));
        my_main_arraylist.add(new Music("Ram","bhajan",R.raw.bajan2));
        my_main_arraylist.add(new Music("achutan","keshvam",R.raw.bajan3));
        my_main_arraylist.add(new Music("ganesh","bhajan",R.raw.bajan4));
        my_main_arraylist.add(new Music("shiv","bhajan",R.raw.bajan5));
        my_main_arraylist.add(new Music("jai jagdisha ","hare",R.raw.bajan6));
        my_main_arraylist.add(new Music("shiv","bhajan",R.raw.bajan7));
        MusicAdapter adapter=new MusicAdapter(this,R.layout.songs_item_listview,my_main_arraylist);
        listView_songs.setAdapter(adapter);

    }



}

