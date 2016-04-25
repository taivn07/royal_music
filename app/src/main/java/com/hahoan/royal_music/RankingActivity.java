package com.hahoan.royal_music;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Ha Hoan on 4/19/2016.
 */
public class RankingActivity extends ActionBarActivity {
    private ListView lvRanking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        getViewActionBar();
        getView();
    }
    private void getViewActionBar(){
        ActionBar actionBar  = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#CC0000")));
        LayoutInflater inflater = LayoutInflater.from(this);
        View customView = inflater.inflate(R.layout.custom_actionbar, null);
        TextView title = (TextView) customView.findViewById(R.id.tvTitle);
        title.setText(getResources().getString(R.string.app_name));
        actionBar.setCustomView(customView);
        actionBar.setDisplayShowCustomEnabled(true);
    }
    private void getView(){
        lvRanking = (ListView) findViewById(R.id.lvRanking);

    }
}
