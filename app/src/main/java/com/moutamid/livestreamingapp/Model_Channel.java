package com.moutamid.livestreamingapp;

public class Model_Channel {
    String name , des , cast , time , link;
    int image1 ;
    boolean isFavourite = false;

    public Model_Channel() {
    }

    public Model_Channel(String name, String des, String cast, String time, String link, int image1, boolean isFavourite) {
        this.name = name;
        this.des = des;
        this.cast = cast;
        this.time = time;
        this.link = link;
        this.image1 = image1;
        this.isFavourite = isFavourite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;//THANKS :)
    }
}
