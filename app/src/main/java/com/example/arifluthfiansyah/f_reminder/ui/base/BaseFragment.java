package com.example.arifluthfiansyah.f_reminder.ui.base;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.arifluthfiansyah.f_reminder.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Arif Luthfiansyah on 11-Dec-17.
 */

public class BaseFragment extends Fragment implements MvpView{

    @Override
    public void setNotification(String title, String content) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getContext())
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.drawable.ic_attach_money)
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
        NotificationManager mNotificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
        if (mNotificationManager != null) {
            mNotificationManager.notify(0, mBuilder.build());
        }
    }

    public String getCurrentOfDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        return df.format(calendar.getTime());
    }

    @Override
    public void showToastMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public void showSnackbar(View view, String message) {
//        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).setAction("Action", null).show();
//    }

//    @Override
//    public void printLog(String tag, String message) {
//        Log.d(tag, message);
//    }
}
