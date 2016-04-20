package com.hahoan.royal_music;

import android.app.ActionBar;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        final TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        intent =new Intent().setClass(this, RankingActivity.class);
        spec = tabHost.newTabSpec("ranking")
                .setIndicator(res.getString(R.string.ranking))
                .setContent(intent);
        tabHost.addTab(spec);

        intent =new Intent().setClass(this, SearchingActivity.class);
        spec = tabHost.newTabSpec("searching")
                .setIndicator(res.getString(R.string.searching))
                .setContent(intent);
        tabHost.addTab(spec);

        intent =new Intent().setClass(this, PlayingAcitivity.class);
        spec = tabHost.newTabSpec("playing")
                .setIndicator(res.getString(R.string.playing))
                .setContent(intent);
        tabHost.addTab(spec);

        intent =  new Intent().setClass(this, PlayListActivity.class);
        spec = tabHost.newTabSpec("playlist")
                .setIndicator(res.getString(R.string.playlist))
                .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, HistoryActivity.class);
        spec = tabHost.newTabSpec("history")
                .setIndicator(res.getString(R.string.history))
                .setContent(intent);
        tabHost.addTab(spec);

        for(int i=0;i<tabHost.getTabWidget().getTabCount();i++){
           TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(Color.WHITE);
            tv.setTextSize(6);
        }

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                for(int i=0;i<tabHost.getTabWidget().getTabCount();i++){
                    TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
                    tv.setTextColor(Color.WHITE);
                    tv.setTextSize(6);
                }
                TextView tv = (TextView) tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).findViewById(android.R.id.title);
                tv.setTextColor(Color.parseColor("#AAAAAA"));
                tv.setTextSize(6);
            }
        });

    }
}
