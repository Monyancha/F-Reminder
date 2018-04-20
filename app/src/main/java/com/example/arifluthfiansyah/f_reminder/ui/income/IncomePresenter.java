package com.example.arifluthfiansyah.f_reminder.ui.income;

import com.example.arifluthfiansyah.f_reminder.data.DataManager;
import com.example.arifluthfiansyah.f_reminder.data.db.model.Income;
import com.example.arifluthfiansyah.f_reminder.data.db.model.Outcome;
import com.example.arifluthfiansyah.f_reminder.ui.base.BasePresenter;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmChangeListener;

public class IncomePresenter<V extends IncomeMvpView> extends BasePresenter<V> implements IncomeMvpPresenter<V>{

    @Inject
    public IncomePresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void setResult(){
        getDataManager().getRealm().addChangeListener(new RealmChangeListener<Realm>() {
            @ParametersAreNonnullByDefault
            @Override
            public void onChange(Realm realm) {
                getMvpView().updateIncomes(getDataManager().getIncomes());
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
                getMvpView().setResult(totalIncome, totalOutcome);
            }
        });
    }

    @Override
    public List<Income> getIncomes(){
        return getDataManager().getIncomes();
    }
}
