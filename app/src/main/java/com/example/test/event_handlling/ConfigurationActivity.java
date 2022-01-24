package com.example.test.event_handlling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.R;

/**
 * Configuration类专门用于描述手机设备上的配置信息,这些配置信息既包括用户特定的配置项，也包括系统的动态设置配置
 * 程序可调用Activity的如下方法来获取系统的Configuration对象
 * Configuration cfg = getResources().getConfiguration();
 * 获取之后就可以通过该对象提供的如下常用属性来获取系统的配置信息
 * float fontScale:获取当前用户设置的字体的缩放因子
 * int keyboard:获取当前设备所关联的键盘类型.该属性可能返回KEYBOARD_NOKEYS、KEYBOARD_QWERTY(普通电脑键盘)
 * KEYBOARD_12KEY(只有12个键的小键盘)
 * int keyboardHidden:该属性返回一个boolean值,用于标识当前键盘是否可用,该属性不仅会判断系统的硬件键盘,也会判断系统的软键盘（位于屏幕上）
 * 该属性也会返回KEYBOARDHIDDEN_NO:只有两个键盘都不可用时才返回KEYBOARDHIDDEN_YES
 * Locale locale:获取用户当前的Locale
 * int mcc:获取移动信号的国家码
 * int mnc:获取移动信号的网络码
 * int navigation:判断系统上方导航设备类型 可能返回:
 * NAVIGATION_NONAV(无导航)
 * NAVIGATION_DPAD(DPAD导航)
 * NAVIGATION_TRACKBALL(轨迹球导航)
 * NAVIGATION_WHEEL(滚轮导航)
 * int orientation:获取系统屏幕的方向,该属性可能返回:
 * ORIENTATION_LANDSCAPE(横向屏幕)
 * ORIENTATION_PORTRAIT(竖向屏幕)
 * ORIENTATION_SQUARE(方形屏幕)
 * int touchscreen:获取系统触摸屏的触摸方法,该属性可能返回:
 * TOUCHSCREEN_NOTOUCH(无触摸屏)
 * TOUCHSCREEN_STYLUS(触摸笔式的触摸屏)
 * TOUCHSCREEN_FINGER(接收手指的触摸屏的触摸屏)
 */
public class ConfigurationActivity extends AppCompatActivity {

    private TextView ori;
    private TextView mnc;
    private TextView touch;
    private TextView navigation;
    private Button bn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        ori = findViewById(R.id.ori);
        navigation = findViewById(R.id.navigation);
        touch = findViewById(R.id.touch);
        mnc = findViewById(R.id.mnc);
        bn = findViewById(R.id.configuration_button);
        bn.setOnClickListener(view -> {
            //获取系统的Configuration对象
            Configuration cfg = getResources().getConfiguration();
            String screen = cfg.orientation == Configuration.ORIENTATION_LANDSCAPE ? "横向屏幕" : "竖向屏幕";
            String mncCode = cfg.mnc + "";
            String naviName = cfg.orientation == Configuration.NAVIGATION_NONAV ? "没有控制方向" : (cfg.orientation == Configuration.NAVIGATION_WHEEL) ? "滚轮控制方向" :
                    (cfg.orientation == Configuration.NAVIGATION_DPAD) ? "方向键控制方向" : "轨迹球控制方向";
            navigation.setText(naviName);

            String touchName = cfg.touchscreen == Configuration.TOUCHSCREEN_NOTOUCH ? "无触摸屏" : "支持触摸屏";
            ori.setText(screen);
            mnc.setText(mncCode);
            touch.setText(touchName);
        });
    }
}