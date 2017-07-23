package com.oechyeochangmen.chanbapsinse.Model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eka on 2017. 7. 17..
 */

public class Category implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bitmap bitmap = (Bitmap) ((BitmapDrawable) img).getBitmap();
        dest.writeParcelable(bitmap, flags);
        dest.writeString(this.korTitle);
        dest.writeString(this.engTitle);
        dest.writeString(this.content);
        dest.writeByte(this.checked ? (byte) 1 : (byte) 0);
    }

    protected Category(Parcel in) {
        Bitmap bitmap = in.readParcelable(getClass().getClassLoader());
        this.korTitle = in.readString();
        this.engTitle = in.readString();
        this.content = in.readString();
        this.checked = in.readByte() != 0;
        this.img = new BitmapDrawable(Resources.getSystem(),bitmap);
    }

    public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel source) {
            return new Category(source);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };
}
