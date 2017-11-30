package com.example.recyclerviewsample;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

        View view = mInflater.inflate(R.layout.recycler_view_cell, parent, false);
        // TODO: 1つの view として扱うならここで onClickListener.
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        final String data = mData.get(position);

        holder.getDataBinding().setVariable(com.example.recyclerviewsample.BR.item, new Items(data));

        holder.getDataBinding().executePendingBindings();

        holder.getDataBinding().getRoot().setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  // TODO:
                  Toast.makeText(view.getContext(), data, Toast.LENGTH_SHORT).show();
//                  Log.i("@@@@@@", "onClick ...........");
              }
          });
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

//        private ImageButton imageButton;

        private final ViewDataBinding dataBinding;

        RecyclerViewHolder(View itemView) {

            super(itemView);

//            imageButton = (ImageButton) itemView.findViewById(R.id.imageButton);

            dataBinding = DataBindingUtil.bind(itemView);
        }

//        public ImageButton getImageButton() {
//            return imageButton;
//        }

        ViewDataBinding getDataBinding() {
            return dataBinding;
        }

    }
}
