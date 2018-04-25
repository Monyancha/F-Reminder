package com.example.arifluthfiansyah.f_reminder.ui.base;

import com.example.arifluthfiansyah.f_reminder.data.DataManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.inject.Inject;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private final DataManager mDataManager;
    private V mMvpView;

    @Inject
    public BasePresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void onAttach(V mMvpView){
        this.mMvpView = mMvpView;
    }

    @Override
    public void onDetach(){
        this.mMvpView = null;
    }

    public V getMvpView(){return mMvpView;}

    public DataManager getDataManager(){return mDataManager;}


    public String getCurrentOfDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        return df.format(calendar.getTime());
    }
}
