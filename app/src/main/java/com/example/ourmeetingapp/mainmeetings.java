package com.example.ourmeetingapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class mainmeetings extends Fragment {

    RecyclerView recycler;
    List<meetings> meetingsList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mainmeetings, container, false);
        recycler = view.findViewById(R.id.recyclerView);
        initData();
        setRecyclerView();

        return view;
    }

    private void setRecyclerView() {
        MeetingsAdapter meetingsAdapter = new MeetingsAdapter(meetingsList);
        recycler.setAdapter(meetingsAdapter);
        recycler.setHasFixedSize(true);
    }

    private void initData() {
        meetingsList = new ArrayList<>();
        meetingsList.add(new meetings("school", Calendar.getInstance().getTime(),"my study place","Ahmed","my teacher"));
        meetingsList.add(new meetings("company", Calendar.getInstance().getTime(),"my work place","Hasan","my Boss"));
        meetingsList.add(new meetings("majls", Calendar.getInstance().getTime(),"my prey place","Yousf","my Father"));
        meetingsList.add(new meetings("office", Calendar.getInstance().getTime(),"my work office","Mohamed","my colleague"));
        meetingsList.add(new meetings("resturant", Calendar.getInstance().getTime(),"beside my home","Abeer","my Love"));
        meetingsList.add(new meetings("university", Calendar.getInstance().getTime(),"my study place","Omar","my Doctor"));
        meetingsList.add(new meetings("coffee", Calendar.getInstance().getTime(),"near my place","Sawsan","my Friend"));
        meetingsList.add(new meetings("park", Calendar.getInstance().getTime(),"in the middle of the city","Dana","my Friend"));

    }
}