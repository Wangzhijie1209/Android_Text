package com.example.test.event_handlling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.R;

/**
 * 事件监听主要涉及三类对象
 * Event Source(事件源):事件发生的场所,通常就是各个组件,例如按钮、窗口、菜单等.
 * Event(事件):事件封装了界面组件上发生的特定事情(通常就是一次用户操作).如果程序需要获得
 * 事件界面组件上锁发生事件的相关信息,一般通过Event对象来取得.
 * Event Listener(事件监听器):负责监听事件源所发生的事件,并对各种事件作出相应的相应.
 * <p>
 * 事件处理流程:
 * 1.将事件监听器注册到事件源
 * 2.触发事件源上的事件(这是一个外部动作)
 * 3.生成事件对象
 * 4.触发事件监听器事件作为参数传入事件处理器
 * 5.调用事件处理器作出响应
 */
public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        //获取应用程序中的Button
        Button bn = findViewById(R.id.bn);
        //为事件绑定注册事件监听器
        bn.setOnClickListener(new MyClickListener());
    }

    //定义了一个View.OnclickListener的实现类，用作事件监听器使用。
    class MyClickListener implements View.OnClickListener{
        //实现监听器类必须实现的方法,该方法将会作为事件处理器
        @Override
        public void onClick(View view) {
            TextView txt = findViewById(R.id.txt);
            txt.setText("bn按钮被单击了！");

        }
    }
    /**
     * 上面主要有以下步骤:
     * 1.获取普通界面组件(事件源),也就是被监听的对象
     * 2.实现事件监听器类,该监听器类是一个特殊的类,必须实现一个XxxListener接口.
     * 3.调用事件源setXxxListener方法会触发事件监听器,由事件监听器调用相应的方法(事件处理器)来处理事件
     *
     * 事件源:就是程序中的Button按钮,
     * 事件监听器:是程序中的MyClickListener类,监听器类必须由程序员负责实现,实现监听器类的关键就是要实现处理器的方法。
     * 注册监听器: 只要调用事件源的setXxxListener(XxxListener)方法即可.
     *
     */
}