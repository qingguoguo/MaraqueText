package com.qingguoguo.maraquetext.Utils;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * @author :qingguoguo
 * @datetime ：2018/1/2
 * @describe :
 */

public class ScreenUtils {

    /**
     * 获取屏幕宽度
     *
     * @return int
     */
    public static int getScreenWidth(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @return int
     */
    public static int getScreenHeight(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }
}
