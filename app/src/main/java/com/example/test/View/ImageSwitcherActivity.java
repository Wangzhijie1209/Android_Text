package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 图像切换器 ImageSwitcher继承自ViewSwitcher 因此他具有与ViewSwitcher相同的特征,可以在切换View组件时使用动画效果
 * 他重写了ViewSwitcher的showNext()、showPrevious()方法,因此ImageSwitcher使用起来更加简单。 使用ImageSwitcher
 * 1.为ImageSwitcher提供一个ViewFactory,该ViewFactory生成的View组件必须是ImageView
 * 2.需要切换图片时,只要调用ImageSwitcher的setImageDrawable(Drawable drawable)、setImageSwitcher 与 ImageView的功能有点相似
 * 他们都可用于显示图片，区别在于ImageSwitcher的效果更炫,它可以指定图片切换时的动画效果
 */
public class ImageSwitcherActivity extends AppCompatActivity {

    int[] imageIds = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,
            R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,
            R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,
            R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);
        //创建一个List对象,List对象的元素是Map
        List<Map<String,Object>> listItems = new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++) {
            Map<String,Object> listItem = new ArrayMap<>();
            listItem.put("image",imageIds[i]);
            listItems.add(listItem);
        }
        //获取显示图片的ImageSwitcher
        ImageSwitcher switcher = findViewById(R.id.switcher);
        //为ImageSwitcher设置图片切换的动画效果
        //使用Lambda表达式创建ViewFactory,表达式makeView()方法的方法体
        switcher.setFactory(() ->{
            //创建ImageView对象
            ImageView imageView = new ImageView(ImageSwitcherActivity.this);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT));
            return imageView;
        });
        //创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.cell,new String[]{"image"},new int[]{R.id.image1});
        GridView grid = findViewById(R.id.grid01);
        //为GridView设置Adapter
        grid.setAdapter(simpleAdapter);
        //添加列表项被选中的监听器
        grid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //显示当前被选中的图片
                switcher.setImageResource(imageIds[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //添加列表项被单击的监听器
        grid.setOnItemClickListener((parent,view,position,id) -> {
            switcher.setImageResource(imageIds[position]);
        });
    }
}