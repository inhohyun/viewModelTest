package com.ihh.viewmodeltest;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {
    private MutableLiveData<String> userId;

    public ViewModel(){
        userId = new MutableLiveData<>();
    }
    public void setUserInfo(String id) {
        userId.setValue(id);
    }
    public LiveData<String> getUserId() {
        return userId;
    }

    public void initData(){
        userId.setValue(" ");

    }
}
