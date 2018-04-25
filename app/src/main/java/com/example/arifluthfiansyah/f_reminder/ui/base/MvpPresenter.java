package com.example.arifluthfiansyah.f_reminder.ui.base;

public interface MvpPresenter<V extends MvpView> {
    void onAttach(V mMvpView);
    void onDetach();
}
