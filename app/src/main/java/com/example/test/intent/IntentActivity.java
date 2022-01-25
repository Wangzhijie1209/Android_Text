package com.example.test.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

/**
 * 隐式Intent使用:
 */
public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
    }

    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }

    public void onclicktel(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:10086"));
        startActivity(intent);
    }

    public void onClickgeo(View view) {
    }

    public void onclicks(View view) {
        String data = "王志杰真帅";
        Intent intent = new Intent(IntentActivity.this,BIntentActivity.class);
        intent.putExtra("data", data);
        Bundle bundle = new Bundle();
        bundle.putString("string",data);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}