package com.qingguoguo.maraquetext;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * @author :qingguoguo
 * @datetime ：2018/1/23
 * @describe :
 */

public class ExampleApplication extends Application {
    @Override public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
    }
}
