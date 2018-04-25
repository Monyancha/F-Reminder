package com.example.arifluthfiansyah.f_reminder.di.component;


import android.app.Application;
import android.content.Context;

import com.example.arifluthfiansyah.f_reminder.FReminderApp;
import com.example.arifluthfiansyah.f_reminder.data.DataManager;
import com.example.arifluthfiansyah.f_reminder.di.ApplicationContext;
import com.example.arifluthfiansyah.f_reminder.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(FReminderApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}