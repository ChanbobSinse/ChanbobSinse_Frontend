package com.oechyeochangmen.chanbapsinse.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.oechyeochangmen.chanbapsinse.Fonts;
import com.oechyeochangmen.chanbapsinse.R;

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

public class Question1Activity extends AppCompatActivity {
    public static Question1Activity activity = null;
    Button next_btn;
    TextView question;
    TextView content;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        activity = this;

        next_btn = (Button) findViewById(R.id.question1_btn_next);
        question = (TextView) findViewById(R.id.question1_question);
        content = (TextView) findViewById(R.id.question1_content);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Question1Activity.this, Question2Activity.class);
                intent.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);

            }
        });

        Fonts fonts = new Fonts(this);
        question.setTypeface(fonts.tfBold);
        content.setTypeface(fonts.tfRegular);
        next_btn.setTypeface(fonts.tfRegular);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Question2Activity.activity != null) {
            Question2Activity.activity.finish();
        }
    }
}
