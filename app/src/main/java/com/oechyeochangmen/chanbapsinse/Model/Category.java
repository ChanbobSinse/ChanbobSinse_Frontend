package com.oechyeochangmen.chanbapsinse.Model;

import android.graphics.drawable.Drawable;

/**
 * Created by eka on 2017. 7. 17..
 */

public class Category {
    private Drawable img;
    private String korTitle;
    private String engTitle;
    private String content;
    private boolean checked = false;

    public Category(Drawable img, String korTitle, String engTitle, String content) {
        this.img = img;
        this.korTitle = korTitle;
        this.engTitle = engTitle;
        this.content = content;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public String getKorTitle() {
        return korTitle;
    }

    public void setKorTitle(String korTitle) {
        this.korTitle = korTitle;
    }

    public String getEngTitle() {
        return engTitle;
    }

    public void setEngTitle(String engTitle) {
        this.engTitle = engTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
