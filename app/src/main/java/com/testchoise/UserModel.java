package com.testchoise;

import androidx.databinding.ObservableField;

public class UserModel implements ItemModel {

    public  UserModel(String name){
        this.name.set(name);
    }

    public ObservableField<String> name = new ObservableField<>("Test");
}
