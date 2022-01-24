package com.example.test.event_handlling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.test.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 为了解决主线程和子线程交互 Android提供了如下方案
 * 1.使用Handler实现线程之间的通信
 * Activity.runOnUiThread(Runnable)
 * View.post(Runnable)
 * View.postDelayed(Runnable,long)
 * AsyncTask
 * <p>
 * AsyncTask<Params,Progress,Result> 是一个抽象类,通常用于被继承,继承AsyncTask时需要指定如下三个泛型参数。
 * Params:启动任务执行的输入参数的类型
 * Progress:后台任务完成的进度值的类型
 * Result:后台执行任务完成后返回结果的类型
 * 使用AsyncTask只要如下三步
 * 1.创建AsyncTask的子类,并为三个泛型参数指定类型.如果某个泛型参数不需要指定类型,则可将它们指定为void
 * 2.根据需要 实现AsyncTask的如下方法
 * doInBackground(Params):重写该方法就是后台线程将要完成的任务。该方法可以调用publishProgress(Progress values)方法更新任务的执行进度
 * onProgressUpdate(Progress valuse):在doInBackground()方法中调用publishProgress()方法更新任务的执行进度后,将会触发该方法
 * onPreExecute():该方法将在执行后台耗时操作前被调用,通常该方法用于完成一些初始化的准备工作,比如在界面上显示进度条等
 * onPostExecute(Result result):当doInBackground()完成后,系统会自动调用onPostExecute()方法，并将doInBackground()方法的返回值传给该方法
 * 3.调用AsyncTask子类的实例的execute(Params params)老师执行耗时任务
 * 使用AsyncTask时必须遵守如下规则。
 * 必须在UI线程中创建AsyncTask的实例
 * 必须在UI线程中调用AsyncTask的execute()方法
 * AsyncTask的onPreExecute()、
 * onPostExecute(Result result)
 * doInBackground(Params params)
 * onProgressUpdate(Progress values)
 * 这些方法不应该由程序员调用，而是由安卓系统调用
 * 每个AsyncTask只能被执行一次,多次调用将会金发异常，
 */
public class AsyncTaskActivity extends AppCompatActivity {

    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        show = findViewById(R.id.show);
    }

    //重写该方法 为界面上的按钮提供事件相应方法
    public void DownLoad(View source) throws MalformedURLException {
        DownTask task = new DownTask((ProgressBar) findViewById(R.id.progressBar), this);
        //开始执行异步任务
        task.execute(new URL("http://lmg.jj20.com/up/allimg/tp01/1ZZ91T45V0U-0-lp.jpg"));
    }

    class DownTask extends AsyncTask<URL, Integer, String> {
        private ProgressBar progressBar;
        //定义记录已经读取行的数量
        int hasRead = 0;
        Context mContext;

        public DownTask(ProgressBar progressBar, Context mContext) {
            this.progressBar = progressBar;
            this.mContext = mContext;
        }

        //完成实际的下载任务
        @Override
        protected String doInBackground(URL... params) {
            StringBuilder sb = new StringBuilder();
            try {
                URLConnection conn = params[0].openConnection();
                //打开conn链接对应的输入流,并将它包装成BufferedReader
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null){
                    sb.append(line+"\n");
                    hasRead++;
                    publishProgress(hasRead);
                }
                return sb.toString();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        //负责当下载完成后，将下载的代码显示出来
        @Override
        protected void onPostExecute(String s) {
            show.setText(s);
            progressBar.setVisibility(View.INVISIBLE);
            super.onPostExecute(s);
        }

        //在开始下载的时候显示一个进度条
        @Override
        protected void onPreExecute() {
            //设置进度条可见
            progressBar.setVisibility(View.VISIBLE);
            //设置进度条的当前值
            progressBar.setProgress(0);
            //设置该进度条的最大进度值
            progressBar.setMax(120);
        }

        //随着下载的进度改变更新进度条的进度值
        @Override
        protected void onProgressUpdate(Integer... values) {
            //更新进度
            show.setText("已经读取了["+values[0]+"]行");
            progressBar.setProgress(values[0]);

        }
    }
}