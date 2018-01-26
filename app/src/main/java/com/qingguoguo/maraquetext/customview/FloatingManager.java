package com.qingguoguo.maraquetext.customview;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * @author :qingguoguo
 * @datetime ：2018/1/2
 * @describe :
 */

public class FloatingManager {
    private WindowManager mWindowManager;
    private static FloatingManager mInstance;
    private Context mContext;

    public static FloatingManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (FloatingManager.class) {
                if (mInstance == null) {
                    mInstance = new FloatingManager(context);
                }
            }
        }
        return mInstance;
    }

    private FloatingManager(Context context) {
        mContext = context;
        mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
    }

    /**
     * 添加悬浮窗
     *
     * @param view
     * @param params
     * @return
     */
    public boolean addView(View view, WindowManager.LayoutParams params) {
        try {
            mWindowManager.addView(view, params);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 移除悬浮窗
     *
     * @param view
     * @return
     */
    public boolean removeView(View view) {
        try {
            mWindowManager.removeView(view);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 更新悬浮窗参数
     *
     * @param view
     * @param params
     * @return
     */
    public boolean updateView(View view, WindowManager.LayoutParams params) {
        try {
            mWindowManager.updateViewLayout(view, params);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取屏幕宽度
     *
     * @return int
     */
    public int getScreenWidth( ) {
        DisplayMetrics dm = new DisplayMetrics();
        mWindowManager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @return int
     */
    public  int getScreenHeight( ) {
        DisplayMetrics dm = new DisplayMetrics();
        mWindowManager.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }
}
