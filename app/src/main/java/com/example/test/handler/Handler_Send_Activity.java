package com.example.test.handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.R;

public class Handler_Send_Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView statusTextView_send;
    private Button btnDownload_send;

    //uiHandler在主线程中创建,所以自动绑定主线程
    private Handler uiHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 1:
                    Handler_Send_Activity.this.statusTextView_send.setText("文件下载完成");
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_send);
        statusTextView_send = findViewById(R.id.statusTextView_send);
        btnDownload_send = findViewById(R.id.btnDownload_send);
        btnDownload_send.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
    }

    class DownloadThread extends Thread{
        @Override
        public void run() {
            try {
                //让线程休眠5秒,模拟文件的耗时过程
                Thread.sleep(5000);
                Message message = new Message();
                //虽然Message的构造函数是public的，我们也可以通过以下两种方法通过循环对象获取Message
                //msg = Message.obtain(uiHandler);
                //msg = uiHandler.obtainMessage();

                //what是我们自定义的一个Message的标识码,以便于在Handler的HandlerMessage方法中
                //根据what识别出不同的Message,以便我们作出不同的处理操作
                message.what = 1;

                //我们可以通过arg1 和 arg2给Message传入简单的数据
                message.arg1 = 123;
                message.arg2 = 321;

                //我们也可以通过给obj赋值Object类型传递向Message传入任意数据
                //msg.obj = null;
                //我们也可以通过setData方法和getData方法向Message中写入和读取Bundle类型的数据
                //msg.setData(null);
                //Bundle data = msg.getData();

                //将该Message发送给对应的Handler
                uiHandler.sendMessage(message );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}