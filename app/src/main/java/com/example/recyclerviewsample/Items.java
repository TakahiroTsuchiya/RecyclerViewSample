package com.example.recyclerviewsample;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class Items extends BaseObservable {

    private String itemName = "dummy data";
    public final ObservableField itemFilePath = new ObservableField<>();

    public Items(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
