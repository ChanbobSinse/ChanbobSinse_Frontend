package com.oechyeochangmen.chanbapsinse.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.oechyeochangmen.chanbapsinse.Adapter.CategoryRecyclerViewAdapater;
import com.oechyeochangmen.chanbapsinse.Fonts;
import com.oechyeochangmen.chanbapsinse.Model.Category;
import com.oechyeochangmen.chanbapsinse.R;

import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

public class Question1Activity extends AppCompatActivity {

    public static ArrayList<Category> items = new ArrayList<>();

    Fonts fonts;

    Button next_btn;
    TextView question;
    TextView content;
    RecyclerView listView;
    CategoryRecyclerViewAdapater recyclerViewAdpater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        if (items.isEmpty()){
            initItems();
        }
        fonts = new Fonts(this);

        next_btn = (Button) findViewById(R.id.question1_btn_next);
        question = (TextView) findViewById(R.id.question1_question);
        content = (TextView) findViewById(R.id.question1_content);
        listView = (RecyclerView) findViewById(R.id.question1_recyclerView);
        recyclerViewAdpater = new CategoryRecyclerViewAdapater(this, items);
        listView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        listView.setAdapter(recyclerViewAdpater);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                for (Category item : items) {
                    if (item.isChecked()) {
                        count++;
                    }
                }
                if (count == 0) {
                    Toast.makeText(Question1Activity.this, "1개 이상 체크 해야합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (count > 6) {
                    Toast.makeText(Question1Activity.this, "카테고리 선택은 6개 까지만 가능 합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(Question1Activity.this, Question2Activity.class);
                intent.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
        question.setTypeface(fonts.tfBold);
        content.setTypeface(fonts.tfRegular);
        next_btn.setTypeface(fonts.tfRegular);
    }

    public void initItems() {
        items.add(new Category(getResources().getDrawable(R.drawable.category_koreanfood),
                "한식", "Korean Food", "오늘따라 집밥이 그리울 때,\n밖에서 먹는 우리집의 맛"));
        items.add(new Category(getResources().getDrawable(R.drawable.category_japanesefood),
                "일식", "Japanese Food", "초밥, 돈까스, 회, 카레 등등...\n익숙하지만 언제든 먹고싶은 음식"));
        items.add(new Category(getResources().getDrawable(R.drawable.category_chinesefood),
                "중식", "Chinese Food", "배달음식의 대명사,\n여기 짜장 둘 짬뽕 하나요~"));
        items.add(new Category(getResources().getDrawable(R.drawable.category_westernfood),
                "양식", "Western Food", "평소에 먹지 않던 이색적인 맛을\n경험하고 싶을 때"));
        items.add(new Category(getResources().getDrawable(R.drawable.category_chicken),
                "치킨", "Chicken", "언제나 옳으신 그 분,\n치느님"));
        items.add(new Category(getResources().getDrawable(R.drawable.category_pizza),
                "피자", "Pizza", "영원한 치느님의 동무,\n쭈욱 늘어나는 치즈를 맘껏 먹고싶을 때"));
        items.add(new Category(getResources().getDrawable(R.drawable.category_bossam),
                "보쌈/족발", "Bossam /\nPork feet", "고기가 땡기니\n쌈 채소 섭취를 명분으로"));
        items.add(new Category(getResources().getDrawable(R.drawable.category_snackfood),
                "분식", "Snack bar", "한식의 연장선,\n우리 모두의 친구"));
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    @Override
    protected void onDestroy() {
        items.clear();
        super.onDestroy();
    }
}
