package com.example.test.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.test.R;

/**
 * 对话框组件分为:
 * AlertDialog:功能最丰富、实际应用最广泛的对话框.
 * ProgressDialog:进度对话框、这种对话框只是对进度条的包装
 * DatePickerDialog:日期选择对话框、这种对话框只是对DatePicker的包装
 * TimePickerDialog:时间选择对话框、这种对话框只是对TimePicker的包装
 * <p>
 * <p>
 * 1.创建AlertDialog.Builder对象
 * 2.调用AlertDialog.Builder的setTitle()或setCustomTitle()方法设置标题。
 * 3.调用AlertDialog.Builder的setIcon()方法设置图标。
 * 4.调用AlertDialog.Builder的相关设置方法设置对话框内容
 * 5.调用AlertDialog.Builder的setPositiveButton()、setNegativeButton() 或 setNeutralButton()方法添加多个按钮
 * 6.调用AlertDialog.Builder的create()方法创建AlertDialog对象,再调用AlertDialog对象的show()方法将该对话框显示出来；
 * 主要方法有:
 * setMessage():设置对话框内容为简单文本
 * setItems():设置对话框内容为简单文本
 * setSingleChoiceItems():设置对话框内容为单选列表项。
 * setMultiChoiceItems():设置对话框内容为多选列表项。
 * setAdapter():设置对话框内容为自定义列表项。
 * setView():设置对话框内容为自定义View
 */

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    public void simple(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                //设置标题
                .setTitle("这是一个简单对话框")
                //设置图标
                .setIcon(R.drawable.a)
                //设置内容
                .setMessage("这是内容");
        //为AlertDialog.Builder添加确定按钮
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this, "点击了确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this, "点击了取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }


    //调用AlertDialog.Builder的setItems()方法即可设置简单列表项对话框,调用该方法时需要传入一个数组或数组资源的id
    public void simpleList(View view) {
        String[] china = new String[]{"王志杰","凯文","乐福"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("这是一个简单列表项对话框")
                .setIcon(R.drawable.b)
                .setItems(china, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogActivity.this, "点击了第"+china[i]+"条目", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.show();
    }

    //调用setSingleChoiceItems()创建带单选列表项的对话框
    public void simpleChoice(View view) {

        String[] fruits = new String[]{"香蕉","菠萝","苹果","大西瓜","小樱桃"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("请选择你想吃的水果")
                .setIcon(R.drawable.c)
                //第一个参数为要选择的数组,第二是为默认选中哪个
                .setSingleChoiceItems(fruits, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogActivity.this, "我吃"+fruits[i], Toast.LENGTH_SHORT).show();
                    }
                });
        builder.show();
    }

    //多选列表项对话框 只要调用AlertDialog.Builder 的 setMultiChoiceItems()方法 可以传入数组作为参数,或者数据库查询结果集为参数
    public void multiChoice(View view) {
        String[] cat = new String[]{"布加迪威龙","GTR","法拉利","本田","巧克力"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择你的车")
                .setIcon(R.drawable.d)
                .setMultiChoiceItems(cat, new boolean[]{false,true,false,false,true}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        Toast.makeText(AlertDialogActivity.this, "您选择了"+cat[i], Toast.LENGTH_SHORT).show();
                    }
                });
        builder.show();
    }

    //自定义View对话框 使用AlertDialog.Builder 的 setView()方法可以接收一个View组件
    public void customView(View view) {
        LinearLayout loginForm = (LinearLayout)getLayoutInflater().inflate(R.layout.login,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("自定义View对话框")
                .setIcon(R.drawable.e)
                .setView(loginForm)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogActivity.this, "点击了确定", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogActivity.this, "点击了取消", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.show();
    }
}