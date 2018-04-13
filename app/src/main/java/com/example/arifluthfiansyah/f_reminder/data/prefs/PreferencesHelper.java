package com.example.arifluthfiansyah.f_reminder.data.prefs;

public interface PreferencesHelper {
    void setIsFirstTime(boolean firstTime);
    boolean getIsFirstTime();
    void clearAll();
}
