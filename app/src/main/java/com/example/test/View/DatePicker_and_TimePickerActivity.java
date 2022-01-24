package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.test.R;

import java.util.Calendar;

/**
 * 日期、时间选择器(DatePicker 和 TimePicker) 的功能与用法
 * DatePicker 和 TimePicker 是两个比较易用的组件,他们都从FrameLayout派生而来,其中DatePicker
 * 供用户选择日期,而TimePicker则供用户选择时间.
 * DatePicker 和 TimePicker 的基础上提供了一些方法来获取当前用户所选择的日期
 * 时间:如果程序需要获取用户选择的日期、时间、则可通过为DataPicker添加OnDateChangedListener进行监听、
 * 为TimePicker添加OnTimerChangedListener进行监听来实现.
 * 常用属性和方法:
 * XML属性
 * android:calendarTextColor   设置日历列表的文本颜色
 * android:calendarViewShown   设置该日期选择器是否显示CalendarView组件
 * android:datePickerMode      设置日期选择的模式,该属性支持calendar(日历)和spinner(旋转两种模式)
 * android:dayOfWeekBackground 设置日历中每周上方的页眉颜色
 * android:dayOfWeekTextAppearance 设置日历中每周上方的页眉的文本外观
 * android:endYear             设置日期选择器允许选择的最后一年
 * android:headerBackground    设置选中日期的背景色
 * android:headerDayOfMonthTextAppearance  设置选中日期中代表日的文本外观
 * android:headerMonthTextAppearance       设置选中日期中代表月的文本外观
 * android:headerYearTextAppearance        设置选中日期中代表年的文本外观
 * android:maxDate              设置该日期选择器支持的最大日期。以mm/dd/yyyy格式指定最大日期
 * android:minDate              设置该日期选择器支持的最小日期。以mm/dd/yyyy格式指定最小日期
 * android:spinnersShown        设置该日期选择器是否显示Spinner日期选择组件
 * android:startYear            设置日期选择器允许选择的第一年
 */
public class DatePicker_and_TimePickerActivity extends AppCompatActivity {
    //定义5个记录当前时间的变量
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_and_time_picker);
        DatePicker datePicker = findViewById(R.id.datePicker);
        TimePicker timePicker = findViewById(R.id.timePicker);
        //获取当前的年、月、日、小时、分钟
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        //初始化DatePicker组件,初始化时指定监听器
        datePicker.init(year, month, day, (view, year, month, day) -> {
            year = year;
            month = month;
            day = day;
            //显示当前日期、时间
            showDate(year,month,day,hour,minute);
        });
        timePicker.setOnTimeChangedListener((view,hourOfDay,minute)->{
            hour = hourOfDay;
            minute=minute;
            showDate(year,month,day,hour,minute);
        });
    }

    private void showDate(int year,int month,int day,int hour,int minute) {
        Toast.makeText(this, "您的购买日期为"+year+"年"+(month+1)+"月"+day+"日"+hour+"时"+minute+"分", Toast.LENGTH_SHORT).show();
    }
}