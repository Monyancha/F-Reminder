package com.example.arifluthfiansyah.f_reminder.ui.income.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.arifluthfiansyah.f_reminder.R;
import com.example.arifluthfiansyah.f_reminder.data.db.model.Income;
import com.example.arifluthfiansyah.f_reminder.di.component.ActivityComponent;
import com.example.arifluthfiansyah.f_reminder.ui.base.BaseDialog;

import javax.inject.Inject;

/**
 * Created by Arif Luthfiansyah on 12-Dec-17.
 */

public class IncomeDialog extends BaseDialog implements View.OnClickListener, IncomeDialogMvpView {

    private static IncomeDialogListener mListener;

    @Inject
    IncomeDialogMvpPresenter<IncomeDialogMvpView> mPresenter;

    private EditText mTitleIncomeEditText;
    private EditText mPriceIncomeEditText;
    private Button mSaveIncomeButton;

    public static IncomeDialog newInstance(IncomeDialogListener listener, Income income) {
        IncomeDialog dialogFragment = new IncomeDialog();
        mListener = listener;
        Bundle bundle = new Bundle();
        bundle.putSerializable("keyIncome", income);
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
        View view = inflater.inflate(R.layout.dialog_fragment_income, container, false);
        bindingView(view);
        setupListener();
        ActivityComponent component = getActivityComponent();
        if (component != null) {

            component.inject(this);

            mPresenter.onAttach(this);
        }

        setupPrefixData();
        return view;
    }

    private void bindingView(View view) {
        mTitleIncomeEditText = view.findViewById(R.id.et_title_income);
        mPriceIncomeEditText = view.findViewById(R.id.et_price_income);
        mSaveIncomeButton = view.findViewById(R.id.btn_save_income);
    }

    private void setupListener() {
        mSaveIncomeButton.setOnClickListener(this);
    }

    private Income getArgsIncome() {
        Income income = (Income) getArguments().getSerializable("keyIncome");
        if (income != null) {
            return income;
        }
        return null;
    }

    private void setupPrefixData() {
        if (getArgsIncome() != null) {
            mTitleIncomeEditText.setText(getArgsIncome().getTitle());
            mPriceIncomeEditText.setText(String.valueOf(getArgsIncome().getPrice()));
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_save_income:
                if (getArgsIncome() != null) {
                    String title = mTitleIncomeEditText.getText().toString();
                    int price = Integer.parseInt(mPriceIncomeEditText.getText().toString());
                    Income income = new Income(getArgsIncome().getId(), title, price, getArgsIncome().getDate());
                    mPresenter.updateIncome(income);
                } else {
                    String title = mTitleIncomeEditText.getText().toString();
                    int price = Integer.parseInt(mPriceIncomeEditText.getText().toString());
                    Income income = new Income(System.currentTimeMillis(), title, price, getCurrentOfDate());
                    mPresenter.addIncome(income);
                }
                mListener.onSaveButtonClick();
                dismiss();
                break;
        }
    }

    public interface IncomeDialogListener {
        void onSaveButtonClick();
    }
}
