package com.example.ourmeetingapp;

import static android.content.Context.MODE_PRIVATE;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import android.content.SharedPreferences;
import android.widget.Button;

import androidx.fragment.app.Fragment;
public class settingsfragment extends Fragment {
    Toolbar mToolbar;
    Button mBlueColor;
    Button mGreenColor;
    Button mGreyColor;
    Button mVioletColor;
    Button mPinkColor;
    Button mBrownColor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_settingsfragment, container, false);

        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.fragment_settingsfragment);
        mToolbar=(Toolbar)view.findViewById(R.id.toolbar_settings);
        mBlueColor=(Button)view. findViewById(R.id.blue_color);
        mGreenColor=(Button)view. findViewById(R.id.green_color);
        mGreyColor=(Button) view.findViewById(R.id.grey_color);
        mVioletColor=(Button)view. findViewById(R.id.violet_color);
        mPinkColor=(Button) view.findViewById(R.id.pink_color);
        mBrownColor=(Button) view.findViewById(R.id.brown_color);

        if (getColor()!=getResources().getColor(R.color.lav)){
            mToolbar.setBackgroundColor(getColor());
        }

        mBlueColor.setOnClickListener(v -> {
            mToolbar.setBackgroundColor(getResources().getColor(R.color.colorBlue));
        /* if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
             getWindow(getResources().getColor(R.id.blue_color));
         }*/
            storeColor(getResources().getColor(R.color.colorBlue));
        });
        mGreenColor.setOnClickListener(v -> {
            mToolbar.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            storeColor(getResources().getColor(R.color.colorGreen));
        });
        mGreyColor.setOnClickListener(v -> {
            mToolbar.setBackgroundColor(getResources().getColor(R.color.colorGrey));
            storeColor(getResources().getColor(R.color.colorGrey));
        });
        mVioletColor.setOnClickListener(v -> {
            mToolbar.setBackgroundColor(getResources().getColor(R.color.colorViolet));
            storeColor(getResources().getColor(R.color.colorViolet));
        });
        mPinkColor.setOnClickListener(v -> {
            mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPink));
            storeColor(getResources().getColor(R.color.colorPink));
        });
        mBrownColor.setOnClickListener(v -> {
            mToolbar.setBackgroundColor(getResources().getColor(R.color.colorBrown));
            storeColor(getResources().getColor(R.color.colorBrown));
        });

      return  view ;
    }

    private void storeColor(int color){
        SharedPreferences mSharedPreferencesre = getContext().getSharedPreferences("Toolbar",MODE_PRIVATE);
        SharedPreferences.Editor mEditor=mSharedPreferencesre.edit();
        mEditor.putInt("color",color);
        mEditor.apply();
    }
    private int getColor(){
        SharedPreferences mSharedPreferencesre = getContext().getSharedPreferences("Toolbar",MODE_PRIVATE);
        int selectedColor= mSharedPreferencesre.getInt("color",getResources().getColor(R.color.lav));
        return selectedColor;
    }


}
