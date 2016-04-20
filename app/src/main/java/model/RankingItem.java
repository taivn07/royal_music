package model;

/**
 * Created by Ha Hoan on 4/20/2016.
 */
public class RankingItem {
    private int image;
    private String name;
    private int numberRank;

    public RankingItem(int image, String name, int numberRank) {
        this.image = image;
        this.name = name;
        this.numberRank = numberRank;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberRank() {
        return numberRank;
    }

    public void setNumberRank(int numberRank) {
        this.numberRank = numberRank;
    }
}
