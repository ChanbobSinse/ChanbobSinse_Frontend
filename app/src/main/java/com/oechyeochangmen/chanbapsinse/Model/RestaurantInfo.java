package com.oechyeochangmen.chanbapsinse.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eka on 2017. 7. 18..
 */

public class RestaurantInfo implements Parcelable {
    private String name;
    private String category;
    private String address;
    private String number;
    private float rating;

    public RestaurantInfo(String name, String category, String address, String number, float rating) {
        this.name = name;
        this.category = category;
        this.address = address;
        this.number = number;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.category);
        dest.writeString(this.address);
        dest.writeString(this.number);
        dest.writeFloat(this.rating);
    }

    protected RestaurantInfo(Parcel in) {
        this.name = in.readString();
        this.category = in.readString();
        this.address = in.readString();
        this.number = in.readString();
        this.rating = in.readFloat();
    }

    public static final Parcelable.Creator<RestaurantInfo> CREATOR = new Parcelable.Creator<RestaurantInfo>() {
        @Override
        public RestaurantInfo createFromParcel(Parcel source) {
            return new RestaurantInfo(source);
        }

        @Override
        public RestaurantInfo[] newArray(int size) {
            return new RestaurantInfo[size];
        }
    };
}
