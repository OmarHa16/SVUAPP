package com.example.ourmeetingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.f_containor, new mainMeetingsfragment()).commit();
            navigationView.setCheckedItem(R.id.nav_mainmeetings);
        }
    }
    //ignore red lines errors

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.nav_mainmeetings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.f_containor, new mainMeetingsfragment()).commit();
        } else if (item.getItemId()==R.id.nav_add) {
            getSupportFragmentManager().beginTransaction().replace(R.id.f_containor, new addfragment()).commit();
        } else if (item.getItemId()==R.id.nav_info) {
            getSupportFragmentManager().beginTransaction().replace(R.id.f_containor, new infofragment()).commit();
        } else if (item.getItemId()==R.id.nav_settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.f_containor, new settingsfragment()).commit();
        } else if (item.getItemId()==R.id.nav_logout) {
            Toast.makeText(this, "logout!", Toast.LENGTH_SHORT).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer((GravityCompat.START));
        }else {
            super.onBackPressed();
        }
    }
}
