package com.example.arifluthfiansyah.f_reminder.di.module;

import android.app.Application;
import android.content.Context;

import com.example.arifluthfiansyah.f_reminder.data.AppDataManager;
import com.example.arifluthfiansyah.f_reminder.data.DataManager;
import com.example.arifluthfiansyah.f_reminder.data.db.AppDbHelper;
import com.example.arifluthfiansyah.f_reminder.data.db.DbHelper;
import com.example.arifluthfiansyah.f_reminder.data.prefs.AppPreferencesHelper;
import com.example.arifluthfiansyah.f_reminder.data.prefs.PreferencesHelper;
import com.example.arifluthfiansyah.f_reminder.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    Realm provideRealm() {return Realm.getDefaultInstance();}

    @Provides
    @ApplicationContext
    Context provideContext() {return mApplication.getApplicationContext();}

    @Provides
    Application provideApplication(){return mApplication;}

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager){return appDataManager;}

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper){return appDbHelper;}

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper){return appPreferencesHelper;}


}
