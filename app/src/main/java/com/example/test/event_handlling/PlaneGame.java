package com.example.test.event_handlling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.test.R;

public class PlaneGame extends AppCompatActivity {

    //定义飞机的移动速度
    private int speed = 10;
    private PlaneView planeView;
    DisplayMetrics metrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉窗口标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams
                .FLAG_FULLSCREEN);
        //创建PlaneView组件
        planeView = new PlaneView(this);
        setContentView(R.layout.activity_plane_game);
        planeView.setBackgroundResource(R.drawable.g);
        //获取窗口管理器
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        metrics = new DisplayMetrics();
        //获得屏幕宽和高
        display.getRealMetrics(metrics);
        //设置飞机的初始位置
        planeView.currentX = (metrics.widthPixels / 2);
        planeView.currentY = (metrics.heightPixels - 200);
        planeView.setOnTouchListener(new MyTouchListener());

    }

    private class MyTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getX() < metrics.widthPixels / 8) {
                planeView.currentX -= speed;
            }
            if (event.getX() < metrics.widthPixels * 7 / 8) {
                planeView.currentX += speed;
            }
            if (event.getX() < metrics.widthPixels / 8) {
                planeView.currentY -= speed;
            }
            if (event.getX() < metrics.widthPixels * 7 / 8) {
                planeView.currentY += speed;
            }
            return true;
        }
    }
}