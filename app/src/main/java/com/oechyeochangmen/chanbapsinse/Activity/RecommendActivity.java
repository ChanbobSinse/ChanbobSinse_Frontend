package com.oechyeochangmen.chanbapsinse.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.oechyeochangmen.chanbapsinse.Adapter.RestaurantRecyclerViewAdapter;
import com.oechyeochangmen.chanbapsinse.Adapter.SelectedCategoryRecyclerViewAdapter;
import com.oechyeochangmen.chanbapsinse.Fonts;
import com.oechyeochangmen.chanbapsinse.GpsInfo;
import com.oechyeochangmen.chanbapsinse.Model.Category;
import com.oechyeochangmen.chanbapsinse.Model.RestaurantInfo;
import com.oechyeochangmen.chanbapsinse.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import static android.content.Intent.FLAG_ACTIVITY_NO_HISTORY;
import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;
import static com.oechyeochangmen.chanbapsinse.Activity.MapsActivity.MY_FINE_LOCATION;

public class RecommendActivity extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor pref_edit;

    ArrayList<RestaurantInfo> restaurantInfos = new ArrayList<>();
    ArrayList<Category> categories = new ArrayList<>();
    Fonts fonts;

    SelectedCategoryRecyclerViewAdapter categoryRecyclerViewAdapter;
    RestaurantRecyclerViewAdapter restaurantRecyclerViewAdapter;

    LinearLayout container;
    RecyclerView selectedRecyclerView;
    RecyclerView restaurantRecyclerView;
    Button button;
    ImageButton imageButton;
    TextView topText, bottomText;
    TextView text1, text2;
    TextView range;
    TextView address;
    TextView failedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fonts = new Fonts(this);

        pref = getSharedPreferences("value", MODE_PRIVATE);
        pref_edit = pref.edit();

        final Intent intent = new Intent(RecommendActivity.this, SearchingActivity.class);
        intent.addFlags(FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);

        setContentView(R.layout.activity_recommend);

        container = (LinearLayout) findViewById(R.id.recommend_container);
        selectedRecyclerView = (RecyclerView) findViewById(R.id.recommend_category);
        restaurantRecyclerView = (RecyclerView) findViewById(R.id.recommend_recyclerView);
        button = (Button) findViewById(R.id.recommend_btn);
        imageButton = (ImageButton) findViewById(R.id.recommend_map);
        topText = (TextView) findViewById(R.id.recommend_topText);
        bottomText = (TextView) findViewById(R.id.recommend_bottomText);
        text1 = (TextView) findViewById(R.id.recommend_Text1);
        text2 = (TextView) findViewById(R.id.recommend_Text2);
        range = (TextView) findViewById(R.id.recommend_range);
        address = (TextView) findViewById(R.id.recommend_address);
        failedText = (TextView) findViewById(R.id.recommend_failedText);

        DecimalFormat format = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = format.getDecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        format.setDecimalFormatSymbols(symbols);
        Long min = pref.getLong("min", 0);
        Long max = pref.getLong("max", 0);
        Long error = pref.getLong("error", 0);
        String string = format.format(min) + " ₩ ~ " + format.format(max) + " ₩\n± " + format.format(error);

        range.setText(string);

        for (Category category : Question1Activity.items) {
            if (category.isChecked()) {
                categories.add(category);
            }
        }

        categoryRecyclerViewAdapter = new SelectedCategoryRecyclerViewAdapter(categories, this);
        selectedRecyclerView.setLayoutManager(new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        selectedRecyclerView.setAdapter(categoryRecyclerViewAdapter);

        restaurantInfos.add(new RestaurantInfo("마카나이", "Japanese Food", "서울시 용산구 청파로 45길 11", "02-711-2016", 4.0f));
        restaurantRecyclerViewAdapter = new RestaurantRecyclerViewAdapter(restaurantInfos, this);
        restaurantRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        restaurantRecyclerViewAdapter.setOnItemClick(new RestaurantRecyclerViewAdapter.onItemClick() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent1 = new Intent(RecommendActivity.this, SelectActivity.class);
                intent1.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent1.putExtra("restaurantInfo", restaurantInfos.get(position));
                startActivity(intent1);
            }
        });
        restaurantRecyclerView.setAdapter(restaurantRecyclerViewAdapter);

        if (restaurantInfos.size() == 0) {
            restaurantRecyclerView.setVisibility(View.INVISIBLE);
            container.setVisibility(View.VISIBLE);
            button.setText("다시 검색하기");
        } else {
            container.setVisibility(View.INVISIBLE);
            restaurantRecyclerView.setVisibility(View.VISIBLE);
            button.setText("결정하시기가 힘드신가요? 알아서 골라드립니다!");
        }

        range.setTypeface(fonts.tfLight);
        failedText.setTypeface(fonts.tfRegular);
        address.setTypeface(fonts.tfRegular);
        button.setTypeface(fonts.tfRegular);
        text1.setTypeface(fonts.tfRegular);
        text2.setTypeface(fonts.tfRegular);
        topText.setTypeface(fonts.tfRegular);
        bottomText.setTypeface(fonts.tfRegular);
        bottomText.setTypeface(fonts.tfRegular);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(RecommendActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(RecommendActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(RecommendActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_FINE_LOCATION);

                }

                Intent intent1 = new Intent(RecommendActivity.this, MapsActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(RecommendActivity.this, Question2Activity.class);
        intent.addFlags(FLAG_ACTIVITY_SINGLE_TOP);
        intent.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_FINE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    return;
                } else {
                    Toast.makeText(this, "사용 권한이 없습니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }

                break;
            default:
                finish();
        }
    }
}
