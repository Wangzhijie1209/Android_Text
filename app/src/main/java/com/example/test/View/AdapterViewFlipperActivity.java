package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.test.R;

/**
 * AdapterViewFlipper可以在多个View切换过程中使用渐隐渐变的动画效果.除此之外,还可以调用该组件的startFlipping()
 * 控制他自动播放下一个View组件
 * XML属性                       说明
 * android:animateFirstView     设置显示该组件的第一个View时是否使用动画
 * android:inAnimation          设置组件显示时使用的动画
 * android:loopViews            设置玄幻到最后一个组件是否自动转头到第一个组件
 * android:outAnimation         设置组件隐藏时使用的动画
 * android:autoStart   startFlipping()   设置显示该组件是否自动播放
 * android:flipInterval    setFlipInterval(int)    设置自动播放的时间间隔
 */
public class AdapterViewFlipperActivity extends AppCompatActivity {

    private int[] imageIds = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,
            R.drawable.a,R.drawable.b,R.drawable.c,
            R.drawable.a,R.drawable.b,R.drawable.c,
            R.drawable.a,R.drawable.b,R.drawable.c};
    private AdapterViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        flipper = findViewById(R.id.flipper);
        //创建一个BaseAdapter对象,该对象负责提供AdapterViewFlipperText所显示的列表项
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
               return imageIds.length;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ImageView imageView;
                if(view==null){
                    //创建一个ImageView
                    imageView = new ImageView(AdapterViewFlipperActivity.this);
                }else {
                    imageView = (ImageView) view;
                }
                imageView.setImageResource(imageIds[i]);
                //设置ImageView的缩放类型
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                //为imageView设置布局参数
                imageView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };
        flipper.setAdapter(adapter);

    }

    //上一个
    public void prev(View view) {
        //显示上一个组件
        flipper.showPrevious();
        //停止播放
        flipper.stopFlipping();
    }

    //下一个
    public void next(View view) {
        //显示下一个组件
        flipper.showNext();
        //停止自动播放
        flipper.stopFlipping();
    }

    //自动播放
    public void auto(View view) {
        //开始自动播放
        flipper.startFlipping();
    }
}