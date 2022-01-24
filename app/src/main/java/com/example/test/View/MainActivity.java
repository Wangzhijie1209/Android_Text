package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.test.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用SimpleAdapter创建ListView
 */
public class MainActivity extends AppCompatActivity {

    private String[] names = new String[]{"虎头","弄玉","李清照","礼拜"};
    private String[] descs = new String[]{"1","2","3","4"};
    private int[] imageIds = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建一个List集合,List集合的元素是map
        List<Map<String,Object>> listItems = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Map<String,Object> listItem = new HashMap<>();
            listItem.put("header",imageIds[i]);
            listItem.put("personName",names[i]);
            listItem.put("desc",descs[i]);
            listItems.add(listItem);
        }
        /**
         * 这部分代码是关键
         * 创建了一个simpleAdapter
         * 第二个参数:该参数应该是一个List<?extends Map<String,?>>类型的集合对象,该集合中每个Map<String,?>对应生成一个列表项。
         * 第三个参数:该参数指定一个界面布局的ID.例如此处指定了R.layout.simple_layout，这意味着使用simple_layout文件作为列表项组件
         * 第四个参数:该参数应该是一个String[]类型的参数,该参数决定提取Map<String,?>对象中哪些Key对应的value来生成列表项
         * 第五个参数:该参数应该是一个int[]类型的参数,改参数决定填充哪些组件
         */
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this,
                listItems,
                R.layout.simple_layout,
                new String[]{"personName","header","desc"},
                new int[]{R.id.name,R.id.header,R.id.desc});
        ListView list = findViewById(R.id.mylist);
        //为ListView设置Adapter
        list.setAdapter(simpleAdapter);
        
        //如果需要监听用户单机、选中某个列表项的点击事件,则可以通过AdapterView的setOnItemClickListener()方法为单机事件添加监听器,或者
        //通过setOnItemSelectedListener()方法为列表项的选中事件添加监听器
        //为ListView的列表项的 单击事件 绑定事件监听器
        list.setOnItemClickListener((parent,view,position,id)->{
            Toast.makeText(this, "点击事件", Toast.LENGTH_SHORT).show();
        });

        //为LsitView的列表项的选中事件绑定事件监听器
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "被选中了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}