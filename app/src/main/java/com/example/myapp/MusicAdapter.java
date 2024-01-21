package com.example.myapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Music> myArraylist;
    private MediaPlayer mediaPlayer;
    private boolean flag=true;

    public MusicAdapter(Context context, int layout, ArrayList<Music> myArraylist) {
        this.context = context;
        this.layout = layout;
        this.myArraylist = myArraylist;
    }

    @Override
    public int getCount() {
        return myArraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return myArraylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder{
        TextView textView_songName,textView_artist;
        ImageView imageView_play,imageView_stop;
        private View convertview;
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        public ViewHolder(){
            convertview=layoutInflater.inflate(layout,null);
            textView_songName=convertview.findViewById(R.id.textview_songs);
            textView_artist=convertview.findViewById(R.id.textview_artist);
            imageView_play=convertview.findViewById(R.id.imageview_play);
            imageView_stop=convertview.findViewById(R.id.imageview_stop);

        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder=new ViewHolder();
        if (convertView==null){
            convertView=viewHolder.convertview;
        } else {

        }
        final Music music=myArraylist.get(position);
        viewHolder.textView_songName.setText(music.getSongName());
        viewHolder.textView_artist.setText(music.getArtist());
        viewHolder.imageView_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag){
                    mediaPlayer=MediaPlayer.create(context,music.getSongs());
                    flag=false;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    viewHolder.imageView_play.setImageResource(R.drawable.play1);
                }else {
                    mediaPlayer.start();
                    viewHolder.imageView_play.setImageResource(R.drawable.pause);
                }
               // mediaPlayer.start();
            }
        });
        viewHolder.imageView_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!flag){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    flag=true;
                }
                viewHolder.imageView_stop.setImageResource(R.drawable.stop1);
            }
        });
        return convertView;
    }
}
