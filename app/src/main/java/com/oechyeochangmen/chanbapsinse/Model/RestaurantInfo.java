package com.oechyeochangmen.chanbapsinse.Model;

/**
 * Created by eka on 2017. 7. 18..
 */

public class RestaurantInfo {
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
}
