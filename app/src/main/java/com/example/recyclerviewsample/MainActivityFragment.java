package com.example.recyclerviewsample;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerviewsample.databinding.FragmentMainBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // set data binding -------------

//        FragmentMainBinding binding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_main);
//
//        Items item = new Items("first Item");
//        item.itemFilePath.set("first File Path.");
//
//        binding.setItem(item);

        // set recycler view -------------
        mRecyclerView = rootView.findViewById(R.id.recyclerView_base);

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            data.add("item " + i);
        }

        mRecyclerViewAdapter = new RecyclerViewAdapter(getContext(), data);
        // TODO: display size, to span-count.
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        return  rootView;
    }
}
