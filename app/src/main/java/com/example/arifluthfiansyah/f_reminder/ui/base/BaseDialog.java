package com.example.arifluthfiansyah.f_reminder.ui.base;

import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Arif Luthfiansyah on 11-Dec-17.
 */

public class BaseDialog extends DialogFragment implements DialogMvpView{

    public String getCurrentOfDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        return df.format(calendar.getTime());
    }

    public void showToastMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }


    public void printLog(String tag, String message) {
        Log.d(tag, message);
    }
}
