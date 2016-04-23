package com.hahoan.royal_music;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import Adapter.AdapterMusicItem;
import controller.VideoManager;
import controller.YoutubeConnector;
import model.MusicItem;

/**
 * Created by Ha Hoan on 4/19/2016.
 */
public class SearchingActivity extends ActionBarActivity {
    private EditText edSearch;
    private ListView lvVideo;
    private ArrayList<MusicItem> resultsVideos = new ArrayList<>();
    private Handler handle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#CC0000")));
        actionBar.setDisplayShowTitleEnabled(false);

        edSearch = (EditText) findViewById(R.id.edSearch);
        lvVideo = (ListView) findViewById(R.id.lvSearch);
        handle = new Handler();
        listOnYoutube();
        edSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    searchOnYoutube(edSearch.getText().toString());
                    return false;
                }
                return true;
            }
        });
        addClickListener();

    }

    private void searchOnYoutube(final String keyword) {
        new Thread() {
            @Override
            public void run() {
                YoutubeConnector yc = new YoutubeConnector(SearchingActivity.this);
                //  resultsVideos = yc.search(keyword);
                handle.post(new Runnable() {
                    @Override
                    public void run() {
                        if (resultsVideos != null)
                            updateVideoFound();
                    }
                });

            }
        }.start();
    }

    private void listOnYoutube() {
        new Thread() {
            @Override
            public void run() {
                YoutubeConnector yc = new YoutubeConnector(SearchingActivity.this);
                resultsVideos = yc.list();
                handle.post(new Runnable() {
                    @Override
                    public void run() {
                        if (resultsVideos != null)
                            updateVideoFound();
                    }
                });

            }
        }.start();
    }

    private void updateVideoFound() {
        AdapterMusicItem adapter = new AdapterMusicItem(SearchingActivity.this, resultsVideos);
        lvVideo.setAdapter(adapter);
    }

    public void addClickListener() {
        lvVideo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                VideoManager videoManager = new VideoManager();
                videoManager.clickVideoItem(SearchingActivity.this, resultsVideos.get(position).getId());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
