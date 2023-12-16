package com.example.ourmeetingapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.fragment.app.Fragment;


public class settingsfragment extends Fragment {

      SharedPreferences sharedPreferences;
      SharedPreferences.Editor editor;
      Button button;
      Methods methods;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_infofragment, container, false);
        // Inflate the layout for this fragment
       setTheme(Constant.theme);
        setContentView(R.layout.fragment_settingsfragment);


        final Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_settings);
        toolbar.setTitle("Settings");
        toolbar.setBackgroundColor(Constant.color);

        methods = new Methods();
        button = (Button) view.findViewById(R.id.button);
        sharedPreferences = getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        colorize();

        button.setOnClickListener(v -> {
            ColorChooserDialog dialog = new ColorChooserDialog(settingsfragment.this);
            dialog.setTitle("Select");
            dialog.setColorListener(new ColorListener() {
                @Override
                public void OnColorClick(View v, int color) {
                    colorize();
                    Constant.color = color;

                    methods.setColorTheme();
                    editor.putInt("color", color);
                    editor.putInt("theme",Constant.theme);
                    editor.commit();

                    Intent intent = new Intent(settingsfragment.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            });

            dialog.show();
        });
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void colorize(){
        ShapeDrawable d = new ShapeDrawable(new OvalShape());
        d.setBounds(58, 58, 58, 58);

        d.getPaint().setStyle(Paint.Style.FILL);
        d.getPaint().setColor(Constant.color);

        button.setBackground(d);
    }



}
