package com.qingguoguo.maraquetext.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * @author :qingguoguo
 * @datetime ：2018/1/26
 * @describe :
 */

public class CustomLinearLayout extends LinearLayout {
    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            Log.i("CustomLinearLayout", "Mode:AT_MOST=" + MeasureSpec.AT_MOST + ",EXACTLY=" +
                    MeasureSpec.EXACTLY + ",UNSPECIFIED=" + MeasureSpec.UNSPECIFIED);

            Log.i("CustomLinearLayout", "view:" + childAt + ",Mode:" + MeasureSpec.getMode(childAt.getMeasuredHeight()));
        }
    }
}
