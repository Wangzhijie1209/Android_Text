package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.test.R;

/**
 * ScrollView由FrameLayout派生而出,它就是一个用于为普通组件添加滚动条的组件.
 * 它最多只能包含一个组件,而它的作用就是为该组件添加垂直滚动条。
 */
public class ScrollViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
    }
}