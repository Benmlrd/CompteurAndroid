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
    private int count;

    public void setCount(int count2){
        count = count2;
    }

    public int getCount(){
         return count;
    }
}
