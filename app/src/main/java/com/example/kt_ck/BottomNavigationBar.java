package com.example.kt_ck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationBar extends AppCompatActivity {
    private BottomNavigationView btnnav;
    //private ViewPager vpger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_bar);
        btnnav = (BottomNavigationView) findViewById(R.id.button_navi);
        //vpger = (ViewPager)findViewById(R.id.view_pager);

        btnnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        doOpenHomeActivity();
                        Toast.makeText(BottomNavigationBar.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_profile:
                        doOpenProfileActivity();
                        Toast.makeText(BottomNavigationBar.this, "Profile", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_list:
                        doOpenListViewActivity();
                        Toast.makeText(BottomNavigationBar.this, "List", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    public void doOpenHomeActivity()
    {
        Intent myIntent=new Intent(this, Home.class);
        startActivity(myIntent);
    }
    public void doOpenProfileActivity()
    {
        Intent myIntent=new Intent(this, Profile.class);
        startActivity(myIntent);
    }
    public void doOpenListViewActivity()
    {
        Intent myIntent=new Intent(this, ListviewSinhvien.class);
        startActivity(myIntent);
    }
}