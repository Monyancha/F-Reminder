package com.example.arifluthfiansyah.f_reminder.ui.outcome;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arifluthfiansyah.f_reminder.R;
import com.example.arifluthfiansyah.f_reminder.model.Outcome;
import com.example.arifluthfiansyah.f_reminder.util.FormatCurrencyUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arif Luthfiansyah on 11-Dec-17.
 */

public class OutcomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static OutcomeAdapterListener mListener;
    private static List<Outcome> mOutcomes = new ArrayList<>();

    public OutcomeAdapter(OutcomeAdapterListener listener) {
        mListener = listener;
    }

    public void addOutcomes(List<Outcome> outcomes) {
        mOutcomes.addAll(outcomes);
        notifyDataSetChanged();
    }

    public void updateOutcomes(List<Outcome> outcomes) {
        mOutcomes.clear();
        mOutcomes.addAll(outcomes);
        notifyDataSetChanged();
    }

    public void clearOutcomes() {
        mOutcomes.clear();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return OutcomeViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String title = mOutcomes.get(position).getTitle();
        String content = mOutcomes.get(position).getContent();
        String price = FormatCurrencyUtil.currencyID().format(mOutcomes.get(position).getPrice());
        String date = mOutcomes.get(position).getDate();
        ((OutcomeViewHolder) holder).mTitleOutcomeTextView.setText(title);
        ((OutcomeViewHolder) holder).mContentOutcomeTextView.setText(content);
        ((OutcomeViewHolder) holder).mPriceOutcomeTextView.setText(price);
        ((OutcomeViewHolder) holder).mDateOutcomeTextView.setText(date);
    }

    @Override
    public int getItemCount() {
        return mOutcomes.size();
    }

    public interface OutcomeAdapterListener {
        void onOutcomeItemClick(Outcome outcome);
    }

    private static class OutcomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mTitleOutcomeTextView;
        private TextView mContentOutcomeTextView;
        private TextView mPriceOutcomeTextView;
        private TextView mDateOutcomeTextView;

        private OutcomeViewHolder(View itemView) {
            super(itemView);
            bindingView(itemView);
            itemView.setOnClickListener(this);
        }

        private void bindingView(View view) {
            mTitleOutcomeTextView = view.findViewById(R.id.tv_title_outcome);
            mContentOutcomeTextView = view.findViewById(R.id.tv_content_outcome);
            mPriceOutcomeTextView = view.findViewById(R.id.tv_price_outcome);
            mDateOutcomeTextView = view.findViewById(R.id.tv_date_outcome);
        }

        private static OutcomeViewHolder create(ViewGroup parent){
            return new OutcomeViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content_outcome, parent, false));
        }

        @Override
        public void onClick(View view) {
            mListener.onOutcomeItemClick(mOutcomes.get(getAdapterPosition()));
        }
    }
}
