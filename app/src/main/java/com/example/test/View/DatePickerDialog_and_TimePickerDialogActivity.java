package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.R;

import java.util.Calendar;

/**
 * 一个弹框选择时间的控件 日期选择对话框、时间选择对话框
 */

public class DatePickerDialog_and_TimePickerDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_dialog_and_time_picker_dialog);
        Button dateBn = findViewById(R.id.dateBn);
        Button timeBn = findViewById(R.id.timeBn);
        TextView show = findViewById(R.id.show);

        dateBn.setOnClickListener(view -> {
            Calendar c = Calendar.getInstance();
            //直接创建一个DatePickerDialog对话框实例,并将它显示出来
            new DatePickerDialog(DatePickerDialog_and_TimePickerDialogActivity.this,
                    //绑定监听器
                    (dp, year, month, dayOfMonth) -> {
                        show.setText("您选择了" + year + "年" + (month + 1) + "月" + dayOfMonth + "日");
                    }, c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)).show();
        });
        timeBn.setOnClickListener(view -> {
            Calendar c = Calendar.getInstance();
            //创建一个TimePickerDialog实例,并把它显示出来
            new TimePickerDialog(DatePickerDialog_and_TimePickerDialogActivity.this,
                    //绑定监听器
                    (tp, hourOfDay, minute) -> {
                        show.setText("您选择了" + hourOfDay + "时" + minute + "分");
                    }, c.get(Calendar.HOUR_OF_DAY),
                    c.get(Calendar.MINUTE),
                    true).show();
        });
    }
}