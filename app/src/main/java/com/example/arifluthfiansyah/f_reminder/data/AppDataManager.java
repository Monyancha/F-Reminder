package com.example.arifluthfiansyah.f_reminder.data;

import android.content.Context;

import com.example.arifluthfiansyah.f_reminder.data.db.DbHelper;
import com.example.arifluthfiansyah.f_reminder.data.db.model.Income;
import com.example.arifluthfiansyah.f_reminder.data.db.model.Outcome;
import com.example.arifluthfiansyah.f_reminder.data.prefs.PreferencesHelper;
import com.example.arifluthfiansyah.f_reminder.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.realm.Realm;

@Singleton
public class AppDataManager implements DataManager {
    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, DbHelper dbHelper, PreferencesHelper preferencesHelper) {
        this.mContext = context;
        this.mDbHelper = dbHelper;
        this.mPreferencesHelper = preferencesHelper;
    }

    @Override
    public void addIncome(Income income) {
        mDbHelper.addIncome(income);
    }

    @Override
    public void updateIncome(Income income) {
        mDbHelper.updateIncome(income);
    }

    @Override
    public Income getIncomeById(long id) {
        return mDbHelper.getIncomeById(id);
    }

    @Override
    public Income getIncomeByLast() {
        return mDbHelper.getIncomeByLast();
    }

    @Override
    public List<Income> getIncomes() {
        return mDbHelper.getIncomes();
    }

    @Override
    public void deleteIncomeById(long id) {
        mDbHelper.deleteIncomeById(id);
    }

    @Override
    public void deleteIncomes() {
        mDbHelper.deleteIncomes();
    }

    @Override
    public void addOutcome(Outcome outcome) {
        mDbHelper.addOutcome(outcome);
    }

    @Override
    public void updateOutcome(Outcome outcome) {
        mDbHelper.updateOutcome(outcome);
    }

    @Override
    public Outcome getOutcomeById(long id) {
        return mDbHelper.getOutcomeById(id);
    }

    @Override
    public Outcome getOutcomeByLast() {
        return mDbHelper.getOutcomeByLast();
    }

    @Override
    public List<Outcome> getOutcomes() {
        return mDbHelper.getOutcomes();
    }

    @Override
    public void deleteOutcomeById(long id) {
        mDbHelper.deleteOutcomeById(id);
    }

    @Override
    public void deleteOutcomes() {
        mDbHelper.deleteOutcomes();
    }

    @Override
    public void setIsFirstTime(boolean firsttime) {
        mPreferencesHelper.setIsFirstTime(firsttime);
    }

    @Override
    public boolean getIsFirstTime() {
        return mPreferencesHelper.getIsFirstTime();
    }

    @Override
    public void clearAll() {
        mPreferencesHelper.clearAll();
    }

    @Override
    public Realm getRealm() { return mDbHelper.getRealm(); }
}
