package com.example.recyclerviewsample;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.recyclerviewsample.databinding.RecyclerViewCellBinding;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private final LayoutInflater mInflater;
    private List<Items> mData;

    RecyclerViewAdapter(Context context, List<Items> data) {
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

        final Items item = mData.get(position);

        holder.getDataBinding().setItem(item);
        holder.getDataBinding().setPresenter(new Presenter());

        // TODO
        try {
            InputStream inputStream = holder.getDataBinding().getRoot().getResources().getAssets().open(item.itemFilePath.get());
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            holder.getImageButton().setImageBitmap(bitmap);
        } catch (IOException e) {
            // TODO
        }

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

        private final ImageButton imageButton;

        RecyclerViewHolder(RecyclerViewCellBinding dataBinding) {
            super(dataBinding.getRoot());
            this.dataBinding = dataBinding;
            this.imageButton = dataBinding.getRoot().findViewById(R.id.imageButton);
        }

        RecyclerViewCellBinding getDataBinding() {
            return dataBinding;
        }

        ImageButton getImageButton() {
            return imageButton;
        }
    }
}
