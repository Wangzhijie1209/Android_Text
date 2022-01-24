package com.example.test.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.test.R;

/**
 * 上下文菜单 ContextMenu
 * 开发上下文菜单不是重写onCreateOptionsMenu 方法
 * 而是重写onCreateContextMenu(ContextMenu menu,View source,ContextMenuInfo menuInfo)方法
 * 开发上下文菜单的步骤为:
 * 1.重写Activity的onCreateContextMenu(ContextMenu menu,View source,ContextMenu Context MenuInfo menuInfo)方法
 * 2.调用Activity的registerForContextMenu(View view)方法为view组件注册上下文菜单
 * 3.如果希望应用程序能为菜单项提供响应,则可以重写onContextItemSelected(MenuItem mi)方法,或为指定菜单绑定事件监听器。
 * ContextMenu提供了如下方法,同样可以为上下文菜单设置图标、标题等
 * ContextMenu setHeaderIcon(Drawable icon):为上下文菜单设置图标
 * ContextMenu setHeaderIcon(int iconRes):为上下文菜单设置图标
 * ContextMenu setHeaderTitle(Drawable titleRes):为上下文菜单设置图标
 */
public class ContextMenuActivity extends AppCompatActivity {
    //为每个菜单定义一个标识
    private static final int MENU1 = 0x111;
    private static final int MENU2 = 0x112;
    private static final int MENU3 = 0x113;
    private TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        txt = findViewById(R.id.contextmenu_text);
        //为文本框注册上下文菜单
        registerForContextMenu(txt);
    }
    //创建上下文菜单时触发该方法

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,MENU1,0,"红色");
        menu.add(0,MENU2,0,"绿色");
        menu.add(0,MENU3,0,"蓝色");
        //将三个菜单项设置单选菜单项
        menu.setGroupCheckable(0,true,true);
        //设置上下文菜单的标题、图标
        menu.setHeaderIcon(R.drawable.a);
        menu.setHeaderTitle("选择背景色");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case MENU1:txt.setBackgroundColor(Color.RED);break;
            case MENU2:txt.setBackgroundColor(Color.GREEN);break;
            case MENU3:txt.setBackgroundColor(Color.BLUE);break;
        }
        return true;
    }
}