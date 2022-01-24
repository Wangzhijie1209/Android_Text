package com.example.test.event_handlling;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

public class MyButton extends Button {
    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        Log.w("wzj", "the onTouchEvent in MyButton" );
        //当用户触碰到按钮时
        //返回true 表明该事件不会向外传播
        //返回false 表示该事件会传播到Activity
        return true;
    }
}
