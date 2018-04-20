package com.example.arifluthfiansyah.f_reminder.ui.base;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.arifluthfiansyah.f_reminder.FReminderApp;
import com.example.arifluthfiansyah.f_reminder.R;
import com.example.arifluthfiansyah.f_reminder.di.component.ActivityComponent;
import com.example.arifluthfiansyah.f_reminder.di.component.DaggerActivityComponent;
import com.example.arifluthfiansyah.f_reminder.di.module.ActivityModule;


/**
 * Created by Arif Luthfiansyah on 11-Dec-17.
 */

public class BaseActivity extends AppCompatActivity implements MvpView{

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((FReminderApp) getApplication()).getApplicationComponent())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    public void setNotification(String title, String content) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.drawable.ic_attach_money)
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (mNotificationManager != null) {
            mNotificationManager.notify(0, mBuilder.build());
        }
    }

//    @Override
//    public void showSnackbar(View view, String message) {
//        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).setAction("Action", null).show();
//    }

    @Override
    public void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public void printLog(String tag, String message) {
//        Log.d(tag, message);
//    }
}
