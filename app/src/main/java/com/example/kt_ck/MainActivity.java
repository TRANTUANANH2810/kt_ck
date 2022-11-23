package com.example.kt_ck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kt_ck.Sqlite.DBHelper;

public class MainActivity extends AppCompatActivity {

    Button btnsignin, btnsignup;
    EditText txtName,txtPw;
    BDHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsignin = (Button) findViewById(R.id.btnlogin);
        btnsignup = (Button) findViewById(R.id.btnsinup1);
        txtName = (EditText) findViewById(R.id.editTextName);
        txtPw = (EditText) findViewById(R.id.editTextPass);
        DB = new BDHelper(this);
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = txtName.getText().toString();
                String pass = txtPw.getText().toString();


                if(user.equals("")||pass.equals(""))
                    Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(MainActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), BottomNavigationBar.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOpenSignUpActivity();
            }
        });

    }
    public void doOpenNavActivity()
    {
        Intent myIntent=new Intent(this, BottomNavigationBar.class);
        startActivity(myIntent);
    }
    public void doOpenSignUpActivity()
    {
        Intent myIntent=new Intent(this, SignUp.class);
        startActivity(myIntent);
    }
}