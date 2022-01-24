package com.example.test.event_handlling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.test.R;

/*
使用外部类作为事件监听器类
还可以使用Activity本身作为事件监听器类 其实就是

@Override
public void onClick(View v){
show.setText("按钮呗点击了");
}

或者直接绑定到标签 其实就是在XML中使用属性 onclick

还有就使用Lambda表达式作为事件监听器类
bn.setOnClickListener(view -> show.setText("asd"));
 */
public class ExternalclassActivity extends AppCompatActivity {

    private EditText address;
    private EditText content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_externalclass);
        address = findViewById(R.id.address);
        content = findViewById(R.id.content);
        Button btn = findViewById(R.id.button_send);
        //使用外部类的实例作为事件监听器
        btn.setOnLongClickListener(new SendSmsListener(this,address.getText().toString(),content.getText().toString()));

    }
}