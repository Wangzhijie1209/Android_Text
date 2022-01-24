package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.example.test.R;

/**
 * 这个Menu可以实现点击条目跳转功能
 */

public class Use_Menu_to_jumpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_menu_to_jump);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //向menu中添加子菜单
        SubMenu prog = menu.addSubMenu("启动程序");
        //设置菜单头的图标
        prog.setHeaderIcon(R.drawable.a);
        //设置菜单头的标题
        prog.setHeaderTitle("选择您要启动的程序");
        //添加菜单项
        MenuItem item = prog.add("查看Swift");
        //为菜单项设置关联的Activity
        item.setIntent(new Intent(this,Notification2Activity.class));
        return super.onCreateOptionsMenu(menu);
    }
}