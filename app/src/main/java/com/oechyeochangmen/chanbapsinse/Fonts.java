package com.oechyeochangmen.chanbapsinse;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by eka on 2017. 7. 17..
 */

public class Fonts {
    Context context;

    public Fonts(Context context) {
        this.context = context;
    }

    public Typeface tfRegular = Typeface.createFromAsset(context.getAssets(), "fonts/NanumBarumGothic.ttf");
    public Typeface tfBold = Typeface.createFromAsset(context.getAssets(), "fonts/NanumBarumGothicBold.ttf");
    public Typeface tfLight = Typeface.createFromAsset(context.getAssets(), "fonts/NanumBarumGothic.Lightttf");
}
