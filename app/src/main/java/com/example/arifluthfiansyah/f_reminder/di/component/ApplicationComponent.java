package com.example.arifluthfiansyah.f_reminder.di.component;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.arifluthfiansyah.f_reminder.FReminderApp;
import com.example.arifluthfiansyah.f_reminder.data.DataManager;
import com.example.arifluthfiansyah.f_reminder.data.db.DbHelper;
import com.example.arifluthfiansyah.f_reminder.data.prefs.PreferencesHelper;
import com.example.arifluthfiansyah.f_reminder.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(FReminderApp fReminderApp);

    Application getApplication();
    DataManager getDataManager();
    PreferencesHelper getPrefsHelper();
    DbHelper getDbHelper();
}
