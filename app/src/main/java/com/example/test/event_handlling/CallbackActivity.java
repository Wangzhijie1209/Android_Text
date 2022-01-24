package com.example.test.event_handlling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.LogWriter;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

import com.example.test.R;


/**
 * 基于回调的事件处理
 * 回调机制与监听机制
 * 为了实现回调机制的事件处理 有以下回调方法 以View为例
 * boolean onKeyDown(int keyCode,KeyEvent event) : 当用户在该组件上按下某个按键时触发该方法
 * boolean onKeyLongPress(int keyCode,KeyEvent event) : 当用户在该组件上长按摸个按键时触发该方法
 * boolean onKeyShortcut(int keyCode,KeyEvent event) : 当一个键盘快捷键事件发生时触发该方法
 * boolean onKeyUp(int keyCode,KeyEvent event) : 当用户在该组件上松开某个按键时触发该方法
 * boolean onTouchEvent(MotionEvent event) : 当用户在该组件上触发触摸屏事件时触发该方法
 * Boolean onTrackballEvent(MotionEvent event) : 当用户在该组件上触发轨迹球事件时触发该方法
 *  基于回调的事件处理机制可通过自定义View来实现,自定义View时重写该View的事件处理方法即可.  可以看MyButton
 *
 *  当组件发生触碰事件,系统最先触发的应该是该组件绑定的事件监听器 然后才触发该组件提供的事件回调方法,最后还会传播
 *  到该组件所在的Activity
 *  但如果让任何一个事件处理方法返回了true,那么该事件将不会继续向外传播.
 *
 */
public class CallbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callback);
        //在这个布局中使用了自定义View 但是不用用户点击他，因为在自定义View的类中 onTouchEvent会负责处理按钮上的用户触碰事件

        Button bn  = findViewById(R.id.bn);
        bn.setOnTouchListener((view,event) ->{
            //只处理按下键的事件
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                Log.w("wzj", "the TouchDown in Listener" );
            }
            //返回false 表示该事件会向外传播
            return false;
        });
    }
    //重写onTouchEvent方法,该方法可监听他所包含的所有组件上的触碰事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        Log.w("wzj", "the onTouchEvent in Activity" );
        //返回false 表明该事件会向外传播
        return false;
    }
}