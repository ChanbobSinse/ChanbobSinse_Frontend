package com.oechyeochangmen.chanbapsinse;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by eka on 2017. 7. 18..
 */

public class Fonts {
    Context context;
    public Typeface tfRegular;
    public Typeface tfBold;
    public Typeface tfLight;

    public Fonts(Context context) {
        this.context = context;
        tfRegular = Typeface.createFromAsset(context.getAssets(), "fonts/NanumBarunGothic.ttf");
        tfBold = Typeface.createFromAsset(context.getAssets(), "fonts/NanumBarunGothicBold.ttf");
        tfLight = Typeface.createFromAsset(context.getAssets(), "fonts/NanumBarunGothicLight.ttf");

    }

}
