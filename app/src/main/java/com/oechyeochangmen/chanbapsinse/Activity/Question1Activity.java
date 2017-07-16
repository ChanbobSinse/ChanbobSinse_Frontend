package com.oechyeochangmen.chanbapsinse.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.oechyeochangmen.chanbapsinse.R;

public class Question1Activity extends AppCompatActivity {
    Button next_btn;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        next_btn = (Button) findViewById(R.id.question1_btn_next);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Question1Activity.this, Question2Activity.class);
                startActivity(intent);

            }
        });
    }
}
