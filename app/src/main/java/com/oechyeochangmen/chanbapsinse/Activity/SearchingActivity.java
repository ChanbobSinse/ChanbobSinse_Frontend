package com.oechyeochangmen.chanbapsinse.Activity;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.oechyeochangmen.chanbapsinse.Fonts;
import com.oechyeochangmen.chanbapsinse.R;

import java.util.Timer;
import java.util.TimerTask;

public class SearchingActivity extends AppCompatActivity {
    Fonts fonts;
    ImageView imageview;
    TextView textView;
    Boolean isUp = true;
    Handler handler = new Handler();
    Timer timer = new Timer();
    int Term = 125;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);

        fonts = new Fonts(this);

        imageview = (ImageView) findViewById(R.id.searching_img);
        textView = (TextView) findViewById(R.id.searching_text);

//        Drawable drawable = getResources().getDrawable(R.drawable.ic_splash_icon);
//        drawable.setColorFilter(getResources().getColor(R.color.colorBaseBlue), PorterDuff.Mode.MULTIPLY);
//        imageview.setImageDrawable(drawable);

        Shader shader = new LinearGradient(110, 0, 210, 100,
                getResources().getColor(R.color.colorBaseBlue), getResources().getColor(R.color.colorBasePurple), Shader.TileMode.CLAMP);
        textView.getPaint().setShader(shader);

        textView.setTypeface(fonts.tfRegular);


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        count++;
                        if (count>=20)
                        if (isUp) {
                            if (textView.getAlpha() - (float) 0.1 <= 0) {
                                isUp = false;
                            }
                            imageview.setAlpha(imageview.getAlpha() - (float) 0.1);
                            textView.setAlpha(textView.getAlpha() - (float) 0.1);
                        } else {
                            if (textView.getAlpha() + (float) 0.1 >= 1) {
                                isUp = true;
                            }
                            imageview.setAlpha(imageview.getAlpha() + (float) 0.1);
                            textView.setAlpha(textView.getAlpha() + (float) 0.1);

                        }
                    }
                });
            }
        }, 100, Term);

    }
}
