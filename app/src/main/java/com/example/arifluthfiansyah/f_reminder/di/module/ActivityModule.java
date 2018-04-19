package com.example.arifluthfiansyah.f_reminder.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.arifluthfiansyah.f_reminder.FReminderApp;
import com.example.arifluthfiansyah.f_reminder.data.DataManager;
import com.example.arifluthfiansyah.f_reminder.di.ActivityContext;
import com.example.arifluthfiansyah.f_reminder.di.PerActivity;
import com.example.arifluthfiansyah.f_reminder.ui.main.MainMvpPresenter;
import com.example.arifluthfiansyah.f_reminder.ui.main.MainMvpView;
import com.example.arifluthfiansyah.f_reminder.ui.main.MainPresenter;
import com.example.arifluthfiansyah.f_reminder.ui.outcome.OutcomeMvpPresenter;
import com.example.arifluthfiansyah.f_reminder.ui.outcome.OutcomeMvpView;
import com.example.arifluthfiansyah.f_reminder.ui.outcome.OutcomePresenter;
import com.example.arifluthfiansyah.f_reminder.ui.outcome.dialog.OutcomeDialogMvpPresenter;
import com.example.arifluthfiansyah.f_reminder.ui.outcome.dialog.OutcomeDialogMvpView;
import com.example.arifluthfiansyah.f_reminder.ui.outcome.dialog.OutcomeDialogPresenter;
import com.example.arifluthfiansyah.f_reminder.ui.splash.SplashMvpPresenter;
import com.example.arifluthfiansyah.f_reminder.ui.splash.SplashMvpView;
import com.example.arifluthfiansyah.f_reminder.ui.splash.SplashPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){return mActivity;}

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    OutcomeMvpPresenter<OutcomeMvpView> provideOutcomePresenter(
            OutcomePresenter<OutcomeMvpView> presenter){
        return presenter;
    }

    @Provides
    @PerActivity
    OutcomeDialogMvpPresenter<OutcomeDialogMvpView> provideOutcomeDialogPresenter(
            OutcomeDialogPresenter<OutcomeDialogMvpView> presenter){
        return presenter;
    }
}
