package com.example.arifluthfiansyah.f_reminder.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.example.arifluthfiansyah.f_reminder.R;
import com.example.arifluthfiansyah.f_reminder.controller.IncomeController;
import com.example.arifluthfiansyah.f_reminder.controller.OutcomeController;
import com.example.arifluthfiansyah.f_reminder.data.prefs.AppPreferencesHelper;
import com.example.arifluthfiansyah.f_reminder.model.Income;
import com.example.arifluthfiansyah.f_reminder.model.Outcome;
import com.example.arifluthfiansyah.f_reminder.ui.base.BaseActivity;
import com.example.arifluthfiansyah.f_reminder.ui.main.MainActivity;

/**
 * Created by Arif Luthfiansyah on 11-Dec-17.
 */

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setupPrefixData();
        setupHandler();
    }

    private void setupHandler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = MainActivity.getStartIntent(SplashActivity.this);
                startActivity(intent);
                finish();
            }
        }, 800);
    }
    public void openMainActivity(){
        Intent intent = MainActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }
    private void setupPrefixData() {
        if (AppPreferencesHelper.with(this).getIsFirstTime()) {
            OutcomeController.with(this).deleteOutcomes();
            OutcomeController.with(this).addOutcome(new Outcome(System.currentTimeMillis(), "Beli buah 1", "Buah mangga", 10000, getCurrentOfDate()));
            OutcomeController.with(this).addOutcome(new Outcome(System.currentTimeMillis(), "Beli buah 2", "Buah mangga", 10000, getCurrentOfDate()));
            OutcomeController.with(this).addOutcome(new Outcome(System.currentTimeMillis(), "Beli buah 3", "Buah mangga", 10000, getCurrentOfDate()));
            OutcomeController.with(this).addOutcome(new Outcome(System.currentTimeMillis(), "Beli buah 4", "Buah mangga", 10000, getCurrentOfDate()));
            OutcomeController.with(this).addOutcome(new Outcome(System.currentTimeMillis(), "Beli buah 5", "Buah mangga", 10000, getCurrentOfDate()));
            IncomeController.with(this).deleteIncomes();
            IncomeController.with(this).addIncome(new Income(System.currentTimeMillis(), "Pendapatan 1", 10000, getCurrentOfDate()));
            IncomeController.with(this).addIncome(new Income(System.currentTimeMillis(), "Pendapatan 1", 10000, getCurrentOfDate()));
            IncomeController.with(this).addIncome(new Income(System.currentTimeMillis(), "Pendapatan 1", 10000, getCurrentOfDate()));
            IncomeController.with(this).addIncome(new Income(System.currentTimeMillis(), "Pendapatan 1", 10000, getCurrentOfDate()));
            IncomeController.with(this).addIncome(new Income(System.currentTimeMillis(), "Pendapatan 1", 10000, getCurrentOfDate()));
            AppPreferencesHelper.with(this).setIsFirstTime(false);
        }
    }
}
