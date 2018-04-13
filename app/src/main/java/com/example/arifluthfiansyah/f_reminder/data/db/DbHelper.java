package com.example.arifluthfiansyah.f_reminder.data.db;

import com.example.arifluthfiansyah.f_reminder.data.db.model.Income;
import com.example.arifluthfiansyah.f_reminder.data.db.model.Outcome;

import java.util.List;

public interface DbHelper {
    void addIncome(Income income);
    void updateIncome(Income income);
    Income getIncomeById(long id);
    Income getIncomeByLast();
    List<Income> getIncomes();
    void deleteIncomeById(long id);
    void deleteIncomes();

    void addOutcome(Outcome outcome);
    void updateOutcome(Outcome outcome);
    Outcome getOutcomeById(long id);
    Outcome getOutcomeByLast();
    List<Outcome> getOutcomes();
    void deleteOutcomeById(long id);
    void deleteOutcomes();
}
