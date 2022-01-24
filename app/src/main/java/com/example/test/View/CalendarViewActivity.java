package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.test.R;

/**
 * CalendarView 日历组件,可用于显示和选择日期,用户既可选择一个日期,也可通过触摸来滚动日历.
 * 常用属性和方法:
 * XML属性                         相关方法                        说明
 * android:dateTextAppearance     setDateTextAppearance(int)    设置该日历视图的日期文字的样式
 * android:firstDayOfWeek         setFirstDayOfWeek(int)        设置每周的第一天,允许设置周一到周五任意一天作为每周的第一天
 * android:focusedMonthDateColor  setFocusedMonthDateColor(int) 设置获得焦点的月份的日期文字的颜色
 * android:maxDate                setMaxData(long)              设置该日历组件支持的最大日历.以mm/dd/yyyy格式指定最大日期
 * android:minDate                setMinDate(long)              设置该日历组件支持的最大日历.以mm/dd/yyyy格式指定最大日期
 * android:selectedDateVericalBar setSelectedDateVericalBar(int) 设置绘制在选中日期两边的竖线对应的Drawable
 * android:selectedWeekBackgroundColor  setSelectedWeekBackgroundColor(int)  设置被选中周的背景色
 * android:showWeekNumber         setShowWeekNumber(boolean)    设置是否显示第几周
 * android:shownWeekCount         setShownWeekCount(int)        设置该日历组件总共显示几个星期
 * android:unfocusedMonthDateColor setUnfocusedMonthDateColor(int) 设置没有焦点的月份的日期文字的颜色
 * android:weekDayTextAppearance  setWeekDayTetAppearance(int)  设置星期几的文字样式
 * android:weekNumberColor        setWeekNumberColor(int)       设置显示周编号的颜色
 * android:weekSeparatorLineColor setWeekSeparatorLineColor(int) 设置周分割线的颜色
 */
public class CalendarViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view);
        CalendarView cv = findViewById(R.id.calendarView);
        cv.setOnDateChangeListener((view,year,month,dayOfMonth)->{
            Toast.makeText(this, "你生日是"+year+"年"+(month+1)+"月"+dayOfMonth+"日", Toast.LENGTH_SHORT).show();
            //这里可以直接获取到年份月份日期
        });
    }
}