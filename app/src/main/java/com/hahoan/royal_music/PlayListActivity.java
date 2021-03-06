package com.hahoan.royal_music;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Ha Hoan on 4/19/2016.
 */
public class PlayListActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#CC0000")));
        LayoutInflater inflater = LayoutInflater.from(this);
        View  customView = inflater.inflate(R.layout.custom_actionbar, null);
        TextView title = (TextView) customView.findViewById(R.id.tvTitle);
        actionBar.setCustomView(customView);
        actionBar.setDisplayShowCustomEnabled(true);

    }
}
