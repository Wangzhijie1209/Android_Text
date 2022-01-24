package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.test.R;

/**
 * SearchView是搜索框组件,它可以让用户在文本框内输入文字,并允许通过监听器监控用户输入,当用户输入完成后提交搜索时,
 * 也可通过监听器执行实际的搜索。
 * 常用方法:
 *  setIconifiedByDefault(boolean iconified):设置该搜索框默认是否自动缩小为图标。
 *  setSubmitButtonEnabled(boolean enabled):设置是否显示搜索按钮。
 *  setQueryHint(CharSequence hint):设置搜索框内默认显示的提示文本。
 *  setOnQueryTextListener(SearchView.OnQueryTextListener listener):为该搜索框设置事件监听器
 *  如果为SearchView增加一个配套的ListView,则可以为SearchView增加自动完成的功能。
 */
public class SearchViewActivity extends AppCompatActivity {

    //自动完成的列表
    private String[] mStrings = new String[]{"aaaaa","bbbbb","ccccc"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        final ListView lv = findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,mStrings));
        //设置ListView启用过滤
        lv.setTextFilterEnabled(true);
        SearchView sv = findViewById(R.id.sv);
        //设置该SearchView默认是否自动缩小图标
        sv.setIconifiedByDefault(false);
        //设置该SearchView显示搜索内容
        sv.setSubmitButtonEnabled(true);
        //设置该SearchView内默认显示的提示文字
        sv.setQueryHint("查找");
        //为该SearchView组件设置事件监听器
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //用户输入字符时激发该方法
            @Override
            public boolean onQueryTextSubmit(String s) {
                //如果s不是长度为0的字符串
                if(TextUtils.isEmpty(s)){
                    //清楚ListView的过滤
                    lv.clearTextFilter();
                }else {
                    //使用用户输入的内容对ListView的列表项进行过滤
                    lv.setFilterText(s);
                }
                return true;
            }

            //单击搜索按钮时激发该方法
            @Override
            public boolean onQueryTextChange(String s) {
                //实际应用中应该在该方法内执行实际查询
                //此处仅使用Toast显示用户输入端查询内容
                Toast.makeText(SearchViewActivity.this, "您的选中是"+s, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}