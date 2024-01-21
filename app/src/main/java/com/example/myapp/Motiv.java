package com.example.myapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Motiv extends AppCompatActivity {
    private ArrayList<Music> my_main_arraylist;
    private MusicAdapter mymusicadapter;
    private ListView listView_songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motiv);
        listView_songs=findViewById(R.id.listview_songs);
        my_main_arraylist=new ArrayList();
        my_main_arraylist.add(new Music("motiv1","",R.raw.motiv1));
        my_main_arraylist.add(new Music("motiv2","",R.raw.motiv2));
        my_main_arraylist.add(new Music("motiv3","",R.raw.motiv3));
        my_main_arraylist.add(new Music("motiv4","",R.raw.motiv4));
        my_main_arraylist.add(new Music("motiv5","",R.raw.talks5));
        my_main_arraylist.add(new Music("motiv6","",R.raw.talks6));
        my_main_arraylist.add(new Music("motiv7","",R.raw.talks7));
        MusicAdapter adapter=new MusicAdapter(this,R.layout.songs_item_listview,my_main_arraylist);
        listView_songs.setAdapter(adapter);

    }
}
