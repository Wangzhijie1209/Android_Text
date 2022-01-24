package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;

import com.example.test.R;

/**
 * 活动条 ActionBar
 * 关闭: 在AndroidManifest.xml中的Application 增加这行代码
 * android:theme="@style/Theme.AppCompat.Light.NoActionBar"
 *
 * 或者用下面这种方式
 */
public class ActionBarActivity extends AppCompatActivity {

    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        //获取该Activity的ActionBar
        //只有当应用主题没有关闭ActionBar时,代码才能返回ActionBar
        actionBar = getActionBar();
    }

    public void showActionBar(View view) {
        //显示ActionBar
        if(getSupportActionBar()!=null){
            actionBar.show();
        }

    }

    public void hideActionBar(View view) {
        //隐藏ActionBar
        if(getSupportActionBar()!=null){
            actionBar.hide();
        }
    }
}