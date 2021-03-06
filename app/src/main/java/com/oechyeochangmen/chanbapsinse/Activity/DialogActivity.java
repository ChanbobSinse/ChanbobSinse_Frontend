package com.oechyeochangmen.chanbapsinse.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.oechyeochangmen.chanbapsinse.Fonts;
import com.oechyeochangmen.chanbapsinse.R;

public class DialogActivity extends AppCompatActivity {
    Fonts fonts;
    TextView title;
    TextView content;
    Button ok, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        fonts = new Fonts(this);

        title = (TextView) findViewById(R.id.dialog_title);
        content = (TextView) findViewById(R.id.dialog_content);
        ok = (Button) findViewById(R.id.dialog_ok);
        no = (Button) findViewById(R.id.dialog_no);
        title.setTypeface(fonts.tfRegular);
        content.setTypeface(fonts.tfRegular);
        ok.setTypeface(fonts.tfRegular);
        no.setTypeface(fonts.tfRegular);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
