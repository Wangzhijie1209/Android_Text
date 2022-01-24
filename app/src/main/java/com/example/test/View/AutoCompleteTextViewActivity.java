package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.example.test.R;

/**
 * AutoCompleteTextView是EditText派生出来的，实际上呀他也是一个文本编辑框
 * 但他比普通编辑框多了一个功能,当用户输入一定字符之后,自动完成文本框会显示一个菜单,供用户从中选择,当用户
 * 选择某个菜单项之后,AutoCompletTextView按用户选择自动填写该文本框
 * 它除了可以使用EditText提供的方法之外，还支持:
 * XML属性                     相关方法               说明
 * android:completionHint     setCompletionHint     设置下拉菜单中的提示标语
 * android:completionHintView                       设置下拉菜单中提示标题的视图
 * android:completionThreshold  setThreshold        设置用户至少输入几个字符才会显示提示
 * android:dropDownAnchor      setDropAnchor        设置下拉菜单的定位描点组件,如果没有指定该属性 将使用TextView本身作为定位锚点组件
 * android:dropDownHeight      setDropDownHeight    设置下拉菜单的高度
 * android:dropDownHorizontalOffset                 设置下拉菜单与文本框之间的水平偏移,下拉菜单默认与文本框左对齐
 * android:dropDownVerticalOffset                   设置下拉菜单与文本框之间的垂直偏移.下拉菜单默认紧跟文本框
 * android:dropDownWidth       setDropDownWidth     设置下拉菜单的宽度
 * android:popupBackground     setDropDownBackgroundResource   设置下拉菜单的背景
 *
 * 使用AutoCompleteTextView很简单,只要为他设置一个Adapter即可,该Adapter封装了AutoCompleteTextView预设的提示文本
 * AutoCompleteTextView还派生了一个子类,MultiAutoCompleteTextView,该子类的功能与AutoCompleteTextView基本类似
 * 只是MultiAutoCompleteTextView允许输入多个提示项,多个提示项以分隔符分隔,MultiAutoCompleteTextView提供了setTokenizer()方法来设置分隔符
 */
public class AutoCompleteTextViewActivity extends AppCompatActivity {

    //定义字符串数组,作为提示文本
    private String[] books = new String[]{"疯狂java讲义","1111","2222","疯狂前端讲义"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);
        //创建一个ArrayAdapter,封装数组
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,books);
        AutoCompleteTextView actv = findViewById(R.id.auto);
        //设置Adapter
        actv.setAdapter(aa);
        MultiAutoCompleteTextView mauto = findViewById(R.id.mauto);
        mauto.setAdapter(aa);
        //为MultiAutoCompleteTextView设置分隔符
        mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}