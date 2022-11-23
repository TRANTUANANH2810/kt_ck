package com.example.kt_ck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button btnlgout2 = (Button) findViewById(R.id.btnlogout2);
        btnlgout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOpenLoginActivity();
            }
        });
    }
    public void doOpenLoginActivity()
    {
        Intent myIntent=new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}