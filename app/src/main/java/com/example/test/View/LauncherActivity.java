package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里主要是使用了ViewAnimator基类  也就是视图动画 他继承了FrameLayout
 * 做了一个仿安卓系统的Launcher界面 分屏 左右滚动
 * 为了实现效果,程序主界面使用ViewSwitcher来组合多个GridView  每个GridView代表一个屏幕的应用程序,
 * GridView中每个单元格显示一个应用程序的图标和程序名
 */
public class LauncherActivity extends AppCompatActivity {
    //定义一个常量,用于显示每屏显示的应用程序数
    public static final int NUMBER_PER_SCREEN = 12;
    private List<DataItem> items = new ArrayList<>();
    //记录当前正在显示第几屏的程序
    private int screenNo = -1;
    //保存程序所占的总屏数
    private int screenCount = 0;
    private ViewSwitcher switcher;
    //创建LayoutInflater对象
    private LayoutInflater inflater;
    //该BaseAdapter负责为每屏显示的GridView提供列表项
    private BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            //如果已经到了最后一屏,且应用程序的数量不能整除NUMBER_PER_SCREEN
            if (screenNo == screenCount - 1 && items.size() % NUMBER_PER_SCREEN != 0) {
                //最后一屏显示的程序数为应用程序的数量对NUMBER_PER_SCREEN求余数
                return items.size() % NUMBER_PER_SCREEN;
                //否则每瓶显示的程序数为NUMBER_PER_SCREEN
            } else {
                return NUMBER_PER_SCREEN;
            }
        }

        @Override
        public DataItem getItem(int i) {
            //根据screenNo计算position个列表项的数据
            return items.get(screenNo * NUMBER_PER_SCREEN + i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View views, ViewGroup viewGroup) {
            View view;
            ViewHolder viewHolder;
            if (views == null) {
                //加载R.layout.labelicon布局文件
                view = inflater.inflate(R.layout.labelicon, null);
                ImageView imageView = view.findViewById(R.id.imageview);
                TextView textView = view.findViewById(R.id.textview);
                viewHolder = new ViewHolder(imageView, textView);
                view.setTag(viewHolder);
            } else {
                view = views;
                viewHolder = (ViewHolder) view.getTag();
            }
            //获取R.layout.labelicon布局文件中的ImageView组件,并为之设置图标
            viewHolder.imageView.setImageDrawable(getItem(i).drawable);
            //获取R.layout.labelicon布局文件中的TextView组件,并为之设置文本
            viewHolder.textView.setText(getItem(i).dataName);
            return view;
        }
    };

    public static class DataItem {
        //应用程序名称
        String dataName;
        Drawable drawable;

        public DataItem(String dataName, Drawable drawable) {
            this.dataName = dataName;
            this.drawable = drawable;
        }
    }

    //代表应用程序的内部类
    public static class ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(ImageView imageView, TextView textView) {
            this.imageView = imageView;
            this.textView = textView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        inflater = LayoutInflater.from(this);
        //创建一个包含40个元素的List集合,用于模拟包含40个应用程序
        for (int i = 0; i < 40; i++) {
            String label = "" + i;
            Drawable drawable = getResources().getDrawable(R.drawable.a, null);
            DataItem item = new DataItem(label, drawable);
            items.add(item);
        }
        //计算应用程序所占的总屏数
        //入股哦应用程序的数量能整除NUMBER_PER_SCREEN,除法的结果就是总屏数
        //如果不能整除,总屏数应该是除法的结果再加1
        screenCount = items.size() % NUMBER_PER_SCREEN == 0 ?
                items.size() / NUMBER_PER_SCREEN :
                items.size() / NUMBER_PER_SCREEN + 1;
        switcher = findViewById(R.id.viewSwitcher);
        switcher.setFactory(() -> {
            //加载R.layout.slidelistview组件,实际上就是一个GridView组件
            return inflater.inflate(R.layout.slidelistview, null);
        });
        next(null);
    }

    public void next(View view) {
        if (screenNo < screenCount - 1) {
            screenNo++;
            //为ViewSwitcher的组件显示过程动画
            switcher.setInAnimation(this, R.anim.slide_in_right);
            //为ViewSwitcher的组件隐藏过程设置动画
            switcher.setOutAnimation(this,R.anim.slide_out_left);
            //控制下一屏将要显示的GridView对应的Adapter
            ((GridView)switcher.getNextView()).setAdapter(adapter);
            //单击右边按钮,显示下一屏
            //学习手势检测后,也可通过手势检测实现显示下一屏
            switcher.showNext();

        }
    }

    public void prev(View view) {
        if(screenNo > 0){
            screenNo--;
            //为ViewSwitcher 的组件显示过程设置动画
            switcher.setInAnimation(this,R.anim.slide_out_left);
            //为ViewSwitcher 的组件隐藏过程设置动画
            switcher.setOutAnimation(this,R.anim.slide_in_right);
            ((GridView)switcher.getNextView()).setAdapter(adapter);
            //单击右边按钮,显示下一屏
            //学习手势检测后,也可通过手势检测实现显示下一屏
            switcher.showPrevious();
        }
    }



}