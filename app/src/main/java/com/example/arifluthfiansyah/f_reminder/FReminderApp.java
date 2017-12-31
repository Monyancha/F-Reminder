package com.example.arifluthfiansyah.f_reminder;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Arif Luthfiansyah on 11-Dec-17.
 */

public class FReminderApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
