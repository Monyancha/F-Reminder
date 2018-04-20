package com.example.arifluthfiansyah.f_reminder.di.component;

import com.example.arifluthfiansyah.f_reminder.di.PerActivity;
import com.example.arifluthfiansyah.f_reminder.di.module.ActivityModule;
import com.example.arifluthfiansyah.f_reminder.ui.income.dialog.IncomeDialog;
import com.example.arifluthfiansyah.f_reminder.ui.main.MainActivity;
import com.example.arifluthfiansyah.f_reminder.ui.outcome.OutcomeFragment;
import com.example.arifluthfiansyah.f_reminder.ui.outcome.dialog.OutcomeDialog;
import com.example.arifluthfiansyah.f_reminder.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(SplashActivity activity);
    void inject(MainActivity activity);
    void inject(OutcomeFragment fragment);
    void inject(OutcomeDialog dialog);
    void inject(IncomeDialog dialog);
}
