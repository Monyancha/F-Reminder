package com.example.arifluthfiansyah.f_reminder.ui.outcome;

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
import com.example.arifluthfiansyah.f_reminder.data.db.model.Outcome;
import com.example.arifluthfiansyah.f_reminder.ui.base.BaseFragment;
import com.example.arifluthfiansyah.f_reminder.ui.outcome.dialog.OutcomeDialog;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Arif Luthfiansyah on 11-Dec-17.
 */

public class OutcomeFragment extends BaseFragment implements OutcomeAdapter.OutcomeAdapterListener,
        OutcomeDialog.OutcomeDialogListener, View.OnClickListener, OutcomeMvpView {

    @Inject
    OutcomeMvpPresenter<OutcomeMvpView> mPresenter;

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
        mPresenter.onAttach(this);
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mOutcomeRecyclerView.setLayoutManager(layoutManager);
        mOutcomeRecyclerView.setHasFixedSize(true);
        mOutcomeAdapter = new OutcomeAdapter(this);
        mOutcomeRecyclerView.setAdapter(mOutcomeAdapter);
        mOutcomeAdapter.addOutcomes(mPresenter.getOutcomes());
    }

    @Override
    public void onOutcomeItemClick(Outcome outcome) {
        OutcomeDialog dialogFragment = OutcomeDialog.newInstance(this, outcome);
        dialogFragment.show(getFragmentManager(), "OutcomeDialogFragment");
    }

    @Override
    public void onSaveButtonClick() {
        mPresenter.setResult();
    }

    @Override
    public void setResult(int totalOutcome, int totalIncome){
        mTotalOutcomeTextView.setText(String.valueOf(totalOutcome));
        mTotalResultTextView.setText(String.valueOf(totalIncome - totalOutcome));
    }

    @Override
    public void updateOutcomes(List<Outcome> outcomes){
        mOutcomeAdapter.updateOutcomes(outcomes);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.fab:
                OutcomeDialog dialogFragment = OutcomeDialog.newInstance(this, null);
                dialogFragment.show(getFragmentManager(), "OutcomeDialogFragment");
                break;
        }
    }

}
