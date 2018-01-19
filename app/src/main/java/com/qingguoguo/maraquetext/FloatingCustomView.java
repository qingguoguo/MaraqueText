package com.qingguoguo.maraquetext;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author :qingguoguo
 * @datetime ：2018/1/2
 * @describe :
 */

public class FloatingCustomView extends View implements View.OnClickListener {

    private Context mContext;
    private View mView;
    private Button mPositiveButton;
    private Button mNegativeButton;
    private ImageView mDismiss;
    private TextView message;
    private WindowManager.LayoutParams mParams;
    private FloatingManager mWindowManager;

    public FloatingCustomView(Context context) {
        super(context);
        mContext = context.getApplicationContext();
        mWindowManager = FloatingManager.getInstance(mContext);

        LayoutInflater mLayoutInflater = LayoutInflater.from(context);
        mView = mLayoutInflater.inflate(R.layout.new_meal_view_alter_dialog, null);
        mPositiveButton = (Button) mView.findViewById(R.id.positiveButton);
        mNegativeButton = (Button) mView.findViewById(R.id.negativeButton);
        mDismiss = (ImageView) mView.findViewById(R.id.dialog_dismiss);
        message = (TextView) mView.findViewById(R.id.message);
        mNegativeButton.setVisibility(GONE);
        mPositiveButton.setVisibility(VISIBLE);
        mDismiss.setVisibility(VISIBLE);
        message.setText("已到预约看诊时间段，是否快速进入诊室？");
        mPositiveButton.setText("快速进入");

        mDismiss.setOnClickListener(this);
        mPositiveButton.setOnClickListener(this);
    }


    public void show() {
        mParams = new WindowManager.LayoutParams();
        mParams.gravity = Gravity.TOP | Gravity.LEFT;
        mParams.x = 0;
        mParams.y = 100;
        //总是出现在应用程序窗口之上
        mParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        mParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR |
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
        mParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        mParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mWindowManager.addView(mView, mParams);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.positiveButton:
                Toast.makeText(mContext, "点击了进入诊室", Toast.LENGTH_LONG).show();
                break;
            case R.id.dialog_dismiss:
                mWindowManager.removeView(mView);
                break;
            default:
                break;
        }
    }
}
