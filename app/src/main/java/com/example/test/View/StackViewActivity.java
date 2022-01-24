package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import com.example.test.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * StackView也是AdapterViewAnimator的子类,它也用于显示Adapter提供的一系列View
 * StackView将会以堆叠Stack的方式来显示多个列表项 为了控制StackView显示的View组件 StackView提供了如下两种控制方式
 * 拖走StackView中处于顶端的View,下一个View将会显示出来.将上一个View拖进StackView将使显示出来
 * 通过调用StackView的showNext()、showPrevious()控制显示下一个、上一个组件
 */
public class StackViewActivity extends AppCompatActivity {

    private int[] imageIds = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,
            R.drawable.a,R.drawable.b,R.drawable.c,
            R.drawable.a,R.drawable.b,R.drawable.c,
            R.drawable.a,R.drawable.b,R.drawable.c};
    private StackView stackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_view);
        stackView = findViewById(R.id.mStackView);
        //创建一个List对象,List对象的元素是Map
        List<Map<String,Object>> listItems = new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++) {
            Map<String,Object> listItem = new HashMap<>();
            listItem.put("image",imageIds[i]);
            listItems.add(listItem);
        }
        //创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.cell,new String[]{"image"},new int[]{R.id.image1});
        stackView.setAdapter(simpleAdapter);
    }

    public void prev(View view) {
        //显示上一个组件
        stackView.showPrevious();
    }

    public void next(View view) {
        //显示下一个组件
        stackView.showNext();
    }
}