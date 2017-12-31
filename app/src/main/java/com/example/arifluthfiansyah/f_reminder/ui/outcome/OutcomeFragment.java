package com.example.arifluthfiansyah.f_reminder.ui.outcome;

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

import javax.annotation.ParametersAreNonnullByDefault;

import io.realm.Realm;
import io.realm.RealmChangeListener;

/**
 * Created by Arif Luthfiansyah on 11-Dec-17.
 */

public class OutcomeFragment extends BaseFragment implements OutcomeAdapter.OutcomeAdapterListener,
        OutcomeDialogFragment.OutcomeDialogListener, View.OnClickListener {

    private Context mContext;

    private FloatingActionButton mFab;
    private TextView mTotalOutcomeTextView;
    private TextView mTotalResultTextView;
    private RecyclerView mOutcomeRecyclerView;

    private OutcomeAdapter mOutcomeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_outcome, container, false);
        bindingView(view);
        setupListener();
        setupRecyclerView();
        return view;
    }

    private void bindingView(View view) {
        mFab = getActivity().findViewById(R.id.fab);
        mTotalOutcomeTextView = getActivity().findViewById(R.id.tv_total_outcome);
        mTotalResultTextView = getActivity().findViewById(R.id.tv_total_result);
        mOutcomeRecyclerView = view.findViewById(R.id.content_outcome);
    }

    private void setupListener() {
        mFab.setOnClickListener(this);
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mOutcomeRecyclerView.setLayoutManager(layoutManager);
        mOutcomeRecyclerView.setHasFixedSize(true);
        mOutcomeAdapter = new OutcomeAdapter(this);
        mOutcomeRecyclerView.setAdapter(mOutcomeAdapter);
        mOutcomeAdapter.addOutcomes(OutcomeController.with(this).getOutcomes());
    }

    @Override
    public void onOutcomeItemClick(Outcome outcome) {
        OutcomeDialogFragment dialogFragment = OutcomeDialogFragment.newInstance(this, outcome);
        dialogFragment.show(getFragmentManager(), "OutcomeDialogFragment");
    }

    @Override
    public void onSaveButtonClick() {
        OutcomeController.with(this).getRealm().addChangeListener(new RealmChangeListener<Realm>() {
            @ParametersAreNonnullByDefault
            @Override
            public void onChange(Realm realm) {
                mOutcomeAdapter.updateOutcomes(OutcomeController.with(OutcomeFragment.this).getOutcomes());
                int totalIncome = 0, totalOutcome = 0;
                for (Outcome o : OutcomeController.with(OutcomeFragment.this).getOutcomes()) {
                    totalOutcome += o.getPrice();
                }
                for (Income i : IncomeController.with(OutcomeFragment.this).getIncomes()) {
                    totalIncome += i.getPrice();
                }
                if ((totalIncome - totalOutcome) < 0) {
                    setNotification(mContext, "Warning!", "Save your money for your future!");
                } else {
                    setNotification(mContext,"Great!", "Save!");
                }
                mTotalOutcomeTextView.setText(String.valueOf(totalOutcome));
                mTotalResultTextView.setText(String.valueOf(totalIncome - totalOutcome));

            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.fab:
                OutcomeDialogFragment dialogFragment = OutcomeDialogFragment.newInstance(this, null);
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
