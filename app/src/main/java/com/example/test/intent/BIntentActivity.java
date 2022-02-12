package com.example.test.intent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

public class BIntentActivity extends AppCompatActivity {
    private static final String TAG = "Cannot invoke method length() on null object";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bintent);
        TextView textView = findViewById(R.id.b_text);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String string = extras.getString("string");
        Log.w(TAG, "www"+string );
        String data = intent.getStringExtra("data");
        textView.setText(data);

    }

    //当用户按下Back返回键,就会执行这个方法，可以在这里做一些传输数据的操作
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data","wangzhijie");
        setResult(RESULT_OK,intent);
        finish();
    }
}