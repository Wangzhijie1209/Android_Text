package com.example.test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;

import com.example.test.R;

/**
 * 状态栏通知 Notification 是显示在手机状态栏的通知 一般显示手机当前的网络状态、电池状态、时间等。Notification所代表的是一种
 * 具有全局效果的通知,程序一般通过NotificationManager服务来发送Notification.
 * <p>
 * Android 为 Notification提供了Notification.Builder类,通过该类允许开发者更轻松地创建Notification对象,
 * Notification.Builder提供了如下常用方法
 * setDefaults():设置通知LED灯、音乐、震动等.
 * setAutoCancel():设置点击通知后,状态栏自动删除通知。
 * setContentTitle():设置通知标题
 * setContentText():设置通知内容
 * setSmallIcon():为通知设置图标。
 * setLargeIcon():为通知设置大图标.
 * setContentIntent():设置点击通知后要启动的程序组件对应的PendingIntent
 */
public class NotificationActivity extends AppCompatActivity {

    private static final int NOTIFICATION_ID = 0x123;
    private static final String CHANNEL_ID = "crazyit";
    private NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        //获取系统的NotificationManager服务
        nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //设置通知Channel的名字
        String name = "测试Channel";
        //创建通知
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_HIGH);
        //设置通知Channel的描述信息
        channel.setDescription("测试Channel的描述信息");
        //设置通知出现时的闪光灯
        channel.enableLights(true);
        channel.setLightColor(Color.RED);
        //设置通知出现时震动
        channel.enableVibration(true);
        channel.setVibrationPattern(new long[]{0, 50, 100, 150});
        //自定义声音
//        channel.setSound(Uri.parse("android.resource://org.crazyit.ui"+R.raw.msg),null);
        //最后在NotificationManager上创建该通知Channel
        nm.createNotificationChannel(channel);
    }

    public void send(View view) {
        //创建一个启动其他Activity的Intent
        Intent intent = new Intent(NotificationActivity.this, Notification2Activity.class);
        PendingIntent pi = PendingIntent.getActivity(NotificationActivity.this, 0, intent, 0);
        Person p = new Person.Builder()
                .setName("孙悟空")
                .setIcon(Icon.createWithResource(this, R.drawable.b))
                .build();
        //设置通知参与者
        Notification.MessagingStyle messagingStyle = new Notification.MessagingStyle(p);
        //设置消息标题
        messagingStyle.setConversationTitle("一条新通知");
        //创建一条消息
        Notification.MessagingStyle.Message message = new Notification.MessagingStyle.Message("恭喜您,您加薪了,工资正增加20%", System.currentTimeMillis(), p);
        //设置额外数据
//        message.setData("image/jpeg",Uri.parse("file:///mnt/sdcard/a.png"));
        //添加一条消息
        messagingStyle.addMessage(message);
        Notification notify = new Notification.Builder(this, CHANNEL_ID)
                //设置打开该通知，该通知自动消失
                .setAutoCancel(true)
                //设置通知的图标
                .setSmallIcon(R.drawable.d)
                //设置MessaginSystem
                .setStyle(messagingStyle)
                //设置通知肩高启动程序的Intent
                .setContentIntent(pi)
                .build();
        //发送通知
        nm.notify(NOTIFICATION_ID,notify);
    }

    public void cancel(View view) {
        nm.cancel(NOTIFICATION_ID);
    }
}