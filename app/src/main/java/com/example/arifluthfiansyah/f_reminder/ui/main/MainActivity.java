package com.example.arifluthfiansyah.f_reminder.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.arifluthfiansyah.f_reminder.R;
import com.example.arifluthfiansyah.f_reminder.controller.IncomeController;
import com.example.arifluthfiansyah.f_reminder.controller.OutcomeController;
import com.example.arifluthfiansyah.f_reminder.model.Income;
import com.example.arifluthfiansyah.f_reminder.model.Outcome;
import com.example.arifluthfiansyah.f_reminder.ui.base.BaseActivity;
import com.example.arifluthfiansyah.f_reminder.ui.income.IncomeFragment;
import com.example.arifluthfiansyah.f_reminder.ui.outcome.OutcomeFragment;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, MainMvpView {

    @Inject
    private MainMvpPresenter<MainMvpView> mPresenter;

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    private TextView mTotalIncomeTextView;
    private TextView mTotalOutcomeTextView;
    private TextView mTotalResultTextView;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
        bindingView();
        setupToolbar();
        setupListener();
        setupDrawerLayout();
        setupPrefixContent();

    }

    private void bindingView() {
        mToolbar = findViewById(R.id.toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.nav_view);
        mTotalIncomeTextView = findViewById(R.id.tv_total_income);
        mTotalOutcomeTextView = findViewById(R.id.tv_total_outcome);
        mTotalResultTextView = findViewById(R.id.tv_total_result);
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
    }

    private void setupListener() {
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    private void setupDrawerLayout() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.prompt_open_drawer, R.string.prompt_close_drawer);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void setupPrefixContent() {
        MenuItem menuItem = mNavigationView.getMenu().getItem(0);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new OutcomeFragment()).commit();
        menuItem.setChecked(true);
    }

    @Override
    public void setStartText(int income, int outcome, int total){
        mTotalIncomeTextView.setText(String.valueOf(income));
        mTotalOutcomeTextView.setText(String.valueOf(outcome));
        mTotalResultTextView.setText(String.valueOf(total));
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            showToastMessage("Under construction");
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_outcome:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new OutcomeFragment()).commit();
                break;
            case R.id.nav_income:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new IncomeFragment()).commit();
                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
