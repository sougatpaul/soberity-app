package com.example.myapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class PrayerTalks1 extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prayertalks1);


        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "3MvF17wOFO8";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        YouTubePlayerView youTubePlayerView2 = findViewById(R.id.youtube_player_view2);
        getLifecycle().addObserver(youTubePlayerView2);

        youTubePlayerView2.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "3paZoyU-1aE";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        YouTubePlayerView youTubePlayerView3 = findViewById(R.id.youtube_player_view3);
        getLifecycle().addObserver(youTubePlayerView3);

        youTubePlayerView3.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "UchcO-PUgU0";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        YouTubePlayerView youTubePlayerView4 = findViewById(R.id.youtube_player_view4);
        getLifecycle().addObserver(youTubePlayerView4);

        youTubePlayerView4.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "R5kxfgY0MU0";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

    }
}
