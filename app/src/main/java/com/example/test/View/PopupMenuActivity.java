package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.test.R;

/**
 * 弹出式菜单
 * 使用方式
 * 1.调用PopupMenu(Context context,View anchor)构造器创建下拉菜单,anchor代表要激发该弹出菜单的组件
 * 2.调用MenuInflater的inflate()方法将菜单资源填充到PopupMenu中
 * 3.调用PopupMenu的show()方法显示弹出式菜单。
 */
public class PopupMenuActivity extends AppCompatActivity {

    private PopupMenu popup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);
        Button button = findViewById(R.id.popupmenu_button);
        TextView txt = findViewById(R.id.popupmenu_textView);
        //创建PopupMenu对象
        popup = new PopupMenu(this,button);
        //加载菜单资源
        getMenuInflater().inflate(R.menu.menu_one,popup.getMenu());
        popup.setOnMenuItemClickListener(item ->{
            switch (item.getItemId()){
                case R.id.red_font:
                    txt.setTextColor(Color.RED);
                    break;
                case R.id.green_font:
                    txt.setTextColor(Color.GREEN);
                    break;
                case R.id.blue_font:
                    txt.setTextColor(Color.BLUE);
                    break;
            }
            return true;
        });
    }

    public void onPopupButtonClick(View view) {
        popup.show();
    }
}