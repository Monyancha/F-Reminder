package com.example.arifluthfiansyah.f_reminder.ui.main;

import com.example.arifluthfiansyah.f_reminder.ui.base.MvpPresenter;

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {
    void setupPrefixData();
}
