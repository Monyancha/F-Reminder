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
import com.example.arifluthfiansyah.f_reminder.controller.IncomeController;
import com.example.arifluthfiansyah.f_reminder.controller.OutcomeController;
import com.example.arifluthfiansyah.f_reminder.model.Income;
import com.example.arifluthfiansyah.f_reminder.model.Outcome;
import com.example.arifluthfiansyah.f_reminder.ui.base.BaseFragment;
import com.example.arifluthfiansyah.f_reminder.ui.income.dialog.IncomeDialogFragment;

import javax.annotation.ParametersAreNonnullByDefault;

import io.realm.Realm;
import io.realm.RealmChangeListener;

/**
 * Created by Arif Luthfiansyah on 11-Dec-17.
 */

public class IncomeFragment extends BaseFragment implements IncomeAdapter.IncomeAdapterListener,
        IncomeDialogFragment.IncomeDialogListener, View.OnClickListener, IncomeMvpView {

    private Context mContext;

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
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncomeRecyclerView.setLayoutManager(layoutManager);
        mIncomeRecyclerView.setHasFixedSize(true);
        mIncomeAdapter = new IncomeAdapter(this);
        mIncomeRecyclerView.setAdapter(mIncomeAdapter);
        mIncomeAdapter.addIncomes(IncomeController.with(this).getIncomes());
    }

    @Override
    public void onIncomeItemClick(Income outcome) {
        IncomeDialogFragment dialogFragment = IncomeDialogFragment.newInstance(this, outcome);
        dialogFragment.show(getFragmentManager(), "IncomeDialogFragment");
    }

    @Override
    public void onSaveButtonClick() {
        IncomeController.with(this).getRealm().addChangeListener(new RealmChangeListener<Realm>() {
            @ParametersAreNonnullByDefault
            @Override
            public void onChange(Realm realm) {
                mIncomeAdapter.updateIncomes(IncomeController.with(IncomeFragment.this).getIncomes());
                int totalIncome = 0, totalOutcome = 0;
                for (Outcome o : OutcomeController.with(IncomeFragment.this).getOutcomes()) {
                    totalOutcome += o.getPrice();
                }
                for (Income i : IncomeController.with(IncomeFragment.this).getIncomes()) {
                    totalIncome += i.getPrice();
                }
                if ((totalIncome - totalOutcome) < 0) {
                    setNotification(mContext, "Warning!", "Save your money for your future!");
                } else {
                    setNotification(mContext,"Great!", "Save!");
                }
                mTotalIncomeTextView.setText(String.valueOf(totalIncome));
                mTotalResultTextView.setText(String.valueOf(totalIncome - totalOutcome));
            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.fab:
                IncomeDialogFragment dialogFragment = IncomeDialogFragment.newInstance(this, null);
                dialogFragment.show(getFragmentManager(), "OutcomeDialogFragment");
                break;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }
}
