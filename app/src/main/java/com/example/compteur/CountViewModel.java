package com.example.compteur;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class CountViewModel extends ViewModel {
    MutableLiveData<List<Integer>> count;


    public void setCount(List<Integer> count2){
        count.setValue(count2);
    }

    public LiveData<List<Integer>> getCount(){
        if (count == null){
            count = new MutableLiveData<>();
            loadCount();
        }
        return count;
    }

    private void loadCount(){
        Handler myHandler = new Handler();
        myHandler.postDelayed(() -> {
            List<Integer> countSample = new ArrayList<>();
            countSample.add(0);
            long seed = System.nanoTime();
            Collections.shuffle(countSample, new Random(seed));
            count.setValue(countSample);
        }, 5000);
    }

}
