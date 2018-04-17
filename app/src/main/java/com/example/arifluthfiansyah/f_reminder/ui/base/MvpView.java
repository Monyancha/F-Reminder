package com.example.arifluthfiansyah.f_reminder.ui.base;

import android.view.View;

public interface MvpView {
    void setNotification(String title, String content);
    void showSnackbar(View view, String message);
    void showToastMessage(String message);
    void printLog(String tag, String message);
}
