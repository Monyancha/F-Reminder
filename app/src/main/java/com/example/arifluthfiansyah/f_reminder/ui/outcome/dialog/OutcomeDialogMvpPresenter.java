package com.example.arifluthfiansyah.f_reminder.ui.outcome.dialog;

import com.example.arifluthfiansyah.f_reminder.data.db.model.Outcome;
import com.example.arifluthfiansyah.f_reminder.ui.base.MvpPresenter;

public interface OutcomeDialogMvpPresenter<V extends OutcomeDialogMvpView> extends MvpPresenter<V> {
    void updateOutcome(Outcome outcome);
    void addOutcome(Outcome outcome);
}
