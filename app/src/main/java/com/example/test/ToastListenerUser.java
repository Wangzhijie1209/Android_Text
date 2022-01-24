package com.example.test;

public class ToastListenerUser {
    private ToastListener mToastListener;

    public ToastListenerUser(ToastListener mToastListener) {
        this.mToastListener = mToastListener;
    }
    public void useToast(){
        mToastListener.showToast();
    }
}
interface ToastListener{
    void showToast();
}
