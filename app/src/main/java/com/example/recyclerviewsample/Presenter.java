package com.example.recyclerviewsample;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Presenter {

    private final String TAG = this.getClass().getSimpleName();

    public void onClick(Items item) {

        Log.i(TAG + "@@@@@@@@", "getItemName : " + item.getItemName() + "@@@@@@@@@@@@");
    }

    public void onClick2(View view, Items item) {

        Toast.makeText(view.getContext(), "@@@@@@@@" + item.itemFilePath.get(), Toast.LENGTH_SHORT).show();
        Log.i(TAG + "@@@@@@@@", "itemFilePath : " + item.itemFilePath.get() + "@@@@@@@@@@@@");
    }
}
