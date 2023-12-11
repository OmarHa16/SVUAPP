package com.example.ourmeetingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ourmeetingapp.databinding.ActivityMainBinding;
import com.example.ourmeetingapp.databinding.FragmentMainMeetingsfragmentBinding;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class mainMeetingsfragment extends Fragment {
    FragmentMainMeetingsfragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainMeetingsfragmentBinding.inflate(inflater, container, false);

        R_F(new mainmeetings());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            if(item.getItemId() == R.id.todaysmeetings){
                R_F(new mainmeetings());
            } else if (item.getItemId() == R.id.forwordmeetings) {
                R_F(new forwordmeetings());
            } else if (item.getItemId() == R.id.outlinemeetings) {
                R_F(new outlinemeetings());
            }


            return true;
        });
        // Access views in your layout
        return binding.getRoot();
    }

    private void R_F(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();
    }
}