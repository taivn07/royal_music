package controller;

import android.content.Context;
import android.content.Intent;

import com.hahoan.royal_music.PlayingActivity;

/**
 * Created by Ha Hoan on 4/23/2016.
 */
public class VideoManager {
   public void clickVideoItem(Context context,String videoId){
        Intent intent = new Intent(context, PlayingActivity.class);
        intent.putExtra("VIDEOID", videoId);
        context.startActivity(intent);
    }
}
