package com.oechyeochangmen.chanbapsinse.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.oechyeochangmen.chanbapsinse.R;

import java.util.Timer;
import java.util.TimerTask;

public class SearchingActivity extends AppCompatActivity {
    ImageView imageview;
    TextView textView;
    Boolean isUp = true;
    Handler handler = new Handler();
    Timer timer = new Timer();
    int Term = 125;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);

        imageview = (ImageView) findViewById(R.id.searching_img);
        textView = (TextView) findViewById(R.id.searching_text);

        Drawable drawable = getResources().getDrawable(R.drawable.ic_splash_icon);
        drawable.setColorFilter(getResources().getColor(R.color.colorBaseBlue), PorterDuff.Mode.MULTIPLY);
        imageview.setImageDrawable(drawable);

        Shader shader = new LinearGradient(110, 0, 210, 100,
                getResources().getColor(R.color.colorBaseBlue), getResources().getColor(R.color.colorBasePurple), Shader.TileMode.CLAMP);
        textView.getPaint().setShader(shader);

        Typeface tfRegular = Typeface.createFromAsset(getAssets(), "fonts/NanumBarunGothic.ttf");
        textView.setTypeface(tfRegular);


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        if (isUp) {
                            if (textView.getAlpha() - (float) 0.1 <= 0) {
                                isUp = false;
                            }
                            textView.setAlpha(textView.getAlpha() - (float) 0.1);
                        } else {
                            if (textView.getAlpha() + (float) 0.1 >= 1) {
                                isUp = true;
                            }
                            textView.setAlpha(textView.getAlpha() + (float) 0.1);

                        }
                    }
                });
            }
        }, 100, Term);

    }
}
