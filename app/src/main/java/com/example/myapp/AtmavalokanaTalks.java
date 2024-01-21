package com.example.myapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class AtmavalokanaTalks extends AppCompatActivity {

    private ArrayList<Music> my_main_arraylist;
    private MusicAdapter mymusicadapter;
    private ListView listView_songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atmavalokana_talks);
        listView_songs=findViewById(R.id.listview_songs);
        my_main_arraylist=new ArrayList();
        my_main_arraylist.add(new Music("talks1","",R.raw.talks1));
        my_main_arraylist.add(new Music("talks2","",R.raw.talks2));
        my_main_arraylist.add(new Music("talks3","",R.raw.talks3));
        my_main_arraylist.add(new Music("talks4","",R.raw.talks4));
        my_main_arraylist.add(new Music("talks5","",R.raw.talks5));
        my_main_arraylist.add(new Music("talks6","",R.raw.talks6));
        my_main_arraylist.add(new Music("talks7","",R.raw.talks7));
        MusicAdapter adapter=new MusicAdapter(this,R.layout.songs_item_listview,my_main_arraylist);
        listView_songs.setAdapter(adapter);

    }
}
