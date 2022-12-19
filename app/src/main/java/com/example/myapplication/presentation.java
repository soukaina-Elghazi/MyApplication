package com.example.myapplication;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
public class presentation extends AppCompatActivity {
    ListView mlistView;
    int[] imageView = {R.drawable.adidas1, R.drawable.adidas2, R.drawable.adidas3, R.drawable.adidas4, R.drawable.adidas5, R.drawable.adidas6, R.drawable.adidas8};
    String[] product_description_details = {"name1", "name2", "name3", "name4"};
    String[] product_name_details = {"des1", "des2", "des3", "des4"};
    String[] product_price_details = {"price", "price2", "price2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);
        mlistView = (ListView) findViewById(R.id.listview);
        myAdapter myAdapter = new myAdapter(presentation.this, product_name_details,
                product_price_details, product_description_details, imageView);
        mlistView.setAdapter(myAdapter);
        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(presentation.this, details.class);
                intent.putExtra("product_description_details", product_description_details[i]);
                intent.putExtra("product_name_details", product_name_details[i]);
                intent.putExtra("product_price_details", product_name_details[i]);
                intent.putExtra("imageView", imageView[i]);
                startActivity(intent);
            }});}}