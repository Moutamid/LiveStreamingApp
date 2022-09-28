package com.moutamid.livestreamingapp;

public class Model_Radio {
    String name , link;
    int image1 ;

    public Model_Radio() {
    }

    public Model_Radio(String name, String link, int image1) {
        this.name = name;
        this.link = link;
        this.image1 = image1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
