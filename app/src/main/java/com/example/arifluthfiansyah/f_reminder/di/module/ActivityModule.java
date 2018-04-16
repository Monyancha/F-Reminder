package com.example.arifluthfiansyah.f_reminder.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.arifluthfiansyah.f_reminder.di.ActivityContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){return mActivity;}

}
