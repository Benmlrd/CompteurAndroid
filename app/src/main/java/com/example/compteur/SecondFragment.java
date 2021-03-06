package com.example.compteur;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.*;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.preference.PreferenceManager;

import java.util.Objects;

public class SecondFragment extends Fragment {
    private int count = 0;
    private SharedPreferences prefs;
    private boolean switchPref;
    //On créée le viewModel par rapport à la classe que l'on a fait
    private CountViewModel viewModel;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_retour).setOnClickListener(view1 -> NavHostFragment.findNavController(SecondFragment.this)
                .navigate(R.id.action_SecondFragment_to_FirstFragment));

         viewModel = new ViewModelProvider(requireActivity()).get(CountViewModel.class);

       count = viewModel.getCount();
        modifyViewText(count);

        //Liaison entre les boutons et les fonctions
        //view.findViewById(R.id.action_settings).setOnClickListener(view1 -> NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.action_SecondFragment_to_SettingsFragment));
        view.findViewById(R.id.button_plus).setOnClickListener(view1 -> addition());
        view.findViewById(R.id.button_moins).setOnClickListener(view1 -> subtraction());
        view.findViewById(R.id.button_raz).setOnClickListener(view1 -> raz());

        prefs = PreferenceManager.getDefaultSharedPreferences(requireContext());
        switchPref = prefs.getBoolean("neg_values", false);
    }

    private void addition(){
        count++;
        modifyViewText(count);
        viewModel.setCount(count);
    }

    private void subtraction(){
        if ((count > 0) || (switchPref)){
            count--;
            modifyViewText(count);
            viewModel.setCount(count);
        }
    }


    private void modifyViewText(int count){
        String count3 = String.valueOf(count);
        TextView t = getView().findViewById(R.id.textview_nombre);
        t.setText(count3);
    }

    private void raz(){
        count = 0;
        modifyViewText(count);
        viewModel.setCount(count);
    }

}