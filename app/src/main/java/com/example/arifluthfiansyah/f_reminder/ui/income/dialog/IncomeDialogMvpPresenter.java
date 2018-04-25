package com.example.arifluthfiansyah.f_reminder.ui.income.dialog;

import com.example.arifluthfiansyah.f_reminder.data.db.model.Income;
import com.example.arifluthfiansyah.f_reminder.ui.base.MvpPresenter;

public interface IncomeDialogMvpPresenter<V extends IncomeDialogMvpView> extends MvpPresenter<V> {
    void updateIncome(Income income);
    void addIncome(Income income);
}
