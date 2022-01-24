package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

import com.example.test.R;

/**
 * 文本切换器 TextSwitcher 继承了ViewSwitcher 因此他具有与ViewSwitcher相同的特征,可以在切换View组件时使用动画效果
 * 与ImageSwitcher相似的是,使用TextSwitch也需要设置一个ViewFactory,与ImageSwitcher不同的是 TextSwitch所需要的
 * ViewFactory的makeView()方法必须返回一个TextView组件,TextSwitcher与TextView的功能有点相似，他们都可用于显示文本
 * 内容,区别在于TextSwitcher的效果更炫,它可以指定文本切换时的动画效果 TextSwitch 和 ImageSwitcher的功能与用法很接近,
 * 就不讲了
 *
 *
 * 这里写了ViewFlipper的功能和用法
 * ViewFlipper组件继承了ViewAnimator,他可调用addView(View v)添加多个组件,一旦向ViewFlipper中添加了多个组件之后,ViewFlipper就
 * 可使用动画控制多个组件之间的切换效果.
 * ViewFlipper可以看看估值组件切换的动画效果，
 */
public class ViewFlipperActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_switcher);
        viewFlipper = findViewById(R.id.details);
    }

    public void prev(View view) {
        viewFlipper.setInAnimation(this,R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this,R.anim.slide_out_left);
        //显示上一个组件
        viewFlipper.showPrevious();
        //停止播放
        viewFlipper.stopFlipping();
    }

    public void next(View view) {
        viewFlipper.setInAnimation(this,R.anim.slide_out_left);
        viewFlipper.setOutAnimation(this,R.anim.slide_in_right);
        //显示下一个组件
        viewFlipper.showNext();
        //停止自动播放
        viewFlipper.stopFlipping();
    }
    public void auto(View source){
        viewFlipper.setInAnimation(this,R.anim.slide_out_left);
        viewFlipper.setOutAnimation(this,R.anim.slide_in_right);
        //开始自动播放
        viewFlipper.startFlipping();
    }
}