package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_login extends AppCompatActivity {

    EditText inputEmail,inputPassword;
    Button btnlogin;
    Dbhelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail=findViewById(R.id.inputEmail);
        inputPassword=findViewById(R.id.inputPassword);
        btnlogin=findViewById(R.id.btnlogin);
        DB=new Dbhelper(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = inputEmail.getText().toString();
                String pass = inputPassword.getText().toString();

                if(TextUtils.isEmpty(Email)||TextUtils.isEmpty(pass))
                    Toast.makeText(activity_login.this,"all fields Required",Toast.LENGTH_SHORT).show();
                else
                {
                  Boolean chekuserpass=DB.checkPassword(Email,pass);
                       if(chekuserpass==true)
                       {
                           Toast.makeText(activity_login.this,"Login Successful",Toast.LENGTH_SHORT).show();
                           Intent intent = new Intent(getApplicationContext(), presentation.class);
                           startActivity(intent);
                       } else
                       {
                           Toast.makeText(activity_login.this,"Login Failed",Toast.LENGTH_SHORT).show();

                       }}}
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), presentation.class);
                startActivity(intent);
            }
        });
    }
}






