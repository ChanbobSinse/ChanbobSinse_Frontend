package com.oechyeochangmen.chanbapsinse.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.oechyeochangmen.chanbapsinse.Adapter.Menu2RecyclerViewAdapter;
import com.oechyeochangmen.chanbapsinse.Fonts;
import com.oechyeochangmen.chanbapsinse.Model.MenuInfo;
import com.oechyeochangmen.chanbapsinse.Model.RestaurantInfo;
import com.oechyeochangmen.chanbapsinse.R;

import java.util.ArrayList;

public class CompleteActivity extends AppCompatActivity {
    Fonts fonts;

    ArrayList<MenuInfo> menuInfos = new ArrayList<>();
    RestaurantInfo restaurantInfo;
    RecyclerView recyclerView;
    TextView topText, bottomText;
    TextView restaurant, menu_price;
    TextView restaurant_name, restaurant_category,
            restaurant_number, restaurant_address;
    Button prev, complete;
    RatingBar ratingBar;
    Menu2RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        fonts = new Fonts(this);

        menuInfos = getIntent().getParcelableArrayListExtra("menuInfos");
        restaurantInfo = getIntent().getParcelableExtra("restaurantInfo");

        recyclerView = (RecyclerView) findViewById(R.id.complete_recyclerView);
        prev = (Button) findViewById(R.id.complete_btn_prev);
        complete = (Button) findViewById(R.id.complete_btn_complete);
        topText = (TextView) findViewById(R.id.complete_topText);
        bottomText = (TextView) findViewById(R.id.complete_bottomText);
        restaurant = (TextView) findViewById(R.id.complete_restaurant);
        menu_price = (TextView) findViewById(R.id.complete_menu);
        restaurant_name = (TextView) findViewById(R.id.complete_restaurant_name);
        restaurant_category = (TextView) findViewById(R.id.complete_restaurant_category);
        restaurant_number = (TextView) findViewById(R.id.complete_restaurant_number);
        restaurant_address = (TextView) findViewById(R.id.complete_restaurant_address);
        ratingBar = (RatingBar) findViewById(R.id.complete_restaurant_ratingBar);

        recyclerViewAdapter = new Menu2RecyclerViewAdapter(menuInfos, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(recyclerViewAdapter);

        prev.setTypeface(fonts.tfRegular);
        complete.setTypeface(fonts.tfRegular);
        topText.setTypeface(fonts.tfRegular);
        bottomText.setTypeface(fonts.tfRegular);
        restaurant_name.setTypeface(fonts.tfRegular);
        restaurant.setTypeface(fonts.tfRegular);
        menu_price.setTypeface(fonts.tfRegular);
        restaurant_category.setTypeface(fonts.tfLight);
        restaurant_address.setTypeface(fonts.tfLight);
        restaurant_number.setTypeface(fonts.tfLight);
    }
}
