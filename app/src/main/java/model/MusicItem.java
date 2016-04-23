package model;

import java.math.BigInteger;

/**
 * Created by Ha Hoan on 4/19/2016.
 */
public class MusicItem {
    private String id;
    private String imageVideo;
    private String nameVideo;
    private BigInteger numberLike;
    private BigInteger numberView;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageVideo() {
        return imageVideo;
    }

    public void setImageVideo(String imageVideo) {
        this.imageVideo = imageVideo;
    }

    public String getNameVideo() {
        return nameVideo;
    }

    public void setNameVideo(String nameVideo) {
        this.nameVideo = nameVideo;
    }

    public BigInteger getNumberLike() {
        return numberLike;
    }

    public void setNumberLike(BigInteger numberLike) {
        this.numberLike = numberLike;
    }

    public BigInteger getNumberView() {
        return numberView;
    }

    public void setNumberView(BigInteger numberView) {
        this.numberView = numberView;
    }
}
