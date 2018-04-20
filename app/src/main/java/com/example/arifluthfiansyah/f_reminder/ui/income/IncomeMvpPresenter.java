package com.example.arifluthfiansyah.f_reminder.ui.income;

import com.example.arifluthfiansyah.f_reminder.data.db.model.Income;
import com.example.arifluthfiansyah.f_reminder.ui.base.MvpPresenter;

import java.util.List;

public interface IncomeMvpPresenter<V extends IncomeMvpView> extends MvpPresenter<V> {
    void setResult();
    List<Income> getIncomes();
}
