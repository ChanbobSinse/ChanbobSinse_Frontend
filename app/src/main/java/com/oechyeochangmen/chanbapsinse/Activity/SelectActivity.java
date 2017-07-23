package com.oechyeochangmen.chanbapsinse.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.oechyeochangmen.chanbapsinse.Adapter.MenuRecyclerViewAdapter;
import com.oechyeochangmen.chanbapsinse.Fonts;
import com.oechyeochangmen.chanbapsinse.Model.MenuInfo;
import com.oechyeochangmen.chanbapsinse.Model.RestaurantInfo;
import com.oechyeochangmen.chanbapsinse.R;

import java.util.ArrayList;

public class SelectActivity extends AppCompatActivity {

    Fonts fonts;

    RecyclerView recyclerView;
    MenuRecyclerViewAdapter menuRecyclerViewAdapter;
    ArrayList<MenuInfo> menuInfos = new ArrayList<>();
    RestaurantInfo restaurantInfo;
    Button button;
    TextView restaurant_name;
    TextView restaurant_category;
    TextView restaurant_address;
    TextView restaurant_number;
    RatingBar restaurant_rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        fonts = new Fonts(this);

        restaurantInfo = getIntent().getParcelableExtra("restaurantInfo");

        recyclerView = (RecyclerView) findViewById(R.id.select_menu_recyclerView);
        button = (Button) findViewById(R.id.select_next_btn);
        restaurant_name = (TextView) findViewById(R.id.select_restaurant_name);
        restaurant_category = (TextView) findViewById(R.id.select_restaurant_category);
        restaurant_address = (TextView) findViewById(R.id.select_restaurant_address);
        restaurant_number = (TextView) findViewById(R.id.select_restaurant_number);
        restaurant_rating = (RatingBar) findViewById(R.id.select_restaurant_ratingBar);

        menuInfos.add(new MenuInfo("삼겹살 덮밥", 6000));

        menuRecyclerViewAdapter = new MenuRecyclerViewAdapter(menuInfos, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(menuRecyclerViewAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectActivity.this, CompleteActivity.class);
                intent.putExtra("restaurantInfo", restaurantInfo);
                intent.putParcelableArrayListExtra("menuInfos", menuInfos);
                startActivity(intent);
            }
        });

        restaurant_name.setText(restaurantInfo.getName());
        restaurant_category.setText(restaurantInfo.getCategory());
        restaurant_address.setText(restaurantInfo.getAddress());
        restaurant_number.setText(restaurantInfo.getNumber());
        restaurant_rating.setRating(restaurantInfo.getRating());


        button.setTypeface(fonts.tfRegular);
        restaurant_name.setTypeface(fonts.tfRegular);
        restaurant_category.setTypeface(fonts.tfRegular);
        restaurant_address.setTypeface(fonts.tfRegular);
        restaurant_number.setTypeface(fonts.tfRegular);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SelectActivity.this,RecommendActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}
