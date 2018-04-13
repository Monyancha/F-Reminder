package com.example.arifluthfiansyah.f_reminder.data;

import android.content.Context;

import com.example.arifluthfiansyah.f_reminder.data.db.DbHelper;
import com.example.arifluthfiansyah.f_reminder.data.prefs.PreferencesHelper;
import com.example.arifluthfiansyah.f_reminder.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDataManager implements DataManager {
    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context mContext, DbHelper mDbHelper, PreferencesHelper mPreferencesHelper) {
        this.mContext = mContext;
        this.mDbHelper = mDbHelper;
        this.mPreferencesHelper = mPreferencesHelper;
    }
}
