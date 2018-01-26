package com.qingguoguo.maraquetext.CustomView;

import android.app.DialogFragment;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qingguoguo.maraquetext.R;

/**
 * @author :qingguoguo
 * @datetime ：2018/1/2
 * @describe :
 */

public class FloatingCustomView  implements View.OnClickListener {

    private static FloatingCustomView mInstance;
    private Context mContext;
    private View mView;
    private Button mPositiveButton;
    private Button mNegativeButton;
    private ImageView mDismiss;
    private TextView message;
    private WindowManager.LayoutParams mParams;
    private FloatingManager mWindowManager;
    private boolean isShowing;
    private String mData;
    private DialogFragment mDialogFragment;

    public static FloatingCustomView getInstance(Context context, String mData) {
        if (mInstance == null) {
            synchronized (FloatingCustomView.class) {
                if (mInstance == null) {
                    mInstance = new FloatingCustomView(context);
                }
            }
        }
        mInstance.mData = mData;
        return mInstance;
    }

    private FloatingCustomView(Context context) {
        mContext = context.getApplicationContext();
        mWindowManager = FloatingManager.getInstance(mContext);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater mLayoutInflater = LayoutInflater.from(context);
        mView = mLayoutInflater.inflate(R.layout.new_meal_view_alter_dialog, null);
        mPositiveButton = (Button) mView.findViewById(R.id.positiveButton);
        mNegativeButton = (Button) mView.findViewById(R.id.negativeButton);
        mDismiss = (ImageView) mView.findViewById(R.id.dialog_dismiss);
        message = (TextView) mView.findViewById(R.id.message);
        mNegativeButton.setVisibility(View.GONE);
        mPositiveButton.setVisibility(View.VISIBLE);
        mDismiss.setVisibility(View.VISIBLE);
        message.setText("哈哈，请点击我");
        mPositiveButton.setText("确定");

        mDismiss.setOnClickListener(this);
        mPositiveButton.setOnClickListener(this);
    }

    public void showFloatingView() {
        mParams = new WindowManager.LayoutParams();
        mParams.gravity = Gravity.CENTER;
        mParams.x = 0;
        mParams.y = 0;
        mParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        mParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR |
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
        mParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        mParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        isShowing = mWindowManager.addView(mView, mParams);
    }

    public void dimissFloatingView() {
        mWindowManager.removeView(mView);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.positiveButton) {
            Toast.makeText(mContext, "点击了进入诊室" + mData, Toast.LENGTH_LONG).show();
        }
        isShowing = mWindowManager.removeView(mView);
    }

    public boolean isShowing() {
        return isShowing;
    }
}
