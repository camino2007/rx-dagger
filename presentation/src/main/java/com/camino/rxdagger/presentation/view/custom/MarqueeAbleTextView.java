package com.camino.rxdagger.presentation.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by rxdroid on 2/28/16.
 */
public class MarqueeAbleTextView extends TextView {

    public MarqueeAbleTextView(Context context) {
        super(context);
    }

    public MarqueeAbleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqueeAbleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
