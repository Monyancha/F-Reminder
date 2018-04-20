package com.example.arifluthfiansyah.f_reminder.ui.income;

import com.example.arifluthfiansyah.f_reminder.data.db.model.Income;
import com.example.arifluthfiansyah.f_reminder.ui.base.MvpView;

import java.util.List;

public interface IncomeMvpView extends MvpView {
    void setResult(int totalOutcome, int totalIncome);
    void updateIncomes(List<Income> incomes);
}
