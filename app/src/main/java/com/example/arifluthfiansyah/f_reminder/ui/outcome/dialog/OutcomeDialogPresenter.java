package com.example.arifluthfiansyah.f_reminder.ui.outcome.dialog;

import com.example.arifluthfiansyah.f_reminder.data.DataManager;
import com.example.arifluthfiansyah.f_reminder.data.db.model.Outcome;
import com.example.arifluthfiansyah.f_reminder.ui.base.BasePresenter;

import javax.inject.Inject;

public class OutcomeDialogPresenter<V extends OutcomeDialogMvpView> extends BasePresenter<V> implements OutcomeDialogMvpPresenter<V> {

    @Inject
    public OutcomeDialogPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void updateOutcome(Outcome outcome) {
        getDataManager().updateOutcome(outcome);
    }

    @Override
    public void addOutcome(Outcome outcome) {
        getDataManager().addOutcome(outcome);
    }
}
