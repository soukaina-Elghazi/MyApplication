package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegister = (Button) findViewById(R.id.btnRegister);
btnRegister.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        login();
    }
});
    }
    public  void  login(){
        Intent intent= new Intent(this,activity_register.class);
        startActivity(intent);
    }
}