package com.example.arifluthfiansyah.f_reminder.data;

import com.example.arifluthfiansyah.f_reminder.data.db.model.Income;
import com.example.arifluthfiansyah.f_reminder.data.db.model.Outcome;

import java.util.List;

import io.realm.Realm;

public interface DataManager {
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
	void setIsFirstTime(boolean firsttime);
	boolean getIsFirstTime();
	void clearAll();
	Realm getRealm();
}
