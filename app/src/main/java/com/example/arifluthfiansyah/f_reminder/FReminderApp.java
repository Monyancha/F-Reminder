package com.example.arifluthfiansyah.f_reminder;

import android.app.Application;
import android.content.Context;

import com.example.arifluthfiansyah.f_reminder.data.DataManager;
import com.example.arifluthfiansyah.f_reminder.di.component.ApplicationComponent;
import com.example.arifluthfiansyah.f_reminder.di.module.ApplicationModule;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by Arif Luthfiansyah on 11-Dec-17.
 */

public class FReminderApp extends Application {
    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    public static FReminderApp get(Context context){
        return (FReminderApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
