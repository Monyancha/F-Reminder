package com.example.arifluthfiansyah.f_reminder.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.arifluthfiansyah.f_reminder.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Arif Luthfiansyah on 12-Dec-17.
 */

@Singleton
public class AppPreferencesHelper implements PreferencesHelper{

    private static final String PREF_NAME = "F-REMINDER";
    private static final String PREF_KEY_IS_FIRST_TIME = "PREF_KEY_IS_FIRST_TIME";

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context) {
        mPrefs = context.getApplicationContext()
                .getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void clearAll() {
        mPrefs.edit().clear().apply();
    }

    @Override
    public void setIsFirstTime(boolean firstTime) {
        mPrefs.edit().putBoolean(PREF_KEY_IS_FIRST_TIME, firstTime).apply();
    }

    @Override
    public boolean getIsFirstTime() {
        return mPrefs.getBoolean(PREF_KEY_IS_FIRST_TIME, true);
    }
}
