package com.example.arifluthfiansyah.f_reminder.ui.outcome.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.arifluthfiansyah.f_reminder.R;
import com.example.arifluthfiansyah.f_reminder.data.db.model.Outcome;
import com.example.arifluthfiansyah.f_reminder.ui.base.BaseDialog;

import javax.inject.Inject;

/**
 * Created by Arif Luthfiansyah on 11-Dec-17.
 */

public class OutcomeDialog extends BaseDialog implements View.OnClickListener, OutcomeDialogMvpView{

    @Override
    public void setNotification(String title, String content) {

    }

    @Inject
    OutcomeDialogMvpPresenter<OutcomeDialogMvpView> mPresenter;

    private static OutcomeDialogListener mListener;

    private EditText mTitleOutcomeEditText;
    private EditText mContentOutcomeEditText;
    private EditText mPriceOutcomeEditText;
    private Button mSaveOutcomeButton;

    public static OutcomeDialog newInstance(OutcomeDialogListener listener, Outcome outcome) {
        OutcomeDialog dialogFragment = new OutcomeDialog();
        mListener = listener;
        Bundle bundle = new Bundle();
        bundle.putSerializable("keyOutcome", outcome);
        dialogFragment.setArguments(bundle);
        return dialogFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.ThemeDialogFragment);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_outcome, container, false);
        bindingView(view);
        setupListener();
        setupPrefixData();
        mPresenter.onAttach(this);
        return view;
    }

    private void bindingView(View view) {
        mTitleOutcomeEditText = view.findViewById(R.id.et_title_outcome);
        mContentOutcomeEditText = view.findViewById(R.id.et_content_outcome);
        mPriceOutcomeEditText = view.findViewById(R.id.et_price_outcome);
        mSaveOutcomeButton = view.findViewById(R.id.btn_save_outcome);
    }

    private void setupListener() {
        mSaveOutcomeButton.setOnClickListener(this);
    }

    private Outcome getArgsOutcome() {
        Outcome outcome = (Outcome) getArguments().getSerializable("keyOutcome");
        if (outcome != null) {
            return outcome;
        }
        return null;
    }

    private void setupPrefixData() {
        if (getArgsOutcome() != null) {
            mTitleOutcomeEditText.setText(getArgsOutcome().getTitle());
            mContentOutcomeEditText.setText(getArgsOutcome().getContent());
            mPriceOutcomeEditText.setText(String.valueOf(getArgsOutcome().getPrice()));
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_save_outcome:
                if (getArgsOutcome() != null) {
                    String title = mTitleOutcomeEditText.getText().toString();
                    String content = mContentOutcomeEditText.getText().toString();
                    int price = Integer.parseInt(mPriceOutcomeEditText.getText().toString());
                    Outcome outcome = new Outcome(getArgsOutcome().getId(), title, content, price, getArgsOutcome().getDate());
                    mPresenter.updateOutcome(outcome);

                } else {
                    String title = mTitleOutcomeEditText.getText().toString();
                    String content = mContentOutcomeEditText.getText().toString();
                    int price = Integer.parseInt(mPriceOutcomeEditText.getText().toString());
                    Outcome outcome = new Outcome(System.currentTimeMillis(), title, content, price, getCurrentOfDate());
                    mPresenter.addOutcome(outcome);
                }
                mListener.onSaveButtonClick();
                dismiss();
                break;
        }
    }

    public interface OutcomeDialogListener {
        void onSaveButtonClick();
    }
}
