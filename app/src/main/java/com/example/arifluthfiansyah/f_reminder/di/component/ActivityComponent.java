package com.example.arifluthfiansyah.f_reminder.di.component;

import com.example.arifluthfiansyah.f_reminder.di.PerActivity;
import com.example.arifluthfiansyah.f_reminder.di.module.ActivityModule;
import com.example.arifluthfiansyah.f_reminder.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(SplashActivity splashActivity);
}
