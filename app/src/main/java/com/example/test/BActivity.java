package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.View.MainActivity;

import java.io.Serializable;

public class BActivity extends AppCompatActivity  {

    private EditText mBEtId;
    private EditText mBEtPwd;
    private EditText mBEtPwd2;
    private Button mBButtonRegister;
    private Button mBButtonReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bactivity);
        initView();
    }

    private void initView() {
        mBEtId = (EditText) findViewById(R.id.b_et_id);
        mBEtPwd = (EditText) findViewById(R.id.b_et_pwd);
        mBEtPwd2 = (EditText) findViewById(R.id.b_et_pwd2);
        mBButtonRegister = (Button) findViewById(R.id.b_button_register);
        mBButtonReturn = (Button) findViewById(R.id.b_button_return);

        Intent intent = getIntent();

//        mBButtonRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String pwd = mBEtPwd.getText().toString();
//                String pwd2 = mBEtPwd2.getText().toString();
//                if (pwd.equals(pwd2)) {
//                    Toast.makeText(BActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(BActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        mBButtonReturn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Person person = new Person(mBEtId.getText().toString(), mBEtPwd.getText().toString());
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("person",person);
//                Intent intent = new Intent(BActivity.this, AActivity.class);
//                intent.putExtras(bundle);
//                startActivityForResult(intent,200);
//            }
//        });
    }
}