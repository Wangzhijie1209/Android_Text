package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.test.R;

/**
 * SeekBar 拖动条
 * 拖动条和进度条非常相似,只是进度条采用颜色来填充 而拖动条则是通过滑块的位置来标识数值,而且拖动条允许
 * 用户拖动滑块来改变值,因此拖动条通常用于对系统某种数值进行调节 比如调节音量等
 * SeekBar允许用户改变拖动条的滑块外观，改变滑块外观通过如下属性来指定
 * android:thumb:指定一个Drawable对象,该对象将作为自定义滑块.
 * android:tickMark:指定一个Drawable对象,该对象将作为自定义刻度图标。
 * 为了让程序能够相应拖动条滑块位置的改变,程序可以考虑为他绑定OnSeekBarChangeListener监听器
 */
public class SeekBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);
        ImageView image = findViewById(R.id.image);
        SeekBar seekBar = findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //当拖动条的滑块位置发生改变时触发该方法
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //动态改变图片的透明度
                image.setImageAlpha(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}