package com.hahoan.royal_music;

import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import model.MusicItem;

/**
 * Created by Ha Hoan on 4/19/2016.
 */
public class HistoryActivity extends ActionBarActivity {
    ListView lvHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        viewActionBar();
        getView();



    }
    void getView(){
        lvHistory = (ListView) findViewById(R.id.lvHistory);
    }

    void viewActionBar(){
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#CC0000")));
        LayoutInflater inflater = LayoutInflater.from(this);

        View customView = inflater.inflate(R.layout.custom_actionbar,null);
        TextView title = (TextView) customView.findViewById(R.id.tvTitle);
        title.setText(getResources().getString(R.string.history));
        actionBar.setCustomView(customView);
        actionBar.setDisplayShowCustomEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);

    }
}
