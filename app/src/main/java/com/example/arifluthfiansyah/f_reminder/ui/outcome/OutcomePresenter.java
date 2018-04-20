package com.example.arifluthfiansyah.f_reminder.ui.outcome;

import com.example.arifluthfiansyah.f_reminder.data.DataManager;
import com.example.arifluthfiansyah.f_reminder.data.db.model.Income;
import com.example.arifluthfiansyah.f_reminder.data.db.model.Outcome;
import com.example.arifluthfiansyah.f_reminder.ui.base.BasePresenter;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmChangeListener;

public class OutcomePresenter<V extends OutcomeMvpView> extends BasePresenter<V> implements OutcomeMvpPresenter<V>{

    @Inject
    public OutcomePresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void setResult(){
        getDataManager().getRealm().addChangeListener(new RealmChangeListener<Realm>() {
            @ParametersAreNonnullByDefault
            @Override
            public void onChange(Realm realm) {
                getMvpView().updateOutcomes(getDataManager().getOutcomes());
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
                getMvpView().setResult(totalOutcome, totalIncome);
            }
        });
    }

    @Override
    public List<Outcome> getOutcomes(){
        return getDataManager().getOutcomes();
    }
}
