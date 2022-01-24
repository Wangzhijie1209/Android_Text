package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.example.test.R;

/**
 * 星级评分条 RatingBar 与 拖动条有相同的父类: AbsSeekBar 因此他们十分相似.实际上星级评分条
 * 与拖动条的用法、功能都十分接近 他们都允许用户通过拖动来改变进度. RatingBar与SeekBar的最大区别
 * 在于 RatingBar通过星星拉表示进度  常用属性
 * XML属性                   说明
 * android:isIndicator      设置该星级评分条是否允许用户改变(true为不允许修改)
 * android:numStars         设置该星级评分条总共有多个个星级
 * android:rating           设置该星级评分条默认的星级
 * android:stepSize         设置每次最少需要改变多少个星级
 *
 * 为了让程序能够响应星级评分条评分的改变,可以考虑为它绑定一个OnRatingBarChangeListener监听器
 *
 */
public class RatingBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
        ImageView img = findViewById(R.id.image);
        RatingBar ratingBar = findViewById(R.id.rating);
        ratingBar.setOnRatingBarChangeListener((bar,rating,fromUser)->{
            //当星级评分条的评分发生改变时触发该方法
            //动态改变图片的透明度,其中255的星级评分条的最大值
            //5颗星星就代表最大值255
            img.setImageAlpha((int)(rating * 255 / 5));
        });
    }
}