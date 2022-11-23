package com.example.kt_ck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    Button btnPro,btnlgout,btnList;
    private BottomNavigationView btnnav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnPro = (Button) findViewById(R.id.btnProfile);
        btnList = (Button) findViewById(R.id.btnListView);
        btnlgout = (Button) findViewById(R.id.btnLogout);
        btnPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doOpenProfileActivity();
            }
        });
        btnlgout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doOpenLoginActivity();
            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOpenListView1Activity();
            }
        });
        btnnav = (BottomNavigationView) findViewById(R.id.button_navi);
        //vpger = (ViewPager)findViewById(R.id.view_pager);

        btnnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        doOpenHomeActivity();
                        Toast.makeText(Home.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_profile:
                        doOpenProfileActivity();
                        Toast.makeText(Home.this, "Profile", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_list:
                        doOpenListViewActivity();
                        Toast.makeText(Home.this, "List", Toast.LENGTH_SHORT).show();
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
    public void doOpenLoginActivity()
    {
        Intent myIntent=new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
    public void doOpenListView1Activity()
    {
        Intent myIntent=new Intent(this, listView.class);
        startActivity(myIntent);
    }
    public void doOpenListViewActivity()
    {
        Intent myIntent=new Intent(this, ListviewSinhvien.class);
        startActivity(myIntent);
    }
}