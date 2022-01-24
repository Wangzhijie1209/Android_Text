package com.example.test.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;

/**
 * Menu 选项菜单
 * 有两个子接口分别是 SubMenu 和ContextMenu
 * SubMenu代表一个子菜单,可以包含1~n个MenuItem(形成菜单项)
 * ContextMenu 代表一个上下文菜单,可以包含1~N个menuItem(形成菜单项)
 * 不同的菜单有不同的特征:
 *  选项菜单:选项菜单不支持勾选标记,并且只显示菜单的浓缩 标题
 *  子菜单SubMenu : 不支持菜单项图标,不支持嵌套子菜单。
 *  上下文菜单 ContextMenu : 不支持菜单快捷键和图标
 *
 *  常用方法:
 *  MenuItem add(int titleRes):添加一个新的菜单项
 *  MenuItem add(int groupId,int itemId,int order,CharSequence title):添加一个新的处于groupId组的菜单项。
 *  MenuItem add(int groupId,int itemId,int order,int titleRes):添加一个新的处于groupId组的菜单项。
 *  MenuItem add(CharSequence title):添加一个新的菜单项
 *  SubMenu addSubMenu(int titleRes):添加一个新的子菜单
 *  SubMenu addSubMenu(int groupId,int itemId,int order,int titleRes):添加一个新的处于groupId组的子菜单。
 *  SubMenu addSubMenu(CharSequence title):添加一个新的子菜单
 *  SubMenu addSubMenu(int groupId,int itemId,int order,CharSequence title):添加一个新的处于groupId组的子菜单。
 *   Menu接口定义了如下方法来添加子菜单或菜单项。 上面的方法归纳起来就是两个
 *   add()方法用于添加菜单项
 *   addSubMenu()用于添加子菜单 重载方法的区别在于 : 是否将子菜单、菜单项添加到指定菜单组中,是否使用资源文件的字符串资源来设置标题
 *
 *   SubMenu继承了Menu,它就代表一个子菜单,额外提供了如下常用方法。
 *   SubMenu setHeaderIcon(Drawable icon):设置菜单头的图标.
 *   SubMenu setHeaderIcon(int iconRes):设置菜单头的图标
 *   SubMenu setHeaderTitle(int titleRes):设置菜单头的标题。
 *   SubMenu setHeaderTitle(CharSequence title):设置菜单头的标题
 *   SubMenu setHeaderView(View view):使用View来设置菜单头
 *
 *
 *   可以变成单选菜单项或多选菜单项
 *
 */
public class MenuActivity extends AppCompatActivity {
    //定义字体大小菜单项和标识
    private static final int FONT_10 = 0x111;
    private static final int FONT_12 = 0x112;
    private static final int FONT_14 = 0x113;
    private static final int FONT_16 = 0x114;
    private static final int FONT_18 = 0x115;
    //定义普通菜单项的标识
    private static final int PLAIN_ITEM = 0x11b;
    //定义字体颜色菜单项的表示
    private static final int FONT_RED = 0x116;
    private static final int FONT_BLUE = 0x117;
    private static final int FONT_GREEN = 0x118;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        text = findViewById(R.id.tex);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu fontMenu = menu.addSubMenu("字体大小");
        //设置菜单的图标
        fontMenu.setIcon(R.drawable.a);
        //设置菜单头的图标
        fontMenu.setHeaderIcon(R.drawable.b);
        //设置菜单头的标题
        fontMenu.setHeaderTitle("选择字体大小");
        fontMenu.add(0,FONT_10,0,"10号字体");
        fontMenu.add(0,FONT_12,0,"12号字体");
        fontMenu.add(0,FONT_14,0,"14号字体");
        fontMenu.add(0,FONT_16,0,"16号字体");
        fontMenu.add(0,FONT_18,0,"18号字体");
        //向Menu中添加普通菜单项
        menu.add(0,PLAIN_ITEM,0,"普通菜单项");
        //向menu中添加字体颜色的子菜单

        SubMenu colorMenu = menu.addSubMenu("字体颜色");
        colorMenu.setIcon(R.drawable.c);
        //设置菜单头的图标
        colorMenu.setHeaderIcon(R.drawable.d);
        //设置菜单头的标题
        colorMenu.setHeaderTitle("选择文字颜色");
        colorMenu.add(0,FONT_RED,0,"红色");
        colorMenu.add(0,FONT_GREEN,0,"绿色");
        colorMenu.add(0,FONT_BLUE,0,"蓝色");
        return super.onCreateOptionsMenu(menu);
    }
    //选项菜单的菜单项呗单击后的回调方法

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //判断单击的是哪个菜单项,并针对性的作出相应
        switch (item.getItemId()){
            case FONT_10:text.setTextSize(10 * 2);break;
            case FONT_12:text.setTextSize(12 * 2);break;
            case FONT_14:text.setTextSize(14 * 2);break;
            case FONT_16:text.setTextSize(16 * 2);break;
            case FONT_18:text.setTextSize(18 * 2);break;
            case FONT_RED:text.setTextColor(Color.RED);break;
            case FONT_GREEN:text.setTextColor(Color.GREEN);break;
            case FONT_BLUE:text.setTextColor(Color.BLUE);break;
            case PLAIN_ITEM:
                Toast.makeText(this, "你点击的是普通菜单项", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}