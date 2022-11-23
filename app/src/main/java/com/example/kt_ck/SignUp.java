package com.example.kt_ck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.kt_ck.Sqlite.DBHelper;

public class SignUp extends AppCompatActivity {
    EditText edtuser,edtpw,edtrspw;
    Button btnsgup,btnback;
    BDHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtuser = (EditText) findViewById(R.id.editTextName2);
        edtpw = (EditText) findViewById(R.id.editTextPw2);
        edtrspw = (EditText) findViewById(R.id.editTextRspw);
        btnsgup = (Button) findViewById(R.id.btnsignup);
        btnback = (Button) findViewById(R.id.btnbacklogin);
        DB = new BDHelper(this);
        btnsgup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtuser.getText().toString();
                String pass = edtpw.getText().toString();
                String repass = edtrspw.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(SignUp.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(SignUp.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(SignUp.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SignUp.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignUp.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doBackLoginActivity();
            }
        });
    }
    public void doBackLoginActivity()
    {
        Intent myIntent=new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}