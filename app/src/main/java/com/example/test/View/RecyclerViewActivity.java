package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.test.R;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recycle;
    private ArrayList<RecyclerBean> recyclerBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        initView();
    }

    private void initView() {
        recycle = findViewById(R.id.recycler);
        //设置RecyclerView保持固定大小,这样可以优化RecyclerView的性能
        recycle.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置RecyclerView的滚动方向
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //为RecyclerView设置布局管理器
        recycle.setLayoutManager(layoutManager);
        recyclerBeans = new ArrayList<>();
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, recyclerBeans);
        initData();
        recycle.setAdapter(recyclerAdapter);
        recyclerAdapter.setmOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this, "点击了条目", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this, "长按了条目", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initData() {
        String[] name = new String[]{"王志杰", "Kevin", "巧克力", "多了只", "小命"};
        String[] type = new String[]{"1", "2", "3", "4", "5"};
        int[] img = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e};
        for (int i = 0; i < name.length; i++) {
            recyclerBeans.add(new RecyclerBean(img[i], name[i], type[i]));
        }
    }
}