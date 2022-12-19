package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
public class details extends AppCompatActivity {
    ImageView product_image_details;TextView product_name_details;TextView product_description_details;TextView product_price_details;
    Button increment, decrement;TextView display;
    int count=0;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        increment=findViewById(R.id.increment_btn2);decrement=findViewById(R.id.decrement_btn2);display=findViewById(R.id.tx_display2);
        increment.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                count++;
                display.setText(""+count);}});
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                if(count<=0) count=0;
                else count--;
                display.setText(""+count);}});
        product_image_details=(ImageView) findViewById(R.id.product_image_details);
        product_name_details=(TextView) findViewById(R.id.product_name_details);
        product_description_details=(TextView) findViewById(R.id.product_description_details);
        product_price_details=(TextView) findViewById(R.id.product_price_details);
        Bundle  mBundle =getIntent().getExtras();
        if(mBundle!= null)
        {product_image_details.setImageResource(mBundle.getInt("imageView"));}}}