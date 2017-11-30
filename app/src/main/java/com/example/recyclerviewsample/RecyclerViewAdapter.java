package com.example.recyclerviewsample;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.recyclerviewsample.databinding.RecyclerViewCellBinding;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private final LayoutInflater mInflater;
    private List<String> mData;

    RecyclerViewAdapter(Context context, List<String> data) {
        mInflater = LayoutInflater.from(context);
        mData = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // DataBinding -------------

        RecyclerViewCellBinding dataBinding = DataBindingUtil.inflate(mInflater, R.layout.recycler_view_cell, parent, false);

        return new RecyclerViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        final String data = mData.get(position);
        Items item = new Items(data);
        item.itemFilePath.set("Path " + data);

        holder.getDataBinding().setItem(item);
        holder.getDataBinding().setPresenter(new Presenter());

        holder.getDataBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {

        int itemCount = 0;

        if (mData != null) {
            itemCount = mData.size();
        }

        return itemCount;
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerViewCellBinding dataBinding;

        RecyclerViewHolder(RecyclerViewCellBinding dataBinding) {
            super(dataBinding.getRoot());
            this.dataBinding = dataBinding;
        }

        RecyclerViewCellBinding getDataBinding() {
            return dataBinding;
        }

    }
}
