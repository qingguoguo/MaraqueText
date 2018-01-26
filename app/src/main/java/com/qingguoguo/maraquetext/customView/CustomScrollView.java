package com.qingguoguo.maraquetext.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

/**
 * @author :qingguoguo
 * @datetime ：2018/1/19
 * @describe :
 */

public class CustomScrollView extends ScrollView {
    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            Log.i("CustomScrollView", "Mode:AT_MOST=" + MeasureSpec.AT_MOST + ",EXACTLY=" +
                    MeasureSpec.EXACTLY + ",UNSPECIFIED=" + MeasureSpec.UNSPECIFIED);

            Log.i("CustomScrollView", "view:" + childAt + ",Mode:" + MeasureSpec.getMode(childAt.getMeasuredHeight()));
        }
    }
}
