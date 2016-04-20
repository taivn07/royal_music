package com.hahoan.royal_music;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import Adapter.AdapterMusicItem;
import model.MusicItem;

/**
 * Created by Ha Hoan on 4/19/2016.
 */
public class HistoryActivity extends Activity {
    ListView lvHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        lvHistory = (ListView) findViewById(R.id.lvHistory);
        ArrayList<MusicItem> arr=new ArrayList<>();
        arr.add(new MusicItem(R.drawable.anhgau,"NameSong",12345,23));
        AdapterMusicItem adapter = new AdapterMusicItem(this,arr);
        lvHistory.setAdapter(adapter);

    }

}
