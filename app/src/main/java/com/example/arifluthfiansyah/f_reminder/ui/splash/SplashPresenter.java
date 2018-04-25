package com.example.arifluthfiansyah.f_reminder.ui.splash;

import com.example.arifluthfiansyah.f_reminder.data.DataManager;
import com.example.arifluthfiansyah.f_reminder.data.db.model.Income;
import com.example.arifluthfiansyah.f_reminder.data.db.model.Outcome;
import com.example.arifluthfiansyah.f_reminder.ui.base.BasePresenter;

import javax.inject.Inject;

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V> implements SplashMvpPresenter<V>{

    @Inject
    public SplashPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        decideNextActivity();
    }

    @Override
    public void decideNextActivity(){
        if(!getDataManager().getIsFirstTime()){
            setupPrefixData();
        }
        getMvpView().openMainActivity();
    }

    public void setupPrefixData() {
            getDataManager().deleteOutcomes();
            getDataManager().addOutcome(new Outcome(System.currentTimeMillis(), "Beli buah 1", "Buah mangga", 10000, getCurrentOfDate()));
            getDataManager().addOutcome(new Outcome(System.currentTimeMillis(), "Beli buah 2", "Buah mangga", 10000, getCurrentOfDate()));
            getDataManager().addOutcome(new Outcome(System.currentTimeMillis(), "Beli buah 3", "Buah mangga", 10000, getCurrentOfDate()));
            getDataManager().addOutcome(new Outcome(System.currentTimeMillis(), "Beli buah 4", "Buah mangga", 10000, getCurrentOfDate()));
            getDataManager().addOutcome(new Outcome(System.currentTimeMillis(), "Beli buah 5", "Buah mangga", 10000, getCurrentOfDate()));
            getDataManager().deleteIncomes();
            getDataManager().addIncome(new Income(System.currentTimeMillis(), "Pendapatan 1", 10000, getCurrentOfDate()));
            getDataManager().addIncome(new Income(System.currentTimeMillis(), "Pendapatan 1", 10000, getCurrentOfDate()));
            getDataManager().addIncome(new Income(System.currentTimeMillis(), "Pendapatan 1", 10000, getCurrentOfDate()));
            getDataManager().addIncome(new Income(System.currentTimeMillis(), "Pendapatan 1", 10000, getCurrentOfDate()));
            getDataManager().addIncome(new Income(System.currentTimeMillis(), "Pendapatan 1", 10000, getCurrentOfDate()));
            getDataManager().setIsFirstTime(false);
    }

}
