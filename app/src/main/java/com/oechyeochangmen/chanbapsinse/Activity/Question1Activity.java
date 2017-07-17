package com.oechyeochangmen.chanbapsinse.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.oechyeochangmen.chanbapsinse.Adapter.CategoryRecyclerViewAdpater;
import com.oechyeochangmen.chanbapsinse.Model.Category;
import com.oechyeochangmen.chanbapsinse.R;

import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

public class Question1Activity extends AppCompatActivity {
    public static Question1Activity activity = null;
    Button next_btn;
    TextView question;
    TextView content;
    ArrayList<Category> items = new ArrayList<>();
    RecyclerView listView;
    CategoryRecyclerViewAdpater recyclerViewAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        activity = this;

        next_btn = (Button) findViewById(R.id.question1_btn_next);
        question = (TextView) findViewById(R.id.question1_question);
        content = (TextView) findViewById(R.id.question1_content);
        listView = (RecyclerView) findViewById(R.id.question1_recyclerView);

        initItems();
        recyclerViewAdpater = new CategoryRecyclerViewAdpater(this, items);
        listView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        listView.setAdapter(recyclerViewAdpater);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = false;
                for (Category item : items) {
                    if (item.isChecked()) {
                        isChecked = true;
                        break;
                    }
                }
                if (!isChecked) {
                    Toast.makeText(Question1Activity.this, "1개 이상 체크 해야합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(Question1Activity.this, Question2Activity.class);
                intent.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                isChecked = false;

            }
        });
        Typeface tfRegular = Typeface.createFromAsset(getAssets(), "fonts/NanumBarunGothic.ttf");
        Typeface tfBold = Typeface.createFromAsset(getAssets(), "fonts/NanumBarunGothicBold.ttf");
        question.setTypeface(tfBold);
        content.setTypeface(tfRegular);
        next_btn.setTypeface(tfRegular);
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
                "보족", "Bossam /\nPork feet", "고기가 땡기니\n쌈 채소 섭취를 명분으로"));
        items.add(new Category(getResources().getDrawable(R.drawable.category_snackfood),
                "분식", "Snack bar", "한식의 연장선,\n우리 모두의 친구"));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Question2Activity.activity != null) {
            Question2Activity.activity.finish();
        }
    }
}
