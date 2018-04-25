package com.example.arifluthfiansyah.f_reminder.ui.outcome;

import com.example.arifluthfiansyah.f_reminder.data.db.model.Outcome;
import com.example.arifluthfiansyah.f_reminder.ui.base.MvpPresenter;

import java.util.List;

public interface OutcomeMvpPresenter<V extends OutcomeMvpView> extends MvpPresenter<V> {
    void setResult();
    List<Outcome> getOutcomes();
}
