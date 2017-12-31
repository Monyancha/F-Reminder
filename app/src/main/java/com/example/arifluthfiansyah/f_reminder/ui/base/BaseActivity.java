package com.example.arifluthfiansyah.f_reminder.ui.base;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arifluthfiansyah.f_reminder.R;
import com.example.arifluthfiansyah.f_reminder.controller.IncomeController;
import com.example.arifluthfiansyah.f_reminder.controller.OutcomeController;
import com.example.arifluthfiansyah.f_reminder.model.Income;
import com.example.arifluthfiansyah.f_reminder.model.Outcome;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Arif Luthfiansyah on 11-Dec-17.
 */

public class BaseActivity extends AppCompatActivity {


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

    public String getCurrentOfDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        return df.format(calendar.getTime());
    }

    public void showSnackbar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).setAction("Action", null).show();
    }

    public void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void printLog(String tag, String message) {
        Log.d(tag, message);
    }
}
