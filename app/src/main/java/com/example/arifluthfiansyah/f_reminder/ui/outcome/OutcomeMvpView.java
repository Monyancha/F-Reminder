package com.example.arifluthfiansyah.f_reminder.ui.outcome;

import com.example.arifluthfiansyah.f_reminder.data.db.model.Outcome;
import com.example.arifluthfiansyah.f_reminder.ui.base.MvpView;

import java.util.List;

public interface OutcomeMvpView extends MvpView {
    void setResult(int totalOutcome, int totalIncome);
    void updateOutcomes(List<Outcome> outcomes);
}
