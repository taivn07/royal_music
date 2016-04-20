package model;

/**
 * Created by Ha Hoan on 4/19/2016.
 */
public class MusicItem {
    private int imageVideo;
    private String nameVideo;
    private int numberLike;
    private int numberView;

    public MusicItem(int imageVideo, String nameVideo, int numberLike, int numberView) {
        this.imageVideo = imageVideo;
        this.nameVideo = nameVideo;
        this.numberLike = numberLike;
        this.numberView = numberView;
    }

    public int getImageVideo() {
        return imageVideo;
    }

    public void setImageVideo(int imageVideo) {
        this.imageVideo = imageVideo;
    }

    public String getNameVideo() {
        return nameVideo;
    }

    public void setNameVideo(String nameVideo) {
        this.nameVideo = nameVideo;
    }

    public int getNumberLike() {
        return numberLike;
    }

    public void setNumberLike(int numberLike) {
        this.numberLike = numberLike;
    }

    public int getNumberView() {
        return numberView;
    }

    public void setNumberView(int numberView) {
        this.numberView = numberView;
    }
}
