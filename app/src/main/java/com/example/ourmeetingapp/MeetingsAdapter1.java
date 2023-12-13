package com.example.ourmeetingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MeetingsAdapter1 extends RecyclerView.Adapter<MeetingsAdapter1.meetingsVW1> {

    List<meetings> meetingslist;

    public MeetingsAdapter1(List<com.example.ourmeetingapp.meetings> meetingslist) {
        this.meetingslist = meetingslist;
    }

    @NonNull
    @Override
    public MeetingsAdapter1.meetingsVW1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row1, parent, false);
        return new meetingsVW1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingsAdapter1.meetingsVW1 holder, int position) {
        meetings meeting = meetingslist.get(position);
        holder.placeNameTxt.setText(meeting.getPlaceName());
        holder.placeDesTxt.setText(meeting.getPlaceDes());
        holder.personNameTxt.setText(meeting.getPersonName());
        holder.personDesTxt.setText(meeting.getPersonDes());
        holder.dateTxt.setText(meeting.getDate().toString());

        boolean isExpandable = meetingslist.get(position).getExpandable();
        holder.expandablelayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return meetingslist.size();
    }
    public class meetingsVW1 extends RecyclerView.ViewHolder {
        TextView placeNameTxt, dateTxt, placeDesTxt, personNameTxt, personDesTxt;
        LinearLayout linearLayout;
        RelativeLayout expandablelayout;
        public meetingsVW1(@NonNull View itemView) {
            super(itemView);
            placeNameTxt = itemView.findViewById(R.id.placeName);
            dateTxt = itemView.findViewById(R.id.date);
            placeDesTxt = itemView.findViewById(R.id.placeDescrptionOnRight);
            personNameTxt = itemView.findViewById(R.id.personNameOnRight);
            personDesTxt = itemView.findViewById(R.id.placeDescrptionOnRight);

            linearLayout = itemView.findViewById(R.id.linear_layout);
            expandablelayout = itemView.findViewById(R.id.expandable_layout);

            linearLayout.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    meetings meeting = meetingslist.get(getAdapterPosition());
                    meeting.setExpandable(!meeting.getExpandable());
                    notifyItemChanged(getAdapterPosition());
                }


            });
        }
    }
}

