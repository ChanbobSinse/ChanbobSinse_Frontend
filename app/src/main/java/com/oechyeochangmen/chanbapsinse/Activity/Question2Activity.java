package com.oechyeochangmen.chanbapsinse.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.oechyeochangmen.chanbapsinse.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import static android.content.Intent.FLAG_ACTIVITY_NO_HISTORY;
import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

public class Question2Activity extends AppCompatActivity {
    public static Question2Activity activity = null;

    EditText minMoney;
    EditText maxMoney;
    EditText errorMoney;
    TextView rangeMoney;
    TextView question;
    TextView won1, won2, won3, plusminus;
    TextView content;
    TextView minText, maxText;
    TextView errorText;
    Button prev_btn;
    Button next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        activity = this;

        minMoney = (EditText) findViewById(R.id.question2_minmoney);
        maxMoney = (EditText) findViewById(R.id.question2_maxmoney);
        errorMoney = (EditText) findViewById(R.id.question2_errormoney);
        rangeMoney = (TextView) findViewById(R.id.question2_rangemoney);
        prev_btn = (Button) findViewById(R.id.question2_btn_prev);
        next_btn = (Button) findViewById(R.id.question2_btn_next);
        question = (TextView) findViewById(R.id.question2_question);
        won1 = (TextView) findViewById(R.id.question2_won1);
        won2 = (TextView) findViewById(R.id.question2_won2);
        won3 = (TextView) findViewById(R.id.question2_won3);
        plusminus = (TextView) findViewById(R.id.question2_plusminus);
        content = (TextView) findViewById(R.id.question2_content);
        minText = (TextView) findViewById(R.id.question2_minText);
        maxText = (TextView) findViewById(R.id.question2_maxText);
        errorText = (TextView) findViewById(R.id.question2_errorText);

        prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String min, max;

                min = minMoney.getText().toString().replaceAll(",", "");
                max = maxMoney.getText().toString().replaceAll(",", "");
                if (Long.parseLong(min) > Long.parseLong(max)) {
                    Toast.makeText(Question2Activity.this, "최솟값이 최댓값보다 큽니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(Question2Activity.this, SearchingActivity.class);
                intent.addFlags(FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        minMoney.addTextChangedListener(new TextWatcher() {
            Boolean edited = false;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!edited) {
                    edited = true;
                    if (s.toString().equals("")) {
                        minMoney.setText("0");
                        changeRangeMoney();
                    } else {
                        String string = numberToMoney(s.toString());
                        minMoney.setText(string);
                        changeRangeMoney();
                        minMoney.setSelection(string.length());
                        edited = false;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        maxMoney.addTextChangedListener(new TextWatcher() {
            Boolean edited = false;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!edited) {
                    edited = true;
                    if (s.toString().equals("")) {
                        maxMoney.setText("0");
                        changeRangeMoney();
                    } else {
                        String string = numberToMoney(s.toString());
                        maxMoney.setText(string);
                        changeRangeMoney();
                        maxMoney.setSelection(string.length());
                    }
                    edited = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        errorMoney.addTextChangedListener(new TextWatcher() {
            Boolean edited = false;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!edited) {
                    edited = true;
                    if (s.toString().equals("")) {
                        errorMoney.setText("0");
                    } else {
                        String string = numberToMoney(s.toString());
                        errorMoney.setText(string);
                        errorMoney.setSelection(string.length());
                    }
                    edited = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Typeface tfRegular = Typeface.createFromAsset(getAssets(), "fonts/NanumBarunGothic.ttf");
        Typeface tfBold = Typeface.createFromAsset(getAssets(), "fonts/NanumBarunGothicBold.ttf");
        Typeface tfLight = Typeface.createFromAsset(getAssets(), "fonts/NanumBarunGothicLight.ttf");

        question.setTypeface(tfBold);
        content.setTypeface(tfRegular);
        won1.setTypeface(tfRegular);
        won2.setTypeface(tfRegular);
        won3.setTypeface(tfRegular);
        plusminus.setTypeface(tfRegular);
        prev_btn.setTypeface(tfRegular);
        next_btn.setTypeface(tfRegular);
        minText.setTypeface(tfRegular);
        maxText.setTypeface(tfRegular);
        minMoney.setTypeface(tfRegular);
        maxMoney.setTypeface(tfRegular);
        errorText.setTypeface(tfRegular);
        errorMoney.setTypeface(tfRegular);
    }


    private String numberToMoney(String money) {
        money = money.replaceAll(",", "");
        DecimalFormat format = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = format.getDecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        format.setDecimalFormatSymbols(symbols);
        money = format.format(Long.parseLong(money));
        return money;
    }

    private void changeRangeMoney() {
        rangeMoney.setText(minMoney.getText() + " ₩ ~ " + maxMoney.getText() + " ₩");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Question2Activity.this, Question1Activity.class);
        intent.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);

    }
}
