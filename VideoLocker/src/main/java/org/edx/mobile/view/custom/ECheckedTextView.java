package org.edx.mobile.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

import org.edx.mobile.R;

public class ECheckedTextView extends AppCompatCheckedTextView {
    public ECheckedTextView(Context context) {
        super(context);
    }

    public ECheckedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ECheckedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
