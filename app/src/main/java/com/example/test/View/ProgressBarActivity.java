package com.example.test.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import com.example.test.R;

import java.lang.ref.WeakReference;

/**
 * ProgressBar 进度条
 * 他有两个派生子类 SeekBar 和 RatingBar 在用法上十分相似,只是显示界面有一定的区别
 * ProgressBar支持多种风格的进度条 可以通过属性style设置 有以下属性
 * @android:style/Widdget.ProgressBar.Hoorizontal : 水平进度条
 * @android:style/Widdget.ProgressBar.Inverse : 普通大小的环形进度条
 * @android:style/Widdget.ProgressBar.Large : 大环形进度条
 * @android:style/Widdget.ProgressBar.Large.Inverse : 大环形进度条
 * @android:style/Widdget.ProgressBar.Small : 小环形进度条
 * @android:style/Widdget.ProgressBar.Small.Inverse : 小环形进度条
 *
 * 常用属性有:
 * XML属性                     说明
 * android:max                设置该进度条的最大值
 * android:progress           设置该进度条的已完成进度值
 * android:progressDrawable   设置该进度条的轨道对应的Drawable对象
 * android:indeterminate      改属性设置为true,设置进度条不精确显示进度
 * android:indeterminateDrawable 设置绘制不显示进度的进度条的Drawable对象
 * android:indeterminateDuration  设置不精确显示进度的持续时间
 *
 * android:progressDrawable用于指定进度条的轨道的绘制形式,该属性可指定为一个LayerDrawable对象
 * (该对象可通过在XML文件中用<layer-list>元素进行配置) 的引用
 * ProgressBar提供了如下方法来操作进度
 * setProgress(int) 设置进度的完成百分比
 * incrementProgressBy(int):设置进度条的进度增加或减少。当参数为正数时增加:当参数为负数时减少
 */
public class ProgressBarActivity extends AppCompatActivity {
    //该程序模拟填充长度为100的数组
    private int[] data = new int[100];
    private int hasData = 0;
    //记录ProgressBar的完成进度
    int status = 0;
    private ProgressBar bar;
    private ProgressBar bar2;

    static class MyHandler extends Handler{
        private WeakReference<ProgressBarActivity> activity;
        MyHandler(WeakReference<ProgressBarActivity> activity){
            this.activity= activity;
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            //标明消息是由该程序发送的
            if(msg.what == 0x111){
                activity.get().bar.setProgress(activity.get().status);
                activity.get().bar2.setProgress(activity.get().status);
            }
            super.handleMessage(msg);
        }
    }
    //创建一个负责更新的进度的Handler
    MyHandler mHandler = new MyHandler(new WeakReference<>(this));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        bar = findViewById(R.id.bar);
        bar2 = findViewById(R.id.bar2);
        //启动线程来执行任务
        new Thread(){
            @Override
            public void run() {
                while (status<100){
                    //获取耗时操作的完成百分比
                    status = doWork();
                    mHandler.sendEmptyMessage(0x111);
                }
            }
        }.start();
    }
    public int doWork(){
        //为数组元素赋值
        data[hasData++] = (int)(Math.random() * 100);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hasData;
    }
}