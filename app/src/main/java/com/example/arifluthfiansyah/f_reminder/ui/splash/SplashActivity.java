package com.example.arifluthfiansyah.f_reminder.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.example.arifluthfiansyah.f_reminder.R;
import com.example.arifluthfiansyah.f_reminder.ui.base.BaseActivity;
import com.example.arifluthfiansyah.f_reminder.ui.main.MainActivity;

import javax.inject.Inject;

/**
 * Created by Arif Luthfiansyah on 11-Dec-17.
 */

public class SplashActivity extends BaseActivity implements SplashMvpView{

    @Inject
    SplashMvpPresenter<SplashMvpView> mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
    }

    public void openMainActivity(){
        Intent intent = MainActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }
}
