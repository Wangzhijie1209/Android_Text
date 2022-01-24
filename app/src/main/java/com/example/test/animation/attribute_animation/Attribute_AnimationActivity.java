package com.example.test.animation.attribute_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.test.R;

/**
 * 属性动画:
 *  属性动画可以对任何对象的属性做动画,而不仅仅是View,甚至可以没有对象。除了作用对象进行扩展外,属性动画的效果也加强了,
 *  不仅能实现View动画的4种效果,还能实现其他多种效果,这些效果都是通过ValueAnimation或ObjectAnimation、AnimationSet
 *  等来实现的
 *      如果需求中只要对View进行移动、缩放、旋转淡入淡出操作,那么补间动画确实已经足够健全了,但是很显然,
 *      这些功能不足以覆盖所有场景,一旦超出了这四种对View的操作,那么补间动画就不能帮我们忙了，所以他补间动画在可扩展
 *      方面有一定的局限性,
 *  ValueAnimator:属性动画的运行机制是通过不断地对值进行操作来实现的,而初始值和结束值之间的动画过度就是右ValueAnimation
 *  来负责计算的.他的内部使用了一种时间循环的机制来计算值与值之间的动画过度,我们只需要将初始值和结束值提供给ValueAnimator，
 *  并且告诉他动画所需运行的时长,那么ValueAnimator就会自动帮我们完成从初始值平滑地过度到结束值这样的效果.除此之外,ValueAnimator
 *  还负责管理动画的播放次数、播放模式、以及对动画设置监听器等,
 *                      表示将一个值从0平滑过度到1
 *  ValueAnimator anim = ValueAnimator.onFloat(0f,1f);
 *        设置时长300毫秒
 *  anim.setDuration(300);
 *
 *  anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
 *     @Override
 *     public void onAnimationUpdate(ValueAnimator animation){
 *     float currentValue =(float)animation.getAnimatedValue();
 *      这里可以监听动画是否执行    打印currentValue就可以
 *     }
 *  });
 *  开始动画
 *  anim.start();
 *
 *  如果将一个值在5秒内从0过度到5 再过度到3 再过度到10 可以这样写
 *  ValueAnimator anim = ValueAnimator.ofFloat(0f,5f,3f,10f);
 *  anim.setDuration(5000);
 *  anim.start();
 *
 *  如果并不需要小数位的动画过度 可以使用   这里是从0平滑的过度到100
 *  ValueAnimator anim = ValueAnimator.onInt(0,100);
 *
 *  还有一些常用属性 比如:
 *  setStartDelay()延时播放的时间
 *  setRepeatCount()设置动画循环播放次数
 *  setRepeatMode()循环播放模式  有RESTART 重新播放   REVERSE倒序播放
 *
 *  ObjectAnimation:继承自ValueAnimation,可以对任意对象的任意属性进行动画操作,比如说view的alpha属性
 *      如果我们想将一个TextView在5秒内从常规变换成全透明,再从全透明变成常规,可以这样写
 *      ObjectAnimation animation = new ObjectAnimation.ofFloat(textView,"alpha",1f,0f,1f);
 *      animation.setDuration(5000);
 *      animation.start();
 *      在举栗子:比如我们要将TextView进行一次360度的旋转,可以这样写
 *      ObjectAnimation animation = new ObjectAnimation.onFloat(textView,"rotation",0f,360f);
 *      animation.setDuration(5000);
 *      animation.start();
 *      如果想要将textView先向左移出屏幕,然后再移动回来,可以这样写
 *      float curTranslationX = textView.getTranslationX();
 *      ObjectAnimation animation = new ObjectAnimation.onFloat(textView,"translationX",curTranslationX,-500f,curTranslationX);
 *      animation.setDuration(5000);
 *      animation.start();
 *      缩放是这样的  这里将第二个参数改成了scaleY 表示在垂直方向上进行缩放
 *      ObjectAnimation animation = new ObjectAnimation.ofFloat(textView,"scaleY",1f,3f,1f);
 *      animation.setDuration(5000);
 *      animation.start();
 *  Animation监听器:anim.addListener(new AnimatorListener(){
 *      @Override
 *      public void onAnimationStart(Animator animator){
 *          在动画开始的时候调用
 *      }
 *      @Override
 *      public void onAnimationRepeat(Animator animator){
 *          在动画重复的时候调用
 *      }
 *      @Override
 *      public void onAnimationEnd(Animator animator){
 *          在动画结束的时候调用
 *      }
 *      @Override
 *      public void onAnimationCancel(Animator animator){
 *          在动画被取消的时候调用
 *      }
 *  })
 *
 *  如果只想要监听动画结束这一个事件，可以使用Android提供的适配器类,叫做AnimatorListenerAdapter
 *  anim.addListener(new AnimatorListenerAdapter(){
 *      重写
 *      @Override
 *      public void onAnimationEnd(Animator animator){
 *
 *      }
 *  })
 *
 *
 *
 */
public class Attribute_AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attribute_animation);
    }
}