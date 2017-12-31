package com.example.arifluthfiansyah.f_reminder.ui.income;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arifluthfiansyah.f_reminder.R;
import com.example.arifluthfiansyah.f_reminder.model.Income;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arif Luthfiansyah on 12-Dec-17.
 */

public class IncomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static IncomeAdapterListener mListener;
    private static List<Income> mIncomes = new ArrayList<>();

    public IncomeAdapter(IncomeAdapterListener listener) {
        mListener = listener;
    }

    public void addIncomes(List<Income> incomes) {
        mIncomes.addAll(incomes);
        notifyDataSetChanged();
    }

    public void updateIncomes(List<Income> incomes) {
        mIncomes.clear();
        mIncomes.addAll(incomes);
        notifyDataSetChanged();
    }

    public void clearIncomes() {
        mIncomes.clear();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return IncomeViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String title = mIncomes.get(position).getTitle();
        String price = String.valueOf(mIncomes.get(position).getPrice());
        String date = mIncomes.get(position).getDate();
        ((IncomeViewHolder) holder).mTitleIncomeTextView.setText(title);
        ((IncomeViewHolder) holder).mPriceIncomeTextView.setText(price);
        ((IncomeViewHolder) holder).mDateIncomeTextView.setText(date);
    }

    @Override
    public int getItemCount() {
        return mIncomes.size();
    }

    public interface IncomeAdapterListener {
        void onIncomeItemClick(Income income);
    }

    private static class IncomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mTitleIncomeTextView;
        private TextView mPriceIncomeTextView;
        private TextView mDateIncomeTextView;

        private IncomeViewHolder(View itemView) {
            super(itemView);
            bindingView(itemView);
            itemView.setOnClickListener(this);
        }

        private void bindingView(View view) {
            mTitleIncomeTextView = view.findViewById(R.id.tv_title_income);
            mPriceIncomeTextView = view.findViewById(R.id.tv_price_income);
            mDateIncomeTextView = view.findViewById(R.id.tv_date_income);
        }

        private static IncomeViewHolder create(ViewGroup parent) {
            return new IncomeViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content_income, parent, false));
        }

        @Override
        public void onClick(View view) {
            mListener.onIncomeItemClick(mIncomes.get(getAdapterPosition()));
        }
    }
}
