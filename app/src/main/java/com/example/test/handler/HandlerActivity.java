package com.example.test.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.R;

/**
 * Handler是干什么的:
 *          Handler是让开发者参与处理线程中消息循环的机制.每个Handler都关联了一个线程
 *          每个线程内部都维护了一个消息队列MessageQueue,这样Handler实际上也就关联了
 *          一个消息队列。可以通过Handler将Message和Runnable对象发送到该Handler所
 *          关联线程的MessageQueue(消息队列中),然后该消息队列一直在循环拿出一个Message,
 *          对齐进行处理，处理完之后拿出下一个Message,继续进行处理,周而复始。当创建一个Handler
 *          的时候,该Handler就绑定了当前创建Handler的线程。从这时起，该Handler就可以发送
 *          Message和Runnable对象到该Handler对应的消息队列中，当从MessageQueue取出某个Message
 *          时,会让Handler对其进行处理。
 *
 *          Handler可以用来在多线程间进行通信,在另一个线程中去更新UI线程中的UI控件只是
 *          Handler使用中的一种典型案例,除此之外,Handler可以做很多其他的事情。每个Handler
 *          都绑定了一个线程，假设存在两个线程ThreadA和ThreadB,并且HandlerA绑定了ThreadA,
 *          在ThreadB中的代码执行到某处时，出于某些原因,我们需要让ThreadA执行某些代码，此时我们
 *          就可以使用Handler,我们可以在ThreadB中向HandlerA中加入某些信息以告知ThreadA中该
 *          做某些处理了。
 *          由此看出,Handler是Thread的代言人,是多线程之间通信的桥梁,通过Handler,我们可以在一个
 *          线程中控制另外一个线程去做某事。
 */
public class HandlerActivity extends AppCompatActivity implements View.OnClickListener {

    public static String TAG;

    //uiHandler在主线程中创建,所以自动绑定主线程
    private Handler uiHandler = new Handler();
    private TextView statusTextView;
    private Button btnDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler3);
        statusTextView = findViewById(R.id.statusTextView);
        btnDownload = findViewById(R.id.btnDownload);
        btnDownload.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        DownloadThread downloadThread = new DownloadThread();
        downloadThread.start();
    }

    /**
     * 我们在Activity中创建了一个Handler成员变量uiHandler，Handler有个特点,在执行
     * new Handler()的时候,默认情况下Handler会绑定当前代码执行的线程,我们在主线程中实例化
     * 了uiHandler,所以uiHandler就会自动绑定到主线程,即Ui线程,当我们在DownloadThread中执行
     * 完耗时代码后,我们将一个Runnable对象通过post方法传入到了Handler中,Handler会在合适的时候让
     * 主线程执行Runnable中的代码，这样Runnable就在主线程中执行了.从而正确更新了主线程中的UI
     */

    class DownloadThread extends Thread{
        @Override
        public void run() {
            try {
                //让线程睡眠5秒，模拟文件的耗时过程
                Thread.sleep(5000);

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        HandlerActivity.this.statusTextView.setText("文件下载完成");
                    }
                };
                //运行Runnable代码的线程与Handler所绑定的线程是一致的，而执行Handler.post(runnable)
                //这句代码的线程(DownloadThread)无关
                uiHandler.post(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}