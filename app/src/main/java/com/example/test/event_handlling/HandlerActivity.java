package com.example.test.event_handlling;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import com.example.test.R;

import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

/**
 * handleMessage(Message msg): 处理消息的方法。该方法通常用于被重写
 * hasMessages(int what) : 检查消息队列中是否包含what属性为指定值的消息
 * has Messages(int what,Object object) : 检查消息队列中是否包含what属性为指定值且object属性为指定对象的消息
 * 多个重载的Message obtainMessage():获取消息
 * sendEmptyMessage(int what):发送空消息
 * sendEmptyMessageDelayed(int what,long delayMillis) : 指定多少毫秒之后发送空消息
 * sendMessage(Message msg) : 立即发送消息
 * sendMessageDelayed(Message msg,long delayMillis) : 指定多少毫秒之后发送消息
 */
public class HandlerActivity extends AppCompatActivity {

    private ImageView show;
    static class MyHandler extends Handler{
        private WeakReference<HandlerActivity> activity;

        public MyHandler(WeakReference<HandlerActivity> activity) {
            this.activity = activity;
        }
        //定义周期性显示图片的id
        private int[] imageIds = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
        private int currentImageId = 0;

        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == 0x1233){
                //动态修改所显示的图片
                activity.get().show.setImageResource(imageIds[currentImageId++ % imageIds.length]);
            }
        }
    }

    MyHandler myHandler = new MyHandler(new WeakReference(this));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        show = findViewById(R.id.show);
        //定义一个计时器,让该计时器周期性执行指定任务   TimerTask 启动一个新线程
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //发送空消息
                myHandler.sendEmptyMessage(0x1233);
            }
        },0,1200);
    }
}