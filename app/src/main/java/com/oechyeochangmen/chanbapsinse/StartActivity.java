package com.oechyeochangmen.chanbapsinse;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.Space;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by eka on 2017. 7. 14..
 */

public class StartActivity extends AppCompatActivity {
    private int Term = 10;
    private int count = 0;
    Space topSpace;
    Space bottomSpace;
    Button start_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        topSpace = (Space) findViewById(R.id.activity_start_topSpace);
        bottomSpace = (Space) findViewById(R.id.activity_start_bottomSpace);
        start_btn = (Button) findViewById(R.id.activity_start_btn);
        final Handler handler = new Handler();
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (count>=50){
                    timer.cancel();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        LinearLayout.LayoutParams topParams = (LinearLayout.LayoutParams) topSpace.getLayoutParams();
                        LinearLayout.LayoutParams bottomParams = (LinearLayout.LayoutParams) bottomSpace.getLayoutParams();
                        topParams.weight -= 0.026f;
                        bottomParams.weight += 0.026f;
                        topSpace.setLayoutParams(topParams);
                        bottomSpace.setLayoutParams(bottomParams);
                        start_btn.setAlpha(start_btn.getAlpha()+0.02f);
                        count++;
                    }
                });
            }
        }, 500, Term);


    }

}
