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

/**
 * Created by Ha Hoan on 4/20/2016.
 */
public class AdapterMusicItem extends ArrayAdapter<MusicItem> {
    private Context context;
    private ArrayList<MusicItem> arrayList;

    public AdapterMusicItem(Context context, ArrayList<MusicItem> arrayList) {
        super(context, R.layout.music_item, arrayList);
        this.context = context;
        this.arrayList = arrayList;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = inflater.inflate(R.layout.music_item, parent, false);
        }

        ImageView imageVideo=(ImageView) convertView.findViewById(R.id.ImageVideo);
        TextView nameVideo = (TextView) convertView.findViewById(R.id.tvNameVideo);
        TextView numberLike = (TextView) convertView.findViewById(R.id.tvNumberLike);
        TextView numberView = (TextView) convertView.findViewById(R.id.tvNumberView);

        MusicItem musicItem = arrayList.get(position);
        imageVideo.setImageResource(musicItem.getImageVideo());
        nameVideo.setText(musicItem.getNameVideo());
        numberLike.setText(String.valueOf(musicItem.getNumberLike()));
        numberView.setText(String.valueOf(musicItem.getNumberView()));
        return convertView;
    }
}