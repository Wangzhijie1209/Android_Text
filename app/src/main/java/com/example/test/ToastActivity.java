package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    private int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        ToastListenerUser toastListenerUser = new ToastListenerUser(new ToastListener() {
            @Override
            public void showToast() {
                Toast.makeText(ToastActivity.this, "回调"+i, Toast.LENGTH_SHORT).show();
                i++;
            }
        });
        Button button = findViewById(R.id.toast_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastListenerUser.useToast();
            }
        });
    }
}