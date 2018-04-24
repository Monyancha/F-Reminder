package com.example.arifluthfiansyah.f_reminder.ui.income;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arifluthfiansyah.f_reminder.R;
import com.example.arifluthfiansyah.f_reminder.data.db.model.Income;
import com.example.arifluthfiansyah.f_reminder.di.component.ActivityComponent;
import com.example.arifluthfiansyah.f_reminder.ui.base.BaseFragment;
import com.example.arifluthfiansyah.f_reminder.ui.income.dialog.IncomeDialog;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmChangeListener;

/**
 * Created by Arif Luthfiansyah on 11-Dec-17.
 */

public class IncomeFragment extends BaseFragment implements IncomeAdapter.IncomeAdapterListener,
        IncomeDialog.IncomeDialogListener, View.OnClickListener, IncomeMvpView {

    @Inject
    IncomeMvpPresenter<IncomeMvpView> mPresenter;

    private FloatingActionButton mFab;
    private TextView mTotalIncomeTextView;
    private TextView mTotalResultTextView;
    private RecyclerView mIncomeRecyclerView;

    private IncomeAdapter mIncomeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_income, container, false);
        bindingView(view);
        setupListener();
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
        }
        setupRecyclerView();
        return view;
    }

    private void bindingView(View view) {
        mFab = getActivity().findViewById(R.id.fab);
        mTotalIncomeTextView = getActivity().findViewById(R.id.tv_total_income);
        mTotalResultTextView = getActivity().findViewById(R.id.tv_total_result);
        mIncomeRecyclerView = view.findViewById(R.id.content_income);
    }

    private void setupListener() {
        mFab.setOnClickListener(this);
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncomeRecyclerView.setLayoutManager(layoutManager);
        mIncomeRecyclerView.setHasFixedSize(true);
        mIncomeAdapter = new IncomeAdapter(this);
        mIncomeRecyclerView.setAdapter(mIncomeAdapter);
        mIncomeAdapter.addIncomes(mPresenter.getIncomes());
    }

    @Override
    public void onIncomeItemClick(Income outcome) {
        IncomeDialog dialogFragment = IncomeDialog.newInstance(this, outcome);
        dialogFragment.show(getFragmentManager(), "IncomeDialogFragment");
    }

    @Override
    public void onSaveButtonClick() {
        mPresenter.setResult();
    }

    @Override
    public void setResult(int totalOutcome, int totalIncome) {
        mTotalIncomeTextView.setText(String.valueOf(totalIncome));
        mTotalResultTextView.setText(String.valueOf(totalIncome - totalOutcome));
    }

    @Override
    public void updateIncomes(List<Income> incomes){
        mIncomeAdapter.updateIncomes(incomes);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.fab:
                IncomeDialog dialogFragment = IncomeDialog.newInstance(this, null);
                dialogFragment.show(getFragmentManager(), "OutcomeDialogFragment");
                break;
        }
    }

}
