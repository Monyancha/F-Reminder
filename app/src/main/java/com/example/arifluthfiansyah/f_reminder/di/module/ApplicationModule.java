package com.example.arifluthfiansyah.f_reminder.di.module;

import android.app.Application;

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

}
