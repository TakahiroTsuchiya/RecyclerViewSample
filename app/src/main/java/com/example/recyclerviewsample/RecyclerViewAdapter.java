package com.example.recyclerviewsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final LayoutInflater mInflater;
    private List<String> mData;

    public RecyclerViewAdapter(Context context, List<String> data) {
        mInflater = LayoutInflater.from(context);
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(mInflater.inflate(R.layout.recycler_view_cell, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

//        holder.textView.setText(mData.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO:
                Log.i("@@@@@@", "onClick ...........");
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

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemView) {

            super(itemView);

            textView = (TextView)itemView.findViewById(R.id.text);
        }
    }
}
