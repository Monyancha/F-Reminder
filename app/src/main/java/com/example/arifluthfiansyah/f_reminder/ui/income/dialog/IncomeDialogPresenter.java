package com.example.arifluthfiansyah.f_reminder.ui.income.dialog;

import com.example.arifluthfiansyah.f_reminder.data.DataManager;
import com.example.arifluthfiansyah.f_reminder.data.db.model.Income;
import com.example.arifluthfiansyah.f_reminder.ui.base.BasePresenter;

import javax.inject.Inject;

public class IncomeDialogPresenter<V extends IncomeDialogMvpView> extends BasePresenter<V> implements IncomeDialogMvpPresenter<V> {
    @Inject
    public IncomeDialogPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void updateIncome(Income income) {
        getDataManager().updateIncome(income);
    }

    @Override
    public void addIncome(Income income) {
        getDataManager().addIncome(income);
    }
}
