package com.example.test.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;

public class XML_menuActivity extends AppCompatActivity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_menu);
        txt = findViewById(R.id.xml_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //装填XML中的Menu
        getMenuInflater().inflate(R.menu.menu_one, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //创建上下文菜单时触发该方法
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context, menu);
        menu.setHeaderIcon(R.drawable.b);
        menu.setHeaderTitle("请选择背景色");
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    //上下文菜单中国菜单项被单击时触发该方法

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //勾选该选项
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.red:
                txt.setBackgroundColor(Color.RED);
                break;
            case R.id.green:
                txt.setBackgroundColor(Color.GREEN);
                break;
            case R.id.blue:
                txt.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
    }

    //菜单被单击后的回调方法
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //勾选该菜单项
        if (item.isCheckable()) {
            item.setChecked(true);
        }
        //判断单击的是哪个菜单项,并针对想的作出响应
        switch (item.getItemId()) {
            case R.id.font_10:
                txt.setTextColor(10 * 2);
                break;
            case R.id.font_12:
                txt.setTextColor(12 * 2);
                break;
            case R.id.font_14:
                txt.setTextColor(14 * 2);
                break;
            case R.id.font_16:
                txt.setTextColor(16 * 2);
                break;
            case R.id.font_18:
                txt.setTextColor(18 * 2);
                break;
            case R.id.red_font:
                txt.setTextColor(Color.RED);
                break;
            case R.id.green_font:
                txt.setTextColor(Color.GREEN);
                break;
            case R.id.blue_font:
                txt.setTextColor(Color.BLUE);
                break;
            case R.id.plain_item:
                Toast.makeText(this, "您单击了普通菜单项", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}