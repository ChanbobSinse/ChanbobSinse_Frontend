package com.oechyeochangmen.chanbapsinse.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.Space;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.oechyeochangmen.chanbapsinse.Fonts;
import com.oechyeochangmen.chanbapsinse.R;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

/**
 * Created by eka on 2017. 7. 14..
 */

public class StartActivity extends AppCompatActivity {
    private int Term = 10;
    private int count = 0;
    Fonts fonts;
    Space topSpace;
    Space bottomSpace;
    Button start_btn;
    TextView title;
    TextView content;
    TextView copyright;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.CustomAppTheme);
        setContentView(R.layout.activity_start);

        fonts = new Fonts(this);

        topSpace = (Space) findViewById(R.id.activity_start_topSpace);
        bottomSpace = (Space) findViewById(R.id.activity_start_bottomSpace);
        start_btn = (Button) findViewById(R.id.activity_start_btn);
        title = (TextView) findViewById(R.id.activity_start_title);
        content = (TextView) findViewById(R.id.activity_start_content);
        copyright = (TextView) findViewById(R.id.activity_start_copyright);

        final Handler handler = new Handler();
        final Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (count >= 50) {
                    timer.cancel();
                    start_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(StartActivity.this, Question1Activity.class);
                            intent.addFlags(FLAG_ACTIVITY_SINGLE_TOP);
                            intent.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT);
                            startActivity(intent);
                            finish();
                        }
                    });
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //weight 값 조정
                        LinearLayout.LayoutParams topParams = (LinearLayout.LayoutParams) topSpace.getLayoutParams();
                        LinearLayout.LayoutParams bottomParams = (LinearLayout.LayoutParams) bottomSpace.getLayoutParams();
                        topParams.weight -= 0.026f;
                        bottomParams.weight += 0.026f;
                        topSpace.setLayoutParams(topParams);
                        bottomSpace.setLayoutParams(bottomParams);

                        //alpha 값 조정
                        start_btn.setAlpha(start_btn.getAlpha() + 0.02f);

                        count++;
                    }
                });
            }
        }, 500, Term);


        title.setTypeface(fonts.tfRegular);
        content.setTypeface(fonts.tfLight);
        copyright.setTypeface(fonts.tfLight);
        start_btn.setTypeface(fonts.tfRegular);
    }

}
