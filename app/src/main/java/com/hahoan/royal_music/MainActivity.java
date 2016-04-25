package com.hahoan.royal_music;

import android.app.ActionBar;
import android.app.SearchManager;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends TabActivity {
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Resources res = getResources();
        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        Intent intent = new Intent().setClass(this,RankingActivity.class);
        setupTab(intent,res.getString(R.string.ranking),R.drawable.rank);

        intent = new Intent().setClass(this,SearchingActivity.class);
        setupTab(intent,res.getString(R.string.searching),R.drawable.search);

        intent = new Intent().setClass(this,PlayingActivity.class);
        setupTab(intent,res.getString(R.string.playlist),R.drawable.playicon);

        intent = new Intent().setClass(this,PlayListActivity.class);
        setupTab(intent,res.getString(R.string.playlist),R.drawable.list);

        intent = new Intent().setClass(this,HistoryActivity.class);
        setupTab(intent,res.getString(R.string.history),R.drawable.history);

//        final TabHost tabHost = getTabHost();
//        TabHost.TabSpec spec;
//        Intent intent;
//
//
//        intent =new Intent().setClass(this, RankingActivity.class);
//        spec = tabHost.newTabSpec("ranking")
//                .setIndicator(res.getString(R.string.ranking),res.getDrawable(R.drawable.rank))
//                .setContent(intent);
//        tabHost.addTab(spec);
//
//
//        intent =new Intent().setClass(this, SearchingActivity.class);
//        spec = tabHost.newTabSpec("searching")
//                .setIndicator(res.getString(R.string.search),res.getDrawable(R.drawable.search))
//                .setContent(intent);
//        tabHost.addTab(spec);
//
//        intent =new Intent().setClass(this, PlayingActivity.class);
//        spec = tabHost.newTabSpec("playing")
//                .setIndicator(res.getString(R.string.playing), res.getDrawable(R.drawable.playicon))
//                .setContent(intent);
//        tabHost.addTab(spec);
//
//        intent =  new Intent().setClass(this, PlayListActivity.class);
//        spec = tabHost.newTabSpec("playlist")
//                .setIndicator(res.getString(R.string.playlist),res.getDrawable(R.drawable.list))
//                .setContent(intent);
//        tabHost.addTab(spec);
//
//        intent = new Intent().setClass(this, HistoryActivity.class);
//        spec = tabHost.newTabSpec("history")
//                .setIndicator(res.getString(R.string.history),res.getDrawable(R.drawable.history))
//                .setContent(intent);
//        tabHost.addTab(spec);
//
//        for(int i=0;i<tabHost.getTabWidget().getTabCount();i++){
//           TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
//            tv.setTextColor(Color.WHITE);
//            tv.setTextSize(6);
//            tv.setSingleLine();
//        }
//
//
//        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
//            @Override
//            public void onTabChanged(String tabId) {
//                for (int i = 0; i < tabHost.getTabWidget().getTabCount(); i++) {
//                    TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
//                    tv.setTextColor(Color.WHITE);
//                    tv.setTextSize(6);
//                    tv.setSingleLine();
//                }
//                TextView tv = (TextView) tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).findViewById(android.R.id.title);
//                tv.setTextColor(Color.parseColor("#AAAAAA"));
//                tv.setTextSize(6);
//            }
//        });

    }
    void setupTab(Intent  intent, String title, int icon){
        View tabView = createTabView(this,title,icon);
        TabHost.TabSpec spec = tabHost.newTabSpec(title).setIndicator(tabView).setContent(intent);
        tabHost.addTab(spec);
    }
    View createTabView( Context context,String title, int icon){
        View view = LayoutInflater.from(context).inflate(R.layout.tab_indicator,null);
        TextView tvTitle = (TextView) view.findViewById(R.id.title);
        tvTitle.setText(title);
        ImageView igIcon = (ImageView) view.findViewById(R.id.icon);
        igIcon.setImageResource(icon);
        return view;

    }

}
