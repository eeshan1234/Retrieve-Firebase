package com.example.application.trial.categories1;

public class model {
    private int image;
    private String title;
    private String desc;
    private int pos;

    public model(int image, String title, String desc,int pos) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.pos=pos;
    }



    public int getImage() {
        return image;
    }
    public int getPos() {
        return pos;
    }

    public void setImage(int image) {
        this.image = image;
    }
    public void setPos(int pos) {
        this.pos = pos;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
