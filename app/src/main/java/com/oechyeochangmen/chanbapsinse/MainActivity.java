package com.oechyeochangmen.chanbapsinse;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView;
        textView = (TextView) findViewById(R.id.textView);
        Intent intent = new Intent(this,StartActivity.class);
        startActivity(intent);
        Shader textShader = new LinearGradient(110,0,210,100, Color.rgb(0xaa,0xbb,0x66),Color.rgb(0x00,0x00,0x00), Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);
    }
}
