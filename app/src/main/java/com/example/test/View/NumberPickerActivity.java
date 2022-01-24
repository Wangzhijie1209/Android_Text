package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.test.R;

/**
 * NumberPicker 数值选择器   用户既可以通过键盘输入数值,也可以通过拖动来选择数值
 * 常用的三个方法:
 *  setMinValue(int minVal):设置该组件支持的最小值。
 *  setMaxValue(int maxVal):设置该组件支持的最大值。
 *  setValue(int value):设置该组件的当前值
 */
public class NumberPickerActivity extends AppCompatActivity {

    //定义最低价、最高价的初始值
    private int minPrice = 25;
    private int maxPrice = 75;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_picker);
        NumberPicker np1 = findViewById(R.id.np1);
        //设置np1的最小值和最大值
        np1.setMinValue(10);
        np1.setMaxValue(50);
        //设置np1的当前值
        np1.setValue(minPrice);
        np1.setOnValueChangedListener((picker,oldVal,newVal)->{
            //当NumberPicker的值发生改变时,将会激发该方法
            minPrice=newVal;
            showSelectedPrice();
        });
       NumberPicker np2 =  findViewById(R.id.np2);
       //设置np2的最小值和最大值
        np2.setMinValue(60);
        np2.setMaxValue(100);
        np2.setValue(maxPrice);
        np2.setOnValueChangedListener((picker,oldVal,newVal)->{
            //当NumberPicker的值发生改变时,将会激发该方法
            maxPrice = newVal;
            showSelectedPrice();
        });
    }

    private void showSelectedPrice() {
        Toast.makeText(this, "您的最低价格为"+minPrice+"最高价格为"+maxPrice, Toast.LENGTH_SHORT).show();
    }
}