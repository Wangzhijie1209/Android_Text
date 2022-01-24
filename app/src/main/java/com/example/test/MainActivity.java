package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity的四种加载模式
 * 1.standard(标准模式):每次通过standard模式加载Activity时,安卓会为目标activity创建一个新的实例添加到栈中,这种模式不会启动新的Task栈,新的Activity将被添加到原有的栈中。
 * 2.singleTop(栈顶复用模式):当将要启动的Activity已经位于栈顶时,系统不会重新创建目标Activity的实例,而是直接复用已有的Activity实例，如果将要启动的Activity没有位于栈顶
 *                          此时系统会重新创建目标Activity的实例.并将它加载到栈顶,
 * 3.singleTask(栈内单例模式):singleTask模式能保证同一个情况下Task内只一个实例,当系统采用singleTask模式，可分为三种情况:
 *                          1.如果将要启动的Activity不存在，则创建目标Activity的实例，并将它添加到Task栈顶。
 *                          2.如果将要启动的目标Activity已经位于Task栈顶,则直接复用，
 *                          3.如果将要启动的目标Activity已经存在、但没有位于Task栈顶,系统会把位于该Activity上面的所有Activity移出Task栈,从而使得目标Activity转入栈顶
 *4.singleInstance(全局单例模式):在使用singleInstance模式时,系统保证无论从哪个Task中启动目标Activity,只会创建一个目标Activity实例,并会使用一个全新的Task栈来加载该Activity
 *                             当系统采用singleInstance模式启动目标Activity时,可分为以下两种情况:
 *                             1.如果将要启动的目标Activity不存在,系统会先创建一个全新的Task,再创建目标Activity的实例,并将它加入新的Task栈顶。
 *                             2.如果将要启动的目标Activity已经存在,无论他位于哪个应用程序中，位于哪个Task中，系统都会把该Activity所在的Task转到前台，从而使该Activity显示出来
 *                             只要是采用singleInstance模式记载的Activity一定是位于Task栈顶，并且采用singleInstance模式加载的Activity所在Task将只包含该Activity.
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    private Button mMainButton;
    private TextView mMainTextview;

    //在onCreate方法外打 logt 按下tab自动补全 就可以生成一个以当前类名作为值生成一个TAG常量
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mMainButton = (Button) findViewById(R.id.main_button);
        mMainTextview = (TextView) findViewById(R.id.main_textview);
        mMainTextview.setText("Activity为"+this.toString()+"/n"+"Task ID为"+this.getTaskId());
        mMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AActivity.class));
                Log.w("data", "onClick: " );
            }
        });
    }
}