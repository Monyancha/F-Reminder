package com.example.arifluthfiansyah.f_reminder.ui.main;

import com.example.arifluthfiansyah.f_reminder.data.DataManager;
import com.example.arifluthfiansyah.f_reminder.data.db.model.Income;
import com.example.arifluthfiansyah.f_reminder.data.db.model.Outcome;
import com.example.arifluthfiansyah.f_reminder.ui.base.BasePresenter;

import javax.inject.Inject;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    @Inject
    public MainPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void onAttach(V mMvpView) {
        super.onAttach(mMvpView);
        setupPrefixData();
    }

    @Override
    public void setupPrefixData() {
        int totalIncome = 0, totalOutcome = 0;
        for (Outcome o : getDataManager().getOutcomes()) {
            totalOutcome += o.getPrice();
        }
        for (Income i : getDataManager().getIncomes()) {
            totalIncome += i.getPrice();
        }
        if ((totalIncome - totalOutcome) < 0) {
            getMvpView().setNotification("Warning!", "Save your money for your future!");
        } else {
            getMvpView().setNotification("Great!", "Save!");
        }
        getMvpView().setStartText(totalIncome, totalOutcome, totalIncome - totalOutcome);
    }
}
