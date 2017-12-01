package com.example.recyclerviewsample;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class Items extends BaseObservable {

    private String itemName = "dummy data";
    ObservableField<String> itemFilePath = new ObservableField<>();

    Items(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
