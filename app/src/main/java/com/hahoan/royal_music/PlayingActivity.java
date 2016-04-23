package com.hahoan.royal_music;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import controller.YoutubeConnector;

/**
 * Created by Ha Hoan on 4/19/2016.
 */
public class PlayingActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private YouTubePlayerView youTubePlayerView;
    private ImageButton btnBack, btnNext;
    private SeekBar seekBar;
    private YouTubePlayer yp;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.player_activity);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.player_view);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        youTubePlayerView.initialize(YoutubeConnector.KEY, this);


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean b) {
        if (!b) {
              youTubePlayer.loadVideo(getIntent().getStringExtra("VIDEOID"));
              yp = youTubePlayer;
            seekBar.setMax(100000);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    seekBar.setProgress(youTubePlayer.getDurationMillis());
                    Log.v("dur:"+youTubePlayer.getDurationMillis(),"");
                }
            }).start();

            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    youTubePlayer.seekToMillis(progress);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, R.string.failed, Toast.LENGTH_SHORT).show();
    }


}
