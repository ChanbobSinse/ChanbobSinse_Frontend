package com.oechyeochangmen.chanbapsinse.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eka on 2017. 7. 19..
 */

public class MenuInfo implements Parcelable {
    String name;
    Boolean selected = false;
    int price;

    public MenuInfo(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeValue(this.selected);
        dest.writeInt(this.price);
    }

    protected MenuInfo(Parcel in) {
        this.name = in.readString();
        this.selected = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.price = in.readInt();
    }

    public static final Parcelable.Creator<MenuInfo> CREATOR = new Parcelable.Creator<MenuInfo>() {
        @Override
        public MenuInfo createFromParcel(Parcel source) {
            return new MenuInfo(source);
        }

        @Override
        public MenuInfo[] newArray(int size) {
            return new MenuInfo[size];
        }
    };
}
