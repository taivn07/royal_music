package com.hahoan.royal_music;

import android.app.ActionBar;
import android.app.SearchManager;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;
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
                .setIndicator("",res.getDrawable(R.drawable.rank))
                .setContent(intent);
        tabHost.addTab(spec);

        intent =new Intent().setClass(this, SearchingActivity.class);
        spec = tabHost.newTabSpec("searching")
                .setIndicator("",res.getDrawable(R.drawable.search))
                .setContent(intent);
        tabHost.addTab(spec);

        intent =new Intent().setClass(this, PlayingActivity.class);
        spec = tabHost.newTabSpec("playing")
                .setIndicator("", res.getDrawable(R.drawable.playicon))
                .setContent(intent);
        tabHost.addTab(spec);

        intent =  new Intent().setClass(this, PlayListActivity.class);
        spec = tabHost.newTabSpec("playlist")
                .setIndicator("",res.getDrawable(R.drawable.list))
                .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, HistoryActivity.class);
        spec = tabHost.newTabSpec("history")
                .setIndicator("",res.getDrawable(R.drawable.history))
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        return super.onCreateOptionsMenu(menu);

    }
}
