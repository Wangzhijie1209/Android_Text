package com.example.test.event_handlling;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

public class Handler2Activity extends AppCompatActivity {
    private final static String UPPER_NUM = "upper";
    private EditText etNum;
    private CalThread calThread;
    //定义一个线程类
    class CalThread extends Thread{
        private Handler mHandler;

        @Override
        public void run() {
            //1111111调用Loper.prepare()方法为当前线程创建Looper对象，创建looper对象时,他的构造器会创建与之配套的MessageQueue;
            Looper.prepare();
            mHandler = new Handler(){
                //定义处理消息的方法
                //222222重写handlerMessage()方法 该方法负责处理来自其他线程的消息
                @Override
                public void handleMessage(@NonNull Message msg) {
                    if(msg.what == 0x123){
                        int upper = msg.getData().getInt(UPPER_NUM);
                        List<Integer> nums = new ArrayList<Integer>();
                        //计算从2开始、到upper的所有质数
                        outer:
                        for (int i = 2; i <=upper ; i++) {
                            //用i除以从2开始、到i的平方根的所有数
                            int j = 2;
                            while (j<=Math.sqrt(i)){
                                //如果可以整除，则表明这个数不是质数
                                if(i != 2 && i%j==0){
                                    continue  outer;
                                }
                                j++;
                            }
                            nums.add(i);
                        }
                        //使用Toast显示统计出来的所有质数
                        Toast.makeText(Handler2Activity.this, nums.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            };
            //333333调用Looper的loop()方法启动Looper
            Looper.loop();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler2);
        etNum = findViewById(R.id.handler2_editText);
        Button button = findViewById(R.id.handler2_button);
        calThread = new CalThread();
        //启动新线程
        calThread.start();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建消息
                Message msg = new Message();
                msg.what = 0x123;
                Bundle bundle = new Bundle();
                bundle.putInt(UPPER_NUM,Integer.parseInt(etNum.getText().toString()));
                msg.setData(bundle);
                //向新线程中的Handler发送消息
                calThread.mHandler.sendMessage(msg);
            }
        });
    }
}