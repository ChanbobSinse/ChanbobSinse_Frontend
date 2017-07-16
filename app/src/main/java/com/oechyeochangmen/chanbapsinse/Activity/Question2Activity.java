package com.oechyeochangmen.chanbapsinse.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.oechyeochangmen.chanbapsinse.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Question2Activity extends AppCompatActivity {
    EditText minMoney;
    EditText maxMoney;
    EditText errorMoney;
    TextView rangeMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        minMoney = (EditText) findViewById(R.id.question2_minmoney);
        maxMoney = (EditText) findViewById(R.id.question2_maxmoney);
        errorMoney = (EditText) findViewById(R.id.question2_errormoney);
        rangeMoney = (TextView) findViewById(R.id.question2_rangemoney);
//        String money = minMoney.getText().toString();
//        Log.e("asdf", money);
//        DecimalFormat format = (DecimalFormat) NumberFormat.getInstance(Locale.US);
//        DecimalFormatSymbols symbols = format.getDecimalFormatSymbols();
//        symbols.setDecimalSeparator(',');
//        format.setDecimalFormatSymbols(symbols);
//        money = format.format(Integer.parseInt(money));
//        Log.e("asdf", money);
//        NumberFormat format1 = NumberFormat.getInstance(Locale.US);
//        money = money.replaceAll(",", "");
//        Log.e("asdf", money);
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
    }


    private String numberToMoney(String money) {
        Log.e("Asdf", money.toString());
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
}
