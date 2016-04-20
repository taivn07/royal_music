package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hahoan.royal_music.R;

import java.util.ArrayList;

import model.MusicItem;
import model.RankingItem;

/**
 * Created by Ha Hoan on 4/20/2016.
 */
public class AdapterRankingItem extends ArrayAdapter<RankingItem> {
    private Context context;
    private ArrayList<RankingItem> arrayList;

    public AdapterRankingItem(Context context, ArrayList<RankingItem> arrayList) {
        super(context, R.layout.ranking_item, arrayList);
        this.context = context;
        this.arrayList = arrayList;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.ranking_item, parent, false);
        }

        ImageView imageVideo = (ImageView) convertView.findViewById(R.id.imageItem);
        TextView name = (TextView) convertView.findViewById(R.id.tvName);
        TextView number = (TextView) convertView.findViewById(R.id.tvNumberRank);

        RankingItem rankingItem = arrayList.get(position);
        imageVideo.setImageResource(rankingItem.getImage());
        name.setText(rankingItem.getName());
        number.setText(String.valueOf(rankingItem.getNumberRank()));

        return convertView;
    }
}
