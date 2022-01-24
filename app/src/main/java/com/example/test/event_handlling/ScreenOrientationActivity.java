package com.example.test.event_handlling;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.test.R;

public class ScreenOrientationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_orientation);
        Button bn = findViewById(R.id.orientation_button);
        bn.setOnClickListener( view ->{
            Configuration config = getResources().getConfiguration();
            //如果当前是横屏
            if(config.orientation == Configuration.ORIENTATION_LANDSCAPE){
                ScreenOrientationActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
            //如果当前是竖屏
            if(config.orientation == Configuration.ORIENTATION_PORTRAIT){
                ScreenOrientationActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        });
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        String screen = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE?"横向屏幕":"竖向屏幕";
        Toast.makeText(this,"修改后的屏幕方向为"+ screen, Toast.LENGTH_SHORT).show();
    }
}