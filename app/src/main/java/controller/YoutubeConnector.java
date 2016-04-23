package controller;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;
import com.google.api.services.youtube.model.VideoStatistics;
import com.hahoan.royal_music.R;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import model.MusicItem;

/**
 * Created by Ha Hoan on 4/22/2016.
 */
public class YoutubeConnector {
    private YouTube youTube;
    private YouTube.Search.List query;
    public static final String KEY = "AIzaSyB3MoIiLs9GdcnVCzWHAge4bR3qbY58kNI";

    public YoutubeConnector(Context context) {
        youTube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), new HttpRequestInitializer() {
            @Override
            public void initialize(HttpRequest httpRequest) throws IOException {
            }
        }).setApplicationName(context.getString(R.string.app_name)).build();
        try {
            query = youTube.search().list("id,snippet");
            query.setKey(KEY);
            query.setType("videos");
            query.setFields("items(id,snippet/title,snippet/description,snippet/thumbnails/default/url)");

        } catch (IOException e) {
            Log.v("error", "loi ket noi");
        }

    }

    public ArrayList<MusicItem> list() {
        query.setMaxResults((long) 25);
        SearchListResponse response = null;
        try {
            response = query.execute();
            ArrayList<SearchResult> results = (ArrayList<SearchResult>) response.getItems();
            ArrayList<MusicItem> items = new ArrayList<>();
            for (SearchResult result : results) {
                MusicItem videoItem = new MusicItem();
                videoItem.setId(result.getId().getVideoId());
                videoItem.setImageVideo(result.getSnippet().getThumbnails().getDefault().getUrl());
                videoItem.setNameVideo(result.getSnippet().getTitle());
                List<Video> videoList = getContainDetail(result.getId().getVideoId());
                if (videoList != null && videoList.size() > 0) {
                    Video video = videoList.get(0);
                    VideoStatistics statistics = video.getStatistics();
                    BigInteger viewCount = statistics.getViewCount();
                    videoItem.setNumberView(viewCount);
                    videoItem.setNumberLike(video.getStatistics().getLikeCount());
                }

                items.add(videoItem);
            }
            return items;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private List<Video> getContainDetail(String id) {
        try {
            YouTube.Videos.List videoRequest = youTube.videos().list("statistics");
            videoRequest.setId(id);
            videoRequest.setFields("items(statistics/viewCount,statistics/likeCount)");
            videoRequest.setKey(KEY);
            VideoListResponse response = videoRequest.execute();
            List<Video> videoList = response.getItems();
            return videoList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}
