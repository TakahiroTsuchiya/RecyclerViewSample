package com.example.recyclerviewsample;

import android.databinding.ObservableField;

public class Items  {

    public String itemName = "dummy data";
    public final ObservableField itemFilePath = new ObservableField<>();

    public Items(String itemName) {
        this.itemName = itemName;
    }
}
