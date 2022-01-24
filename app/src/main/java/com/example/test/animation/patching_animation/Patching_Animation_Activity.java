package com.example.test.animation.patching_animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

/**
 * 补间动画:
 * 什么是补间动画:补间动画主要是向View对象设置动画效果,包括:
 * AlphaAnimation(设置透明度的改变)
 * RotateAnimation(设置图片进行旋转)
 * ScaleAnimation(设置图片进行缩放)
 * TranslateAnimation(设置图片进行位移变换)
 * 这4种效果 对应的xml标签分别是:
 * alpha
 * rotate
 * scale
 * translate
 * 通过为动画设置初始值和终止对应的值,根据插值器和duration计算动画过程中间相应的
 * 值实现平滑运动,就是设置起始状态和终止状态,插值器来计算填补初始状态到终止状态间的动画
 * <p>
 * 使用:1.设置相应动画效果的起点值、终点值、duration(时长)、interpolator(加速度)。
 * 注意(RotateAnimation还需要设置旋转中心坐标值)
 * 2.Interpolator:插值器,随时间流逝动画路程走过的百分比。
 * 比如:若设置为LinearInterpolator(匀速),时间过一般则插值器的值是0.5
 * 若设置的是DecelerateInterpolator(加速插值器),时间过一般则插值器的值大于0.5
 * 如果想让sat元素下所有动画效果使用相同的动画速度 则可以指定:
 * android:shareInterpolator="true"
 */
public class Patching_Animation_Activity extends AppCompatActivity {

    private ImageView mPatchingImageview;
    private Button mPatchingButton;
    private ImageView mPatchingImageview2;
    private Button mPatchingButton2;
    private boolean isStart = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patching_animation);
        initView();
        startAnimation();
    }

    private void startAnimation() {
        mPatchingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //加载动画资源
                Animation patchingAnimation = AnimationUtils.loadAnimation(Patching_Animation_Activity.this, R.anim.patching_animation);
                patchingAnimation.setFillAfter(true);
                if (isStart) {
                    //加载动画
                    mPatchingImageview.startAnimation(patchingAnimation);
                    isStart=false;
                } else {
                    //关闭动画
                    mPatchingImageview.clearAnimation();
                    isStart=true;
                }
            }
        });

        mPatchingButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimationSet animationSet = new AnimationSet(true);
                //透明度动画
                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(2000);
                //旋转动画
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                //缩放动画
                ScaleAnimation scaleAnimation = new ScaleAnimation(1, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                //平移动画
                TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1, Animation.RELATIVE_TO_SELF, 0);

                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(translateAnimation);
                mPatchingImageview2.startAnimation(animationSet);
            }
        });
    }

    private void initView() {
        mPatchingImageview = (ImageView) findViewById(R.id.patching_imageview);
        mPatchingButton = (Button) findViewById(R.id.patching_button);
        mPatchingImageview2 = (ImageView) findViewById(R.id.patching_imageview2);
        mPatchingButton2 = (Button) findViewById(R.id.patching_button2);
    }
}