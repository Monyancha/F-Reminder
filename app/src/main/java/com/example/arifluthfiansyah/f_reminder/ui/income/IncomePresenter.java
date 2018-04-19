package com.example.arifluthfiansyah.f_reminder.ui.income;

import com.example.arifluthfiansyah.f_reminder.data.DataManager;
import com.example.arifluthfiansyah.f_reminder.ui.base.BasePresenter;

import javax.inject.Inject;

public class IncomePresenter<V extends IncomeMvpView> extends BasePresenter<V> implements IncomeMvpPresenter<V>{

    @Inject
    public IncomePresenter(DataManager mDataManager) {
        super(mDataManager);
    }
}
