package com.qingguoguo.maraquetext.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author :qingguoguo
 * @datetime ：2018/1/19
 * @describe :
 */

public class CustomLayout extends ViewGroup {

    private int[] childLeft;
    private int[] childTop;
    private int[] childBottom;
    private int[] childRight;

    public CustomLayout(Context context) {
        super(context);
    }

    public CustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int selfWidthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int selfWidthSpecSize = MeasureSpec.getSize(widthMeasureSpec);

        int selfHeightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int selfHeightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int usedWidth = 0;
        int usedHeight = 0;

        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            LayoutParams lp = childAt.getLayoutParams();
            int childwithSpec = 0;
            int childHeightSpec = 0;

//            measureChildren();
//            measureChild();

            //int spec, int padding, int childDimension
            childAt.measure(getChildMeasureSpec(widthMeasureSpec,0,childAt.getLayoutParams().width),
                    getChildMeasureSpec(heightMeasureSpec,0,childAt.getLayoutParams().height));

            switch (lp.width) {
                case LayoutParams.MATCH_PARENT:
                    if (selfWidthSpecMode == MeasureSpec.EXACTLY || selfWidthSpecMode == MeasureSpec.AT_MOST) {
                        childwithSpec = MeasureSpec.makeMeasureSpec(selfWidthSpecSize - usedWidth, MeasureSpec.EXACTLY);
                    } else if (selfWidthSpecMode == MeasureSpec.UNSPECIFIED) {
                        childwithSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                    }
                    break;
                case LayoutParams.WRAP_CONTENT:
                    if (selfWidthSpecMode == MeasureSpec.EXACTLY || selfWidthSpecMode == MeasureSpec.AT_MOST) {
                        childwithSpec = MeasureSpec.makeMeasureSpec(selfWidthSpecSize - usedWidth, MeasureSpec.AT_MOST);
                    } else if (selfWidthSpecMode == MeasureSpec.UNSPECIFIED) {
                        childwithSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                    }
                    break;
                default:
                    childwithSpec = MeasureSpec.makeMeasureSpec(lp.width, MeasureSpec.EXACTLY);
                    break;
            }
        }
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            childAt.layout(childLeft[i], childTop[i], childRight[i], childBottom[i]);
        }
    }
}
