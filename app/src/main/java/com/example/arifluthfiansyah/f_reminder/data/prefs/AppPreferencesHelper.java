package com.example.arifluthfiansyah.f_reminder.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Arif Luthfiansyah on 12-Dec-17.
 */

public class AppPreferencesHelper implements PreferencesHelper{

    private static final String PREF_NAME = "F-REMINDER";
    private static final String PREF_KEY_IS_FIRST_TIME = "PREF_KEY_IS_FIRST_TIME";

    private static AppPreferencesHelper mInstance;
    private final SharedPreferences mPrefs;

    private AppPreferencesHelper(Context context) {
        mPrefs = context.getApplicationContext()
                .getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static AppPreferencesHelper with(Context context) {
        if (mInstance == null) {
            mInstance = new AppPreferencesHelper(context);
        }
        return mInstance;
    }

    public void clearAll() {
        mPrefs.edit().clear().apply();
    }

    public void setIsFirstTime(boolean firstTime) {
        mPrefs.edit().putBoolean(PREF_KEY_IS_FIRST_TIME, firstTime).apply();
    }

    public boolean getIsFirstTime() {
        return mPrefs.getBoolean(PREF_KEY_IS_FIRST_TIME, true);
    }
}
