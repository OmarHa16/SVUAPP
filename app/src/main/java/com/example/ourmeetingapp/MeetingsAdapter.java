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

public class MeetingsAdapter extends RecyclerView.Adapter<MeetingsAdapter.meetingsVW> {

    List<meetings> meetingslist;

    public MeetingsAdapter(List<com.example.ourmeetingapp.meetings> meetingslist) {
        this.meetingslist = meetingslist;
    }

    @NonNull
    @Override
    public MeetingsAdapter.meetingsVW onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new meetingsVW(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingsAdapter.meetingsVW holder, int position) {
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
    public class meetingsVW extends RecyclerView.ViewHolder {
        TextView placeNameTxt, dateTxt, placeDesTxt, personNameTxt, personDesTxt;
        LinearLayout linearLayout;
        RelativeLayout expandablelayout;
        public meetingsVW(@NonNull View itemView) {
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

