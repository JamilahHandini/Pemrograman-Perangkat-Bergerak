package com.example.hogwartsnotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Fragment temp;
    TextView textView;

    @Override
    public void setContentView(View view) {
        textView = findViewById(R.id.to_do);
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base, null);
        FrameLayout container = drawerLayout.findViewById(R.id.activityContainer);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.todo_:
                temp = new FragmentRecycler();
                //textView.setText("To Do");
                Toast.makeText(DrawerBaseActivity.this, "todo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.doing:
                temp = new Fragment_Doing();
               // textView.setText("Do");
                Toast.makeText(DrawerBaseActivity.this, "doing", Toast.LENGTH_SHORT).show();
                break;
            case R.id.done:
                temp = new FragmentRecycler2();
                //textView.setText("Done");
                Toast.makeText(DrawerBaseActivity.this, "done", Toast.LENGTH_SHORT).show();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id .container,temp).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }




}