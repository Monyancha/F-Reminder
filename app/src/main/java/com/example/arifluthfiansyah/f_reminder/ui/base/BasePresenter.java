package com.example.arifluthfiansyah.f_reminder.ui.base;

import com.example.arifluthfiansyah.f_reminder.data.DataManager;

import javax.inject.Inject;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private final DataManager mDataManager;
    private V mMvpView;

    @Inject
    public BasePresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    public void onAttach(V mMvpView){
        this.mMvpView = mMvpView;
    }

    public void onDetach(){
        this.mMvpView = null;
    }
}
