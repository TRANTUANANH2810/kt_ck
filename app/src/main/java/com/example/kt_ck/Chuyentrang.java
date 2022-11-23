package com.example.kt_ck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Chuyentrang extends AppCompatActivity {
    TextView tvname,tvmota;
    ImageView imghtview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_chuyentrang);
        tvname = (TextView) findViewById(R.id.tv_name);
        imghtview = (ImageView) findViewById(R.id.imgviewht);
        tvmota = (TextView) findViewById(R.id.tv_mota);
        tvname.setText(intent.getStringExtra("title"));
        tvmota.setText(intent.getStringExtra("des"));
        imghtview.setImageResource(intent.getIntExtra("image",R.id.imageview));
    }
}