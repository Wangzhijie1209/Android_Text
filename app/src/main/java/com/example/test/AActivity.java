package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class AActivity extends AppCompatActivity  {

    private EditText mEtId;
    private EditText mEtPwd;
    private Button mBtnLog;
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w("TAG", "onCreate: " );
        setContentView(R.layout.activity_aactivity);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w("TAG", "onStart: " );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("TAG", "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("TAG", "onPause: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("TAG", "onStop: " );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.w("TAG", "onRestart: " );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("TAG", "onDestroy: " );
    }

    private void initView() {
        mEtId = (EditText) findViewById(R.id.et_id);
        mEtPwd = (EditText) findViewById(R.id.et_pwd);
        mBtnLog = (Button) findViewById(R.id.btn_log);
        mBtnRegister = (Button) findViewById(R.id.btn_register);
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


}