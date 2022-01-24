package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.PopupWindow;

import com.example.test.R;

/**
 * PopupWindow可以创建类似对话窗风格的窗口,
 * 使用PopupWindow只需要两步
 * 1.调用PopupWindow的构造器创建PopupWindow对象
 * 2.调用PopupWindow的showAsDropDown(View v)将PopupWindow 的 showAtLocation()方法将PopupWindow在指定位置显示出来
 */
public class PopupWindowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        //加载PopupWindow对应的界面布局文件
        View root = this.getLayoutInflater().inflate(R.layout.popup, null);
        //创建PopupWindow对象
        PopupWindow popup = new PopupWindow(root, 560, 720);
        Button button = findViewById(R.id.bn);
        button.setOnClickListener(view ->
                //以下拉方式显示
//            popup.showAsDropDown(view);
                //将popupWindow显示在指定位置
                popup.showAtLocation(findViewById(R.id.bn), Gravity.CENTER, 20, 20));

        root.findViewById(R.id.close).setOnClickListener(view -> popup.dismiss());
    }
}