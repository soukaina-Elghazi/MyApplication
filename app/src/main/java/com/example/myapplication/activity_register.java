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

import java.util.Locale;

public class activity_register extends AppCompatActivity {
EditText inputUsername,inputPassword,inputConformPassword;
Button btnRegister,alreadyHaveAccount;
Dbhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputUsername=findViewById(R.id.inputUsername);
        inputPassword=findViewById(R.id.inputPassword);
        inputConformPassword=findViewById(R.id.inputConformPassword);
        btnRegister = findViewById(R.id.btnRegister);
        alreadyHaveAccount=findViewById(R.id.alreadyHaveAccount);
        DB=new Dbhelper(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = inputUsername.getText().toString();
                String pass = inputPassword.getText().toString();
                String Confirm = inputConformPassword.getText().toString();
                //Check if fields are empty or not if it empty show toast message
                // else ChekUserName , if it false insert data else registration faild
                // if chekUserName true, toast user already exist
                if (TextUtils.isEmpty(Username) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(Confirm))
                    Toast.makeText(activity_register.this, "all fileds Required", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(Confirm)) {
                        Boolean checkuser = DB.checkusername(Username);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(Username, pass);
                            if (insert == true) {
                                Toast.makeText(activity_register.this, "Registred Successfuly", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), activity_login.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(activity_register.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }}else {
                                Toast.makeText(activity_register.this, "UserName already Exists", Toast.LENGTH_SHORT).show();
                            }
                        }else
                        {
                            Toast.makeText(activity_register.this,"password are not matching",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        btnRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), presentation.class);
                        startActivity(intent);
                    }
                });
        alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), activity_login.class);
                startActivity(intent);
            }
        });

        }
    }



